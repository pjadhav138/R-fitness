package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView goToLogin;
    Button submit;
    EditText username;
    EditText Password;
    EditText cmpassword;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goToLogin = findViewById(R.id.go_to_login);
        submit = findViewById(R.id.submit);
        username = findViewById(R.id.username);
        Password = findViewById(R.id.password);
        cmpassword = findViewById(R.id.cmpassword);
        email = findViewById(R.id.email);
        //        goToLogin.setText("test");
        goToLogin.setOnClickListener(this);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.go_to_login) {
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
        } else if (v.getId() == R.id.submit) {
            if (username.getText().toString().isEmpty()) {
                Toast.makeText(this, "Username Should not be Empty.", Toast.LENGTH_SHORT).show();
            return;
            }
            if (Password.getText().toString().isEmpty()){
                Toast.makeText(this, "Password Should not be Empty.", Toast.LENGTH_SHORT).show();
            return;
            }
            if(cmpassword.getText().toString().isEmpty()){
                Toast.makeText(this, "Confirm password must not be empty", Toast.LENGTH_SHORT).show();
            return;
            }
            if (email.getText().toString().isEmpty()){
                Toast.makeText(this, "Email should not be empty", Toast.LENGTH_SHORT).show();
            return;
            }
            if (Password.getText().toString().equals(cmpassword.getText().toString())){
                Intent password = new Intent(MainActivity.this,Login.class);
                password.putExtra("username",username.getText().toString());
                password.putExtra("Email",email.getText().toString());
                startActivity(password);
            }else {
                Toast.makeText(this, "Password and Confirm Password Doesn't Match", Toast.LENGTH_SHORT).show();
            }
        }

    }
}