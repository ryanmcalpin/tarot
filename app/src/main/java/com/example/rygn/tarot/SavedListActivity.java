package com.example.rygn.tarot;import android.content.Intent;import android.support.annotation.NonNull;import android.support.v7.app.AppCompatActivity;import android.os.Bundle;import android.support.v7.widget.LinearLayoutManager;import android.support.v7.widget.RecyclerView;import android.util.Log;import android.view.View;import android.widget.Button;import android.widget.Toast;import com.google.android.gms.tasks.OnCompleteListener;import com.google.android.gms.tasks.OnFailureListener;import com.google.android.gms.tasks.OnSuccessListener;import com.google.android.gms.tasks.Task;import com.google.firebase.firestore.CollectionReference;import com.google.firebase.firestore.DocumentReference;import com.google.firebase.firestore.DocumentSnapshot;import com.google.firebase.firestore.FirebaseFirestore;import com.google.firebase.firestore.QueryDocumentSnapshot;import com.google.firebase.firestore.QuerySnapshot;import java.util.ArrayList;import java.util.HashMap;import java.util.List;import java.util.Map;public class SavedListActivity extends AppCompatActivity implements View.OnClickListener {    private static final String TAG = "RRR";    private RecyclerView recyclerView;    private RecyclerView.Adapter rAdapter;    private RecyclerView.LayoutManager layoutManager;    private ArrayList<Object> savedSpreads = new ArrayList<>();    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_saved_list);        FirebaseFirestore db = FirebaseFirestore.getInstance();        CollectionReference colRef = db.collection("testSpreads");        colRef.get()                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {                    @Override                    public void onComplete(@NonNull Task<QuerySnapshot> task) {                        if (task.isSuccessful()) {                            for (QueryDocumentSnapshot document : task.getResult()) {                                Log.d(TAG, document.getId() + " => " + document.getData());                                Log.d(TAG, document.getId() + " =keyset> " + document.getData().get("type"));                                savedSpreads.add(document.getData());                                Log.d(TAG, "onCreate: " + savedSpreads.size());                            }                            recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);                            recyclerView.setHasFixedSize(true);                            layoutManager = new LinearLayoutManager(SavedListActivity.this  );                            recyclerView.setLayoutManager(layoutManager);                            rAdapter = new FirebaseRVAdapter(savedSpreads);                            recyclerView.setAdapter(rAdapter);                        } else {                            Log.d(TAG, "Error getting documents: ", task.getException());                        }                    }                });    }    @Override    public void onClick(View v) {        Intent intent = new Intent(SavedListActivity.this, SpreadActivity.class);        switch (v.getId()){//            case R.id.test_button:////                // get info from list item////                intent.putExtra("spread", "ppf");////                intent.putExtra("fullName", "Past, Present, Future");////                intent.putExtra("amount", 3);////                break;            default:                Log.d("RRR", "onClick: " + "whoops");                break;        }        startActivity(intent);    }}