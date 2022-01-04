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

public class WeddingsActivity extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weddings);

        Button button1 = findViewById(R.id.page11);
        Button button2 = findViewById(R.id.page22);
        Button button3 = findViewById(R.id.page33);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFacebookPage11("107176838169465");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFacebookPage22("108025254341518");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFacebookPage333("1487173651528181");
            }
        });


        gridView = (GridView)findViewById(R.id.grrid_view2);
        gridView.setAdapter(new ImageAdapter2(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),FullScreenActivity2.class);
                intent.putExtra("id",position);
                startActivity(intent);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void goToFacebookPage11(String id){
        try{
            Intent intent11 = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/" + id));
            startActivity(intent11);
        }catch (ActivityNotFoundException e){
            Intent intent22 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/" + id));
            startActivity(intent22);
        }
    }
    private  void goToFacebookPage22(String id){
        try{
            Intent intent33 = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/" + id));
            startActivity(intent33);
        }catch (ActivityNotFoundException e){
            Intent intent44 =new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/" + id));
            startActivity(intent44);
        }
    }
    private  void goToFacebookPage333(String  id){
        try{
            Intent intent55 = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/" +id));
            startActivity(intent55);
        }catch (ActivityNotFoundException e){
            Intent intent66 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/" + id));
            startActivity(intent66);
        }
    }
}