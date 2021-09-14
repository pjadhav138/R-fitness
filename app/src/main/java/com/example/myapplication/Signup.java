package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Cutom.MyTextView;

import org.json.JSONException;
import org.json.JSONObject;

public class Signup extends AppCompatActivity {
    MyTextView Username;
    EditText Name, Emailid, contactno, password, confirmpassword;
    Button submit;
    String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf");
        Username = (MyTextView) findViewById(R.id.username);
        Name = findViewById(R.id.name);
        Emailid = findViewById(R.id.Emailid);
        contactno = findViewById(R.id.contactno);
        password = findViewById(R.id.password);
        confirmpassword = findViewById(R.id.confirmpassword);
        submit = findViewById(R.id.submit);

//        Name.setTypeface(font);
//        Username.setTypeface(font);
//        Name.setTypeface(font);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Username.getText().toString().isEmpty()) {
                    Toast.makeText(Signup.this, "Username Should not be Empty.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (Name.getText().toString().isEmpty()) {
                    Toast.makeText(Signup.this, "Name Should not be Empty.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (Emailid.getText().toString().isEmpty()) {
                    Toast.makeText(Signup.this, "EmailId Should not be Empty.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (contactno.getText().toString().isEmpty()) {
                    Toast.makeText(Signup.this, "Contact number should not be empty.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!password.getText().toString().equals(confirmpassword.getText().toString())) {
                    Toast.makeText(Signup.this, "Password and confirm password does not match", Toast.LENGTH_SHORT).show();
                    return;
                }


                //putting values in json
                JSONObject Session = new JSONObject();
                try {
                    Session.put("Username", Username.getText().toString());
                    Session.put("Name", Name.getText().toString());
                    Session.put("Emailid", Emailid.getText().toString());
                    Session.put("Contactno", contactno.getText().toString());
                    Session.put("Password", password.getText().toString());


                    //starting sharedpreferences
                    SharedPreferences preferences = getSharedPreferences("R-FIT", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();


                    String list = preferences.getString("Sessionlist", "");
                    JSONObject SessionList;
                    if (list.isEmpty()) {
                        SessionList = new JSONObject();

                    } else {
                        SessionList = new JSONObject(list);
                        if (SessionList.has(Username.getText().toString())) {
                            Toast.makeText(Signup.this, "Username Already Exist, Try new.", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }

                    SessionList.put(Username.getText().toString(), Session);
                    editor.putString("Sessionlist", SessionList.toString());
                    editor.commit();
                    startActivity(new Intent(Signup.this, Login.class).putExtra("username", Username.getText().toString()).putExtra("Email", Emailid.getText().toString()));
                    Log.e(TAG, Session.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });

    }

}