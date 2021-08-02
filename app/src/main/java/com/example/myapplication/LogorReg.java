package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import org.json.JSONObject;

public class LogorReg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logor_reg);
    }

    SharedPreferences sharedPreferences = getSharedPreferences("R-FIT",MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();
}