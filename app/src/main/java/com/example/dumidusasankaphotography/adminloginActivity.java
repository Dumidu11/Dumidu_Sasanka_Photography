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

public class adminloginActivity extends AppCompatActivity {
    private EditText username1;
    private EditText password1;
    private Button adminlogin1;

    private FirebaseAuth auth1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

        username1 = findViewById(R.id.username1);
        password1 = findViewById(R.id.password1);
        adminlogin1 = findViewById(R.id.adminlogin);
        auth1 = FirebaseAuth.getInstance();

        adminlogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_username1 = username1.getText().toString();
                String txt_password1 = password1.getText().toString();

                if(txt_password1.equals("admin123")){
                    longinUser(txt_username1 , txt_password1);
                }else{
                    Toast.makeText(adminloginActivity.this, "Password too incorrect!", Toast.LENGTH_SHORT).show();
                }



            }
        });



    }

    private void longinUser(String username1, String password1) {
        auth1.signInWithEmailAndPassword(username1 ,password1).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(adminloginActivity.this, "login Successful!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(adminloginActivity.this ,MainadminActivity.class));
                finish();
            }
        });
    }
}