package com.example.dumidusasankaphotography;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class updateEventActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText name;
    private EditText event;
    private Button submit;

    private FirebaseAuth auth;

    String spinner12;
    String IDE;
    String txt_Teleno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_event);

        name = findViewById(R.id.nameadmin);
        event = findViewById(R.id.eventadmin);
        submit = findViewById(R.id.btnadmincon);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getName = name.getText().toString();
                String getEvent = event.getText().toString();


                HashMap<String,Object> hashMap = new HashMap<>();
                hashMap.put("name",getName);
                hashMap.put("event",getEvent);
                hashMap.put("booking",spinner12);

                FirebaseFirestore.getInstance().collection("EventUpdated")
                        .document()
                        .set(hashMap)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(updateEventActivity.this,"update Confrom or cancel",Toast.LENGTH_SHORT).show();
                                //IDE = auth.getCurrentUser().getUid();
                               // getIDE();
                                getTeleno();
                                String msg="........Hello " +name+ " , your  " +event+  "  booking  is " +spinner12+ ". \n Thank You........";
                                String booking1="Confrom";
                                String booking2="Cancel";
                                String number=txt_Teleno;
                                String booked=spinner12;
                                if(booking1.equals(booked)){
                                    Intent sendIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + number));
                                    sendIntent.putExtra("sms_body", msg);
                                    startActivity(sendIntent);
                                    Toast.makeText(updateEventActivity.this, "Successfully Send a massage", Toast.LENGTH_SHORT).show();
                                    sendIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                                }
                                else if (booking2.equals(booked)){
                                    Intent sendIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + number));
                                    sendIntent.putExtra("sms_body", msg);
                                    startActivity(sendIntent);
                                    Toast.makeText(updateEventActivity.this, "Successfully Send a massage", Toast.LENGTH_SHORT).show();
                                    sendIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                                }


                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull  Exception e) {
                                Toast.makeText(updateEventActivity.this,""+e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Spinner spinner12 = findViewById(R.id.spinner12);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Names2, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner12.setAdapter(adapter);
        spinner12.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinner12 = parent.getItemAtPosition(position).toString();
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public String getIDE(){
        System.out.println("sas="+IDE);
        return this.IDE;
    }

    public String getTeleno(){
        return this.txt_Teleno;
    }
}
