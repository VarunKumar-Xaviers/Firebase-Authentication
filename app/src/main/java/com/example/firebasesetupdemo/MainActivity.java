package com.example.firebasesetupdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
Button Logout;
//FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Logout=findViewById(R.id.logout);
        Logout.setOnClickListener(view -> {
            logout();
        });
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(this, "Lodged out", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this,StartActivity.class));
        finish();
    }
}
