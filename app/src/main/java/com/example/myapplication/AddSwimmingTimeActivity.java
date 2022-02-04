package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Time;
import java.util.Date;

public class AddSwimmingTimeActivity extends AppCompatActivity  {
    private Button add1;
    private FirebaseDatabase database = FirebaseDatabase.getInstance("https://joelle-759cf-default-rtdb.europe-west1.firebasedatabase.app/");
    DatabaseReference myRef;
    private SwimmingTime st = new SwimmingTime();
   AutoCompleteTextView autoCompleteTextView1,autoCompleteTextView2,autoCompleteTextView3;
    private Date date;
    private Time time;
    private String pool;
    private int distance;
    private String stoke;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_time);

        String user = FirebaseAuth.getInstance().getUid();
        myRef = database.getReference("users/" + user);
        add1 = findViewById(R.id.add1);

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
        Intent i = new Intent(getApplicationContext(), MySwimmingTimesListActivity.class);

        st = new SwimmingTime(pool.toString(),(int)distance,stoke.toString(),time.toString(),date.toString());
        Log.d("SwimmingTime:",st.toString());
        myRef.push().setValue(st);

        startActivity(i);
    }
}