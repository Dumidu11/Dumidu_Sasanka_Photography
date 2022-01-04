package com.example.dumidusasankaphotography;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class eventActivity extends AppCompatActivity {

   FirebaseFirestore db;
     RecyclerView mFirestorelist;
     MyAdapter2 myAdapter2;
     ArrayList<Productsmodel> productsmodelArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);


        mFirestorelist = findViewById(R.id.firestore_event_display);
        mFirestorelist.setLayoutManager(new LinearLayoutManager(this));


        db =FirebaseFirestore.getInstance();
        productsmodelArrayList = new ArrayList<>();
        myAdapter2 = new MyAdapter2(getApplicationContext(),productsmodelArrayList);
        mFirestorelist.setAdapter(myAdapter2);

        db.collection("EventUpdated").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot d:list)
                        {
                            Productsmodel obj = d.toObject(Productsmodel.class);
                            productsmodelArrayList.add(obj);
                        }
                        myAdapter2.notifyDataSetChanged();
                    }
                });



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}