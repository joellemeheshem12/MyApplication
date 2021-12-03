package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

public class AddTimeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
   private Spinner spinner1,spinner2,spinner3;
   AutoCompleteTextView autoCompleteTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_time);

        autoCompleteTextView=findViewById(R.id.autoComplete);
        String [] option = {"Long Course M","Short Course Mts","Short Course Yds"};
        ArrayAdapter arrayAdapter= new ArrayAdapter(this,R.layout.option_item,option);
        autoCompleteTextView.setText(arrayAdapter.getItem(0).toString(),false);
        autoCompleteTextView.setAdapter(arrayAdapter);

        Spinner spinner1 = findViewById(R.id.Spinner1);
        ArrayAdapter<CharSequence> adapter1 =ArrayAdapter.createFromResource(this,R.array.Pool, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this);

        Spinner spinner2 = findViewById(R.id.Spinner2);
        ArrayAdapter<CharSequence> adapter2 =ArrayAdapter.createFromResource(this,R.array.Distance, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        Spinner spinner3 = findViewById(R.id.Spinner3);
        ArrayAdapter<CharSequence> adapter3 =ArrayAdapter.createFromResource(this,R.array.Stroke, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String choice = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(getApplicationContext(),choice,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}