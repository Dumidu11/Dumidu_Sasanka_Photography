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

public class MainActivity extends AppCompatActivity {

    String ID;
    String username;
    static MainActivity INSTANCE;

    String[] main_bottons = {"Booking","Events","Albums","About Us"};

    private Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        INSTANCE = this;
        getID();
        getUsername();

        ID = useloginActivity.getActivity().getID();
        username=useloginActivity.getActivity().getUsername();
        System.out.println("id="+ID);



        logout =findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(MainActivity.this, "Logged Out", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this ,startActivity.class));
            }
        });

        ListView listView = (ListView)findViewById(R.id.listview);
        TextView textView = (TextView)findViewById(R.id.button_name);
        final ArrayAdapter adapter = new ArrayAdapter(this, R.layout.my_list1, R.id.button_name, main_bottons);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = (String) adapter.getItem(position);
                if(position == 0) {
                    Intent open = new Intent(MainActivity.this, bookingActivity.class);
                    startActivity(open);
                }
                if (position == 2) {
                    Intent open2 = new Intent(MainActivity.this, albumActivity.class);
                    startActivity(open2);
                }
                if (position == 1) {
                    Intent open1 = new Intent(MainActivity.this, eventActivity.class);
                    startActivity(open1);
                }
                if (position == 3) {
                    Intent open3 = new Intent(MainActivity.this, aboutusActivity.class);
                    startActivity(open3);
                }



                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static MainActivity getActivity()  {
        return INSTANCE;
    }

    public String getID(){
        System.out.println("sm="+ID);
        return this.ID;

    }

    public String getUsername(){

        return this.username;

    }
}