package com.example.dumidusasankaphotography;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class bookingActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private static  final String TAG = "bookingActivity";
    private static final String Name = "Name11";
    private static final String Note ="Note11";
    private static final String Email ="email11";
    private static final String TeleNo ="teleno11";
    private static final String Event ="event11";
    private static final String Date ="date11";
    private static final String Vanue ="Vanue11";
    private static final String Crew ="crew11";
    private static final String Time = "time11";
    private static final String Status ="status11";
    private static final String Spinner ="Photographer_name";
  

    private EditText editTextname;
    private EditText editTextNote;
    private EditText editTextteleno;
    EditText editTextevent;
    private EditText editTextdate;
    TextView tvDate;
    private EditText editTextvanue;
    private EditText editTextcrew;
    private EditText editeTexttime;

    DatePickerDialog.OnDateSetListener setListener;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    RadioGroup radiogroup;
    RadioButton radioButton;
    String ID;
    String username;
    String spinner1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);



        ID = MainActivity.getActivity().getID();
        System.out.println("ihhh="+ID);
        username=MainActivity.getActivity().getUsername();
        System.out.println("immmm="+username);

        editTextname = findViewById(R.id.name);
        editTextNote = findViewById(R.id.note);
        editTextteleno = findViewById(R.id.teleno);
        editTextevent = findViewById(R.id.event);
        editTextdate = findViewById(R.id.date);
        tvDate = findViewById(R.id.tv_date);
        editTextvanue = findViewById(R.id.vanue);
        editTextcrew = findViewById(R.id.crew);
        editeTexttime = findViewById(R.id.time);

        Calendar calender = Calendar.getInstance();
        final int year = calender.get(Calendar.YEAR);
        final int month = calender.get(Calendar.MONTH);
        final int day = calender.get(Calendar.DAY_OF_MONTH);

        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        bookingActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();

            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = day+"/"+year;
                tvDate.setText(date);
            }
        };

        editTextdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        bookingActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        editTextdate.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });


    getSupportActionBar().

    setDisplayHomeAsUpEnabled(true);

    Spinner spinner1 = findViewById(R.id.spinner11);
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);
}

    public  void saveNote(View v){
        String name1 =editTextname.getText().toString();

        String teleno1 =editTextteleno.getText().toString();
        String event1 =editTextevent.getText().toString();
        String date1 =editTextdate.getText().toString();
        String vanue1 =editTextvanue.getText().toString();
        String crew1 =editTextcrew.getText().toString();
        String time1 =editeTexttime.getText().toString();
        String note1 =editTextNote.getText().toString();


        Map<String, Object> note = new HashMap<>();
        note.put(Name, name1);
        note.put(Email,username);
        note.put(TeleNo,teleno1);
        note.put(Event,event1);
        note.put(Date,date1);
        note.put(Vanue,vanue1);
        note.put(Crew,crew1);
        note.put(Time,time1);
        note.put(Status,"1");
        note.put(Spinner,spinner1);
        note.put(Note,note1);

        String msg="........Hello " +name1+ " is booking a new event of " +event1+ " on " +date1+ " at " +time1+ ".\n Please can You confrom or cancel this Booking now?........";
        String phname=spinner1;
        String nameph1="Dumidu Sasanka";
        String nameph2="Kushan Aththanayaka";
        String nameph3="Chamika Viranga";
        String nameph4="Anuradha Udayanga";
        String number;
        if(nameph1.equals(phname)) {
            number="0716980210";
            Intent sendIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + number));
            sendIntent.putExtra("sms_body", msg);
            startActivity(sendIntent);
            Toast.makeText(bookingActivity.this, "Successfully Send a massage", Toast.LENGTH_SHORT).show();
            sendIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            System.out.println("iii="+msg);
        }
         else if(nameph2.equals(phname)){
                number="0711897155";
                Intent sendIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + number));
                sendIntent.putExtra("sms_body", msg);
                startActivity(sendIntent);
                Toast.makeText(bookingActivity.this, "Successfully Send a massage", Toast.LENGTH_SHORT).show();
                sendIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
         }
         else if(nameph3.equals(phname)) {
            number="0778337784";
            Intent sendIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + number));
            sendIntent.putExtra("sms_body", msg);
            startActivity(sendIntent);
            Toast.makeText(bookingActivity.this, "Successfully Send a massage", Toast.LENGTH_SHORT).show();
            sendIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        else if(nameph4.equals(phname)) {
            number="0717821997";
            Intent sendIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + number));
            sendIntent.putExtra("sms_body", msg);
            startActivity(sendIntent);
            Toast.makeText(bookingActivity.this, "Successfully Send a massage", Toast.LENGTH_SHORT).show();
            sendIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }






        db.collection("User").document(ID).set(note)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(bookingActivity.this, "Note save", Toast.LENGTH_SHORT).show();

                    }
                })
        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull  Exception e) {
                Toast.makeText(bookingActivity.this, " not Note", Toast.LENGTH_SHORT).show();
                Log.d(TAG,e.toString());

            }
        });



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinner1 = parent.getItemAtPosition(position).toString();

        String text = parent.getItemAtPosition(position).toString();
        // Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void checkButton(View v) {
        int radioId = radiogroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);
        Toast.makeText(this, "Selected radio Button: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
    }

}