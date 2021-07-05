package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Login extends AppCompatActivity {
    TextView username, email;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);

        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strusername = username.getText().toString();
                SharedPreferences preferences = getSharedPreferences("R-FIT", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("username",strusername);
                editor.commit();



            }
        });
        String strusername = getIntent().getStringExtra("username");
        String strEmail = getIntent().getStringExtra("Email");

        username.setText(strusername);
        email.setText(strEmail);
    }
}