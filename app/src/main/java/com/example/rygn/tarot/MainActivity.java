package com.example.rygn.tarot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

//    private Deck deck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
