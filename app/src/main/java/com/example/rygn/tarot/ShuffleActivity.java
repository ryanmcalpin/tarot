package com.example.rygn.tarot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ShuffleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_shuffle);

        final Intent newIntent = new Intent(ShuffleActivity.this, SpreadActivity.class);
        newIntent.putExtra("spread", intent.getStringExtra("spread"));
        newIntent.putExtra("amount", intent.getIntExtra("amount", 0));

        TextView titleTextView = (TextView) findViewById(R.id.spread_title_view);
        TextView explanationTextView = (TextView) findViewById(R.id.spread_explanation_view);

        titleTextView.setText(intent.getStringExtra("fullName"));

        Button drawCardsButton = (Button) findViewById(R.id.draw_cards_button);
        drawCardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(newIntent);
            }
        });
    }

}
