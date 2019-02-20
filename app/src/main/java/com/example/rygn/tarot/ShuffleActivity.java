package com.example.rygn.tarot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShuffleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        final Intent newIntent = new Intent(ShuffleActivity.this, SpreadActivity.class);
        newIntent.putExtra("spread", intent.getStringExtra("spread"));
        newIntent.putExtra("amount", intent.getIntExtra("amount", 0));

        setContentView(R.layout.activity_shuffle);

        Button drawCardsButton = (Button) findViewById(R.id.draw_cards_button);
        drawCardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(newIntent);
            }
        });
    }

}
