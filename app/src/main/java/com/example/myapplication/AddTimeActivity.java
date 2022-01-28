package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class AddTimeActivity extends AppCompatActivity  {
    private Button button;
   AutoCompleteTextView autoCompleteTextView1,autoCompleteTextView2,autoCompleteTextView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_time);

        autoCompleteTextView1 = findViewById(R.id.autoComplete1);
        String[] option1 = {"Long Course M", "Short Course Mts", "Short Course Yds"};
        ArrayAdapter arrayAdapter1 = new ArrayAdapter(this, R.layout.option_item, option1);
        autoCompleteTextView1.setText(arrayAdapter1.getItem(0).toString(), false);
        autoCompleteTextView1.setAdapter(arrayAdapter1);

        autoCompleteTextView2 = findViewById(R.id.autoComplete2);
        String[] option2 = {"50", "100", "200","400"};
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, R.layout.option_item, option2);
        autoCompleteTextView2.setText(arrayAdapter2.getItem(0).toString(), false);
        autoCompleteTextView2.setAdapter(arrayAdapter2);

        autoCompleteTextView3 = findViewById(R.id.autoComplete3);
        String[] option3 = {"Fly", "Backstroke", "Breaststroke","Freestyle","I.M"};
        ArrayAdapter arrayAdapter3 = new ArrayAdapter(this, R.layout.option_item, option3);
        autoCompleteTextView3.setText(arrayAdapter3.getItem(0).toString(), false);
        autoCompleteTextView3.setAdapter(arrayAdapter3);
    }

    public void onClick(View view) {
    }
}