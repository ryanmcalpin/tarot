package com.example.rygn.tarot;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpreadActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView pastCardView;
    ImageView presentCardView;
    ImageView futureCardView;
    List<Card> spread;
    List<ImageView> cardViews = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ppf_spread);

        pastCardView = findViewById(R.id.past_img_view);
        presentCardView = findViewById(R.id.present_img_view);
        futureCardView = findViewById(R.id.future_img_view);

        cardViews.add(pastCardView);
        cardViews.add(presentCardView);
        cardViews.add(futureCardView);

        pastCardView.setOnClickListener(this);
        presentCardView.setOnClickListener(this);
        futureCardView.setOnClickListener(this);

        List<Card> deck = new Deck().getCards();

        Log.d("RRR", "onCreate: " + deck.size());

        spread = drawCards(deck, 3);

        displayCards();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.past_img_view:
                showDialogFrag(0);
                break;

            case R.id.present_img_view:
                showDialogFrag(1);
                break;

            case R.id.future_img_view:
                showDialogFrag(2);
                break;

            default:
                Log.d("RRR", "onClick: " + "whoops");
                break;
        }
    }

    public void displayCards() {
        for (int i = 0; i < spread.size(); i++) {
            cardViews.get(i).setImageDrawable(getDrawable(spread.get(i).resId));
            if (spread.get(i).reversed) {
                cardViews.get(i).setRotation(180);
            }
        }
    }

    public void showDialogFrag(int i) {
        Card card = spread.get(i);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String rev = "";
        String mes = card.description;
        if (card.reversed) {
            rev = " (reversed)";
            mes = card.rDescription;
        }
        builder.setMessage(mes)
                .setTitle(card.title + rev).show();
    }

    public List<Card> drawCards(List<Card> deck, int amount) {
        List<Card> drawnCards = new ArrayList<Card>();
        Random r = new Random();

        int currentDeckSize = deck.size();
        for (int i = 0; i < amount; i++) {
            int rand = r.nextInt(currentDeckSize);
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
