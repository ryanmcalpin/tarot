package com.example.rygn.tarot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.rygn.tarot.Deck;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Deck deck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> deck = new Deck().getCards();


        Log.d("RRR", "DECK: " + deck);
        Log.d("RRR", "SIZE: " + deck.size());

        List<String> testSpread = drawCards(deck, 3);

        Log.d("RRR", "SPREAD: " + testSpread);
        Log.d("RRR", "NEWsIZE: " + deck.size());
    }

    public List<String> drawCards(List<String> deck, int amount) {
        List<String> spread = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < amount; i++) {
            int rand = r.nextInt(deck.size() + 1);
            spread.add(deck.get(rand));
            deck.remove(rand);
        }
        return spread;
    }
}
