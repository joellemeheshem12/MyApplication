package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyTimesListActivity extends AppCompatActivity {

    private Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_times_list);
        add = findViewById(R.id.add);
    }

    public void onClick(View view) {
        Intent intent= new Intent(this,AddTimeActivity.class) ;
        startActivity(intent);
    }
}