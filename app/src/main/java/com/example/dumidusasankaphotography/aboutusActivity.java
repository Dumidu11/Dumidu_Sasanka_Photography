package com.example.dumidusasankaphotography;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class aboutusActivity extends AppCompatActivity {

    String[] main_bottons_aboutus = {"Dumidu Sasanka","Chamika Viranga","Anuradha Udayanga","Kushan Aththanayaka"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView listView = (ListView)findViewById(R.id.listview_aboutus);
        TextView textView = (TextView)findViewById(R.id.button_name_aboutus);

        final ArrayAdapter adapter = new ArrayAdapter(this, R.layout.my_list_aboutus, R.id.button_name_aboutus, main_bottons_aboutus);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = (String) adapter.getItem(position);
                if(position ==0){
                    Intent open = new Intent(aboutusActivity.this, profiledumiduActivity.class);
                    startActivity(open);
                }
                if(position ==1){
                    Intent open1 = new Intent(aboutusActivity.this, profileChamikaActivity.class);
                    startActivity(open1);
                }
                if(position ==2){
                    Intent open2 = new Intent(aboutusActivity.this, profileanuradhaActivity.class);
                    startActivity(open2);
                }
                if(position ==3){
                    Intent open3 = new Intent(aboutusActivity.this, profilekushanActivity.class);
                    startActivity(open3);
                }
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();

            }
        });
    }
}