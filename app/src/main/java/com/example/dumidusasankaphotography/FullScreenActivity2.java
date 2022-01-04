package com.example.dumidusasankaphotography;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class FullScreenActivity2 extends AppCompatActivity {

    ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen2);

        imageView1 = (ImageView) findViewById(R.id.image_view2);

        getSupportActionBar().setTitle("Full Screen Image");
        Intent i =getIntent();
        int position = i.getExtras().getInt("id");

        ImageAdapter2 imageAdapter2 = new ImageAdapter2(this);

        imageView1.setImageResource(imageAdapter2.imageArray[position]);
    }
}