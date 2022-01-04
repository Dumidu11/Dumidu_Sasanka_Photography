package com.example.dumidusasankaphotography;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class bookingsaveActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<usersaved> usersavedArrayList;
    MyAdapter myAdapter;
    FirebaseFirestore db;
    EditText search;
    ArrayList<usersaved> filterList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookingsave);



        recyclerView = (RecyclerView) findViewById(R.id.recycleView1);
        search=findViewById(R.id.search);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        usersavedArrayList = new ArrayList<>();
        myAdapter=new MyAdapter(getApplicationContext(),usersavedArrayList);
        recyclerView.setAdapter(myAdapter);

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                filterList.clear();

                if(s.toString().isEmpty()){
                    recyclerView.setAdapter(new MyAdapter(getApplicationContext(), usersavedArrayList));
                    myAdapter.notifyDataSetChanged();
                }
                else {
                    Filter(s.toString());
                }

            }
        });

        db = FirebaseFirestore.getInstance();
        db.collection("User").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot d:list)
                        {
                            usersaved obj = d.toObject(usersaved.class);
                            usersavedArrayList.add(obj);
                        }
                        myAdapter.notifyDataSetChanged();
                    }
                });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    private void Filter(String text) {
        for(usersaved user: usersavedArrayList){
            if((Objects.equals(user.getPhotographer_name(),text))){
                filterList.add(user);

            }

        }
      recyclerView.setAdapter(new MyAdapter(getApplicationContext(),filterList));
        myAdapter.notifyDataSetChanged();
    }


}