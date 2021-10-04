package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RelativeExample extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
    CheckBox checkBox;
    RadioGroup group;
    Button button;
    String gender = "";
    String[] arrray = {"india", "nepal", "shri lanka", "usa", "japan", "koria"};
    SharedPreferences preferences;
    SharedPreferences.Editor preEditor;

    boolean isCheckboxchecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_example);
        preferences = getSharedPreferences("APP", MODE_PRIVATE);
        preEditor = preferences.edit();
        String list = preferences.getString("countryList", "[]");
        list = list.replace("[","").replace("]","");
        Log.e("TAG", "onCreate: "+list );
        String[] data = list.split(", ");
        Log.e("TAG", "onCreate: "+data );
        List<String > arralist = Arrays.asList(data);
        arralist.add(0,"gsggs");



//        List<String> list = Arrays.asList(arrray);
//        preEditor.putString("countryList",list.toString());
//        preEditor.commit();
        autoCompleteTextView = findViewById(R.id.contry);
        checkBox = findViewById(R.id.checkbox);
        button = findViewById(R.id.submit);
        group = findViewById(R.id.gender);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.male) {
                    gender = "Male";
                } else if (checkedId == R.id.female) {
                    gender = "Female";
                }
            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.e("TAG", "onCheckedChanged: " + isChecked);
                isCheckboxchecked = isChecked;

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  if (isCheckboxchecked){
                    Toast.makeText(RelativeExample.this, "Terms Agreed.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RelativeExample.this, "Terms Not Agreed.", Toast.LENGTH_SHORT).show();
                }*/
                if (gender.isEmpty()) {
                    Toast.makeText(RelativeExample.this, "Group Not Selected.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RelativeExample.this, "Group Selected. - " + gender, Toast.LENGTH_SHORT).show();

                }
            }
        });
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(RelativeExample.this, R.layout.autocomplte_row, R.id.text, arrray);
        autoCompleteTextView.setAdapter(adapter);

    }
}