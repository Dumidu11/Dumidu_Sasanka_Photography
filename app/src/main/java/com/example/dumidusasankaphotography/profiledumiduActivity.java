package com.example.dumidusasankaphotography;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class profiledumiduActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_dumidu);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}