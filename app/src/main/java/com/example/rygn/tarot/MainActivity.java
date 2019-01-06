package com.example.rygn.tarot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.rygn.tarot.Deck;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> deck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        deck = new Deck().getDeck();

        Log.d("RRR", "onCreate: " + deck);
    }
}
