package com.example.rygn.tarot;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SpreadActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "RRR";
    List<Card> spread;
    List<ImageView> cardViews = new ArrayList<>();
    String spreadType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        int cardAmount = intent.getIntExtra("amount", 0);
        spreadType = intent.getStringExtra("spread");

        switch (spreadType) {
            case "ppf":
                setContentView(R.layout.ppf_spread);
                break;

            case "cc":
                setContentView(R.layout.cc_spread);
                break;

            default:
                Log.d("RRR", "onCreate: " + "whoops");
                break;
        }

        cardViews.add((ImageView) findViewById(R.id.card_view_1));
        cardViews.add((ImageView) findViewById(R.id.card_view_2));
        cardViews.add((ImageView) findViewById(R.id.card_view_3));

        if (cardAmount > 3) {
            cardViews.add((ImageView) findViewById(R.id.card_view_4));
            cardViews.add((ImageView) findViewById(R.id.card_view_5));
            cardViews.add((ImageView) findViewById(R.id.card_view_6));
            cardViews.add((ImageView) findViewById(R.id.card_view_7));
            cardViews.add((ImageView) findViewById(R.id.card_view_8));
            cardViews.add((ImageView) findViewById(R.id.card_view_9));
            cardViews.add((ImageView) findViewById(R.id.card_view_10));
        }

        for (int i = 0; i < cardViews.size(); i++) {
            cardViews.get(i).setOnClickListener(this);
        }

        List<Card> deck = new Deck().getCards();

        spread = drawCards(deck, cardAmount);

        displayCards();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.spread_options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.saveSpread:
                saveSpread();
                return true;
            case R.id.t2:
                Toast.makeText(this, "yo2", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View view) {
        int i = Integer.parseInt(view.getTag().toString()) - 1;
        showDialogFrag(i);
    }

    public void displayCards() {
        for (int i = 0; i < spread.size(); i++) {
            cardViews.get(i).setImageDrawable(getDrawable(spread.get(i).imageId));
            if (spread.size() == 10 && i == 1) {
                cardViews.get(i).setRotation(270);
                if (spread.get(i).reversed) {
                    cardViews.get(i).setRotation(90);
                }
            } else if (spread.get(i).reversed) {
                cardViews.get(i).setRotation(180);
            }
        }
    }

    public void showDialogFrag(int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = LayoutInflater.from(this);

        final View view = inflater.inflate(R.layout.dialog_view, null);
        TextView titleView = view.findViewById(R.id.title_view);
        ImageView imageView = view.findViewById(R.id.dialog_image_view);
        TextView descriptionView = view.findViewById(R.id.description_view);

        Card card = spread.get(i);

        imageView.setImageResource(card.imageId);
        int mesId = card.descriptionId;
        String rev = "";

        if (card.reversed) {
            rev = " (reversed)";
            mesId = card.rDescriptionId;
            imageView.setRotation(180);
        }

        titleView.setText(card.title + rev);
        descriptionView.setText(getString(mesId));

//        descriptionView.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);

        builder.setView(view).show();
    }

    public List<Card> drawCards(List<Card> deck, int amount) {
        List<Card> drawnCards = new ArrayList<Card>();
        Random r = new Random();

        int currentDeckSize = deck.size();
        for (int i = 0; i < amount; i++) {
            int rand = r.nextInt(currentDeckSize);
            Card card = deck.get(rand);
            card.i = rand;
            boolean orientation = r.nextBoolean();
            card.setReversed(orientation);
            drawnCards.add(card);
            deck.remove(rand);
            currentDeckSize -= 1;
        }
        return drawnCards;
    }

    public void saveSpread() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference testSpreads = db.collection("testSpreads");

        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < spread.size(); i++){
            indices.add(spread.get(i).i);
        }

        Map<String, Object> spreadSave = new HashMap<>();
        spreadSave.put("type", spreadType);
        spreadSave.put("indices", indices);

        testSpreads.document("spread1").set(spreadSave);

    }
}
