package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.os.Bundle;
import android.se.omapi.Session;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;


public class Login extends AppCompatActivity {
    TextView username, password;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.name);
        password = findViewById(R.id.password);

        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strusername = username.getText().toString();
                SharedPreferences preferences = getSharedPreferences("R-FIT", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("username",strusername);
                editor.commit();

                String list = preferences.getString("Sessionlist", "");
                JSONObject SessionList;
                Log.e("msg",list);
                try {
                    SessionList = new JSONObject(list);
                    if (SessionList.has(username.getText().toString())){
                        JSONObject singleSession =SessionList.getJSONObject(username.getText().toString());
                        String Emailid = singleSession.getString("Emailid");
                        String name = singleSession.getString("Name");
                        String ContactNo = singleSession.getString("Contactno");
                        SharedPreferences preferences1= getSharedPreferences("R-FIT",MODE_PRIVATE);
                        SharedPreferences.Editor editor1 = preferences1.edit();
                        editor1.putString("Emailid",Emailid);
                        editor1.putString("Name",name);
                        editor1.putString("ConatactNo",ContactNo);
                        editor1.commit();
                        if (singleSession.getString("Password").equals(password.getText().toString())){

                            startActivity(new Intent(Login.this, HOME.class));
                        }
                          else {
                            Toast.makeText(Login.this, "Username or Password does not match.Kindly check or signup if you are new here.!", Toast.LENGTH_LONG);

                        }

                    }



                }catch (JSONException e) {
                    e.printStackTrace();
                }



            }
        });
    }
}