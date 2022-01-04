package com.example.dumidusasankaphotography;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class FullScreenActivity4 extends AppCompatActivity {

    ImageView imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen4);

        imageView3 = (ImageView) findViewById(R.id.image_view4);

        getSupportActionBar().setTitle("Full Screen Image");
        Intent i =getIntent();
        int position = i.getExtras().getInt("id");

        ImageAdapter4 imageAdapter4 = new ImageAdapter4(this);

        imageView3.setImageResource(imageAdapter4.imageArray[position]);
    }
}