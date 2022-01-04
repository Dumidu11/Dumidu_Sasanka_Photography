package com.example.dumidusasankaphotography;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class useloginActivity extends AppCompatActivity {

    public EditText username;
    private EditText password;
    private Button userlogin;
    String txt_usename;

    private FirebaseAuth auth;
    String ID;
    static useloginActivity INSTANCE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uselogin);
        INSTANCE = this;
        
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        userlogin = findViewById(R.id.userlogin);
        auth = FirebaseAuth.getInstance();
        
        userlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 txt_usename = username.getText().toString();
                String txt_password = password.getText().toString();
                userloginUser(txt_usename,txt_password);
                //startActivity(new Intent(useloginActivity.this , MainActivity.class));
            }
        });
    }

   public void userloginUser(String usename, String password) {
        auth.signInWithEmailAndPassword(usename , password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
               Toast.makeText(useloginActivity.this, "userlogin Succeeful!", Toast.LENGTH_SHORT).show();
               ID = auth.getCurrentUser().getUid();
               getID();
               getUsername();
               System.out.println("ss="+ID);
                startActivity(new Intent(useloginActivity.this ,MainActivity.class));
                finish();
            }
        });
    }
    public static useloginActivity getActivity() {
        return INSTANCE;
    }

    public String getID(){
        System.out.println("sas="+ID);
     return this.ID;

    }

    public String getUsername(){
        return this.txt_usename;
    }
}