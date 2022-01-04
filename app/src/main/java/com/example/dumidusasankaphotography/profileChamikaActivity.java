package com.example.dumidusasankaphotography;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class profileChamikaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_chamika);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}