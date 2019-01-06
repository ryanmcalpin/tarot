package com.example.rygn.tarot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.rygn.tarot.Deck;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Deck deck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        deck = new Deck();
        List<String> cards = deck.getCards();


        Log.d("RRR", "DECK: " + cards);
        Log.d("RRR", "SIZE: " + cards.size());

        String testCard = drawCard(cards);

        Log.d("RRR", "CARD: " + testCard);
        Log.d("RRR", "NEWsIZE: " + cards.size());
    }

    public String drawCard(List<String> cards) {
        String card = cards.get(0);
        cards.remove(0);
        return card;
    }
}
