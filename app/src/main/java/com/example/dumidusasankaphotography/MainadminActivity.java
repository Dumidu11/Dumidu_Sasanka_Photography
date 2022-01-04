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

public class MainadminActivity extends AppCompatActivity {

    String[] main_bottons = {"Booking details","Event Updated","Albums","About Us"};
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainadmin);

        logout =findViewById(R.id.logoutadmin);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(MainadminActivity.this, "Logged Out", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainadminActivity.this ,startActivity.class));
            }
        });

        ListView listView = (ListView)findViewById(R.id.listviewadmin);
        TextView textView = (TextView)findViewById(R.id.button_nameadmin);
        final ArrayAdapter adapter = new ArrayAdapter(this, R.layout.my_listadmin, R.id.button_nameadmin, main_bottons);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = (String) adapter.getItem(position);
                if(position == 0) {
                    Intent open = new Intent(MainadminActivity.this, bookingsaveActivity.class);
                    startActivity(open);
                }
                if (position == 2) {
                    Intent open2 = new Intent(MainadminActivity.this, albumActivity.class);
                    startActivity(open2);
                }
                if (position == 1) {
                    Intent open1 = new Intent(MainadminActivity.this, updateEventActivity.class);
                    startActivity(open1);
                }
                if (position == 3) {
                    Intent open3 = new Intent(MainadminActivity.this, aboutusActivity.class);
                    startActivity(open3);
                }



                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
            }
        });
    }
}