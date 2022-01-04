package com.example.dumidusasankaphotography;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.jar.Attributes;

public class signupActivity extends AppCompatActivity {


    public static final String TAG = "TAG";
    private EditText username;
 private  EditText password;
 private Button signup;

 private FirebaseAuth auth;
 FirebaseFirestore fstore;
 String userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        
        username =findViewById(R.id.username);
        password =findViewById(R.id.password);
        signup =findViewById(R.id.signup2);

        auth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();


        
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email = username.getText().toString();
                String txt_password = password.getText().toString();

                if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)){
                    Toast.makeText(signupActivity.this, "Empty credentials", Toast.LENGTH_SHORT).show();
                }else if(txt_password.length()<7){
                    Toast.makeText(signupActivity.this, "Password too  short!", Toast.LENGTH_SHORT).show();
                }else{
                    registerUser(txt_email , txt_password);
                }
            }
        });
    }
    private void StoreData(String Email ,String Name){

    }

    private void registerUser(String username, String password) {
        auth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(signupActivity.this, new OnCompleteListener<AuthResult>() {


            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(signupActivity.this,"Signup user sucessful!", Toast.LENGTH_SHORT).show();
                    userID = auth.getCurrentUser().getUid();
                    DocumentReference documentReference = fstore.collection("User").document(userID);
                    Map<String,Object> signup = new HashMap<>();
                    signup.put("email11" ,username);
                    documentReference.set(signup).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Log.d(TAG,"on success: signup"+userID);

                        }
                    });
                    startActivity (new Intent(signupActivity. this,startActivity.class));
                    finish();
                }else {
                    Toast.makeText(signupActivity.this, "Signup failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    
}