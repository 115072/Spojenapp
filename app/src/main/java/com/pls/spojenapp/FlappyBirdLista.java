package com.pls.spojenapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.pls.spojenapp.ui.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class FlappyBirdLista extends AppCompatActivity {

    String[]  nevek;
    String[]  pontok;
    String[]  helyezesek;
    RecyclerView recyclerView;
    TextView teszt;
    String fityma = "";
    ArrayList<String> nev = new ArrayList<String>();

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference collectionReference = db.collection("flappyBPontok");

    private RecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flappy_bird_lista);

        recyclerView = findViewById(R.id.RecyclerView);
        teszt = findViewById(R.id.textView72);

        Query query = collectionReference.orderBy("pontok", Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<ReciclerViewhezKonsGet> options = new FirestoreRecyclerOptions.Builder<ReciclerViewhezKonsGet>()
                .setQuery(query,ReciclerViewhezKonsGet.class)
                .build();

        adapter = new RecyclerViewAdapter(options);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);








       /* collectionReference.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                for(QueryDocumentSnapshot snapshots : queryDocumentSnapshots){

                    String data = "";

                    data += snapshots.getString("nev")/* + "\n" + emDash + "\n";

                    nev.add(data);

                    data = "";

                }





            }
        });


     nev.add("szoj");
        nev.add("szoj");
        nev.add("szoj");
        nev.add("szoj");
        nev.add("szoj");
        nev.add("szoj");
        nev.add("szoj");
        nev.add("szoj");
        nev.add("szoj");








       // nevek = new String[]{"szoj","2","1","3","4","5", "6", "7", "8", "9"};
        pontok = new String[]{"pontok", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        helyezesek = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        */





       // RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,nev,pontok,helyezesek);
       // recyclerView.setAdapter(myAdapter);
       // recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}