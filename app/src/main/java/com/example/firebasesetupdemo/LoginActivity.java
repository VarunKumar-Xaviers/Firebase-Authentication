package com.example.firebasesetupdemo;

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

public class LoginActivity extends AppCompatActivity {
EditText Email;
EditText Pass;
Button Login;
FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");

//        Link XML and Java
        Email=findViewById(R.id.editTextTextEmailAddress);
        Pass=findViewById(R.id.editTextTextPassword);
        Login=findViewById(R.id.login);
        auth=FirebaseAuth.getInstance();

        Login.setOnClickListener(view -> {
            String TXTEmail=Email.getText().toString();
            String TXTPass=Pass.getText().toString();

            mylogin(TXTEmail,TXTPass);
        });

    }

    private void mylogin(String txtEmail, String txtPass) {
        auth.signInWithEmailAndPassword(txtEmail,txtPass).addOnSuccessListener(authResult -> {
            Toast.makeText(LoginActivity.this, "Login was successfull", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
        });
    }
}
