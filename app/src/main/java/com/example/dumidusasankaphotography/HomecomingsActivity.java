package com.example.dumidusasankaphotography;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

public class HomecomingsActivity extends AppCompatActivity {

    GridView gridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homecomings);

        Button button1 = findViewById(R.id.page77);
        Button button2 = findViewById(R.id.page88);
        Button button3 = findViewById(R.id.page99);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFacebookPage112("107176838169465");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFacebookPage222("1487173651528181");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFacebookPage3332("108025254341518");
            }
        });


        gridView = (GridView)findViewById(R.id.grrid_view3);
        gridView.setAdapter(new ImageAdapter3(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),FullScreenActivity3.class);
                intent.putExtra("id",position);
                startActivity(intent);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void goToFacebookPage112(String id){
        try{
            Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/" + id));
            startActivity(intent1);
        }catch (ActivityNotFoundException e){
            Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/" + id));
            startActivity(intent2);
        }
    }
    private  void goToFacebookPage222(String id){
        try{
            Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/" + id));
            startActivity(intent3);
        }catch (ActivityNotFoundException e){
            Intent intent4 =new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/" + id));
            startActivity(intent4);
        }
    }
    private  void goToFacebookPage3332(String  id){
        try{
            Intent intent5 = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/" +id));
            startActivity(intent5);
        }catch (ActivityNotFoundException e){
            Intent intent6 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/" + id));
            startActivity(intent6);
        }
    }
}