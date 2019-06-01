package com.example.rygn.tarot;import android.content.Intent;import android.support.annotation.NonNull;import android.support.v7.app.AppCompatActivity;import android.os.Bundle;import android.util.Log;import android.view.View;import android.widget.Button;import android.widget.Toast;import com.google.android.gms.tasks.OnCompleteListener;import com.google.android.gms.tasks.OnFailureListener;import com.google.android.gms.tasks.OnSuccessListener;import com.google.android.gms.tasks.Task;import com.google.firebase.firestore.DocumentReference;import com.google.firebase.firestore.DocumentSnapshot;import com.google.firebase.firestore.FirebaseFirestore;import java.util.ArrayList;import java.util.HashMap;import java.util.Map;public class SavedListActivity extends AppCompatActivity implements View.OnClickListener {    private static final String TAG = "SavedListActivity";    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_saved_list);        FirebaseFirestore db = FirebaseFirestore.getInstance();        DocumentReference docRef = db.collection("testSpreads").document("type");        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {            @Override            public void onSuccess(DocumentSnapshot documentSnapshot) {                // working on this still//                String type = documentSnapshot.toString();//                Toast.makeText(SavedListActivity.this, "yaa " + type, Toast.LENGTH_SHORT).show();            }        });        Button button = (Button) findViewById(R.id.test_button);        button.setOnClickListener(this);    }    @Override    public void onClick(View v) {        Intent intent = new Intent(SavedListActivity.this, SpreadActivity.class);        switch (v.getId()){            case R.id.test_button:                // get info from list item                intent.putExtra("spread", "ppf");                intent.putExtra("fullName", "Past, Present, Future");                intent.putExtra("amount", 3);                break;            default:                Log.d("RRR", "onClick: " + "whoops");                break;        }        startActivity(intent);    }}