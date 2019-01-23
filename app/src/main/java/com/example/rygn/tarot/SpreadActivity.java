package com.example.rygn.tarot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpreadActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ppf_spread);

        ImageView pastCard = findViewById(R.id.past_img_view);
        ImageView presentCard = findViewById(R.id.present_img_view);
        ImageView futureCard = findViewById(R.id.future_img_view);

        pastCard.setOnClickListener(this);
        presentCard.setOnClickListener(this);
        futureCard.setOnClickListener(this);

        TextView testView = findViewById(R.id.test_text_view);

        List<Card> deck = new Deck().getCards();

        List<Card> testSpread = drawCards(deck, 3);

        String spreadText = "";
        for (int i = 0; i < testSpread.size(); i++) {
            Card card = testSpread.get(i);
            spreadText += card.title;
            if (card.reversed) {
                spreadText += " (r)";
            }
            if (i + 1 != testSpread.size()) {
                spreadText += " | ";
            }
        }
        testView.setText(spreadText);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.past_img_view:
                Log.d("RRR", "onClick: " + "past");
                break;

            case R.id.present_img_view:
                Log.d("RRR", "onClick: " + "present");
                break;

            case R.id.future_img_view:
                Log.d("RRR", "onClick: " + "future");
                break;

            default:
                Log.d("RRR", "onClick: " + "whoops");
                break;
        }
    }

    public List<Card> drawCards(List<Card> deck, int amount) {
        List<Card> drawnCards = new ArrayList<Card>();
        Random r = new Random();

        int currentDeckSize = deck.size();
        for (int i = 0; i < amount; i++) {
            int rand = r.nextInt(currentDeckSize + 1);
            Card card = deck.get(rand);
            boolean orientation = r.nextBoolean();
            card.setReversed(orientation);
            drawnCards.add(card);
            deck.remove(rand);
            currentDeckSize -= 1;
        }
        return drawnCards;
    }
}
