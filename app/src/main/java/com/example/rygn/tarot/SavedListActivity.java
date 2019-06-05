package com.example.rygn.tarot;import android.content.Intent;import android.support.annotation.NonNull;import android.support.v7.app.AppCompatActivity;import android.os.Bundle;import android.util.Log;import android.view.View;import android.widget.Button;import android.widget.Toast;import com.google.android.gms.tasks.OnCompleteListener;import com.google.android.gms.tasks.OnFailureListener;import com.google.android.gms.tasks.OnSuccessListener;import com.google.android.gms.tasks.Task;import com.google.firebase.firestore.DocumentReference;import com.google.firebase.firestore.DocumentSnapshot;import com.google.firebase.firestore.FirebaseFirestore;import java.util.ArrayList;import java.util.HashMap;import java.util.Map;public class SavedListActivity extends AppCompatActivity implements View.OnClickListener {    private static final String TAG = "SavedListActivity";    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_saved_list);        FirebaseFirestore db = FirebaseFirestore.getInstance();        DocumentReference docRef = db.collection("testSpreads").document("spread1");        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {            @Override            public void onComplete(@NonNull Task<DocumentSnapshot> task) {                if (task.isSuccessful()) {                    DocumentSnapshot document = task.getResult();                    if (document.exists()) {                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());                    } else {                        Log.d(TAG, "No such document");                    }                } else {                    Log.d(TAG, "get failed with ", task.getException());                }            }        });        Button button = (Button) findViewById(R.id.test_button);        button.setOnClickListener(this);    }    @Override    public void onClick(View v) {        Intent intent = new Intent(SavedListActivity.this, SpreadActivity.class);        switch (v.getId()){            case R.id.test_button:                // get info from list item                intent.putExtra("spread", "ppf");                intent.putExtra("fullName", "Past, Present, Future");                intent.putExtra("amount", 3);                break;            default:                Log.d("RRR", "onClick: " + "whoops");                break;        }        startActivity(intent);    }}