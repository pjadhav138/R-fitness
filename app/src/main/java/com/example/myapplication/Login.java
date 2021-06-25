package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;



public class Login extends AppCompatActivity {
TextView username,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);

        String strusername = getIntent().getStringExtra("username");
        String strEmail = getIntent().getStringExtra("Email");

        username.setText(strusername);
        email.setText(strEmail);
    }
}