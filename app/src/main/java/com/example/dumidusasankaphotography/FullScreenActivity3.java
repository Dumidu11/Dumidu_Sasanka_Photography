package com.example.dumidusasankaphotography;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class FullScreenActivity3 extends AppCompatActivity {

    ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen3);


        imageView2 = (ImageView) findViewById(R.id.image_view3);

        getSupportActionBar().setTitle("Full Screen Image");
        Intent i =getIntent();
        int position = i.getExtras().getInt("id");

        ImageAdapter3 imageAdapter3 = new ImageAdapter3(this);

        imageView2.setImageResource(imageAdapter3.imageArray[position]);
    }
}