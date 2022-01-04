package com.example.dumidusasankaphotography;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class albumActivity extends AppCompatActivity {

    String[] main_bottons_album = {"Birthdays","Weddings","Homecomings","Corporate"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        //getSupportActionBar().setTitle("Albums");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ListView listView = (ListView)findViewById(R.id.listview_album);
        TextView textView = (TextView)findViewById(R.id.button_name_album);

        final ArrayAdapter adapter = new ArrayAdapter(this, R.layout.my_list_album, R.id.button_name_album, main_bottons_album);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = (String) adapter.getItem(position);
                if(position ==0){
                    Intent open = new Intent(albumActivity.this, BirthdaysActivity.class);
                    startActivity(open);
                }
                if(position ==1){
                    Intent open1 = new Intent(albumActivity.this, WeddingsActivity.class);
                    startActivity(open1);
                }
                if(position ==2){
                    Intent open2 = new Intent(albumActivity.this, HomecomingsActivity.class);
                    startActivity(open2);
                }
                if(position ==3){
                    Intent open3 = new Intent(albumActivity.this, CorporateActivity.class);
                    startActivity(open3);
                }
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
            }
        });

    }
}