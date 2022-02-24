package com.example.firebasesetupdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {

    EditText _etEmail, _etPassword;
    Button _registerSubmitBtn;

    private FirebaseAuth _auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        _etEmail = findViewById(R.id.etEmail);
        _etPassword = findViewById(R.id.etPassword);
        _registerSubmitBtn = findViewById(R.id.registerSubmitBtn);

//        firebase auth
        _auth = FirebaseAuth.getInstance();

        _registerSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                storing the input values
                String txtEmail = _etEmail.getText().toString();
                String txtPassword = _etPassword.getText().toString();

//                checking if values are empty
                if ((TextUtils.isEmpty(txtEmail)) || (TextUtils.isEmpty(txtPassword))) {
                    Toast.makeText(getApplicationContext(), "Credentials are empty.", Toast.LENGTH_SHORT).show();
                } else if (txtPassword.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password is too short.", Toast.LENGTH_SHORT).show();
                } else {
                    registerUser(txtEmail, txtPassword);
                }
            }
        });
        // oncreate closes here
    }


    private void registerUser(String txtEmail, String txtPassword) {
        _auth.createUserWithEmailAndPassword(txtEmail, txtPassword).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Registration was successful :)", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this,StartActivity.class));
                    finish();
                } else {
                    Toast.makeText(RegisterActivity.this, Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        });

    }//registerUser closes here

} //registerActivity closes here
