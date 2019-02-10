package com.example.rygn.tarot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button ppfButton = findViewById(R.id.ppf_button);
        Button ccButton = findViewById(R.id.cc_button);
        ppfButton.setOnClickListener(this);
        ccButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MenuActivity.this, SpreadActivity.class);
        switch (v.getId()){
            case R.id.ppf_button:
                intent.putExtra("spread", "ppf");
                intent.putExtra("amount", 3);
                break;

            case R.id.cc_button:
                intent.putExtra("spread", "cc");
                intent.putExtra("amount", 10);
                break;

             default:
                Log.d("RRR", "onClick: " + "whoops");
                break;
        }
        startActivity(intent);
    }
}
