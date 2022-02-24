package com.example.firebasesetupdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    // adding references between xml widgets and this java file
    Button _registerBtn, _loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
setTitle("Start");
        _registerBtn = findViewById(R.id.registerBtn);
        _loginBtn = findViewById(R.id.loginBtn);

        _registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(StartActivity.this, RegisterActivity.class));
                finish();
            }
        });

        _loginBtn.setOnClickListener(view -> {
            startActivity(new Intent(StartActivity.this, LoginActivity.class));
            finish();
        });
    }
}
