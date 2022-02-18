package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pools;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddSwimmingTimeActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {
    private AutoCompleteTextView pools,dis,stroke1;
    private Button add1;
    private SwimmingTime st ;
    private Date date;
    private Time time;
    private String pool;
    private int distance;
    private String stoke;
    private FirebaseDatabase database = FirebaseDatabase.getInstance("https://joelle-759cf-default-rtdb.europe-west1.firebasedatabase.app/");
    private DatabaseReference myRef;
    private EditText editTextDate;
    private String[] poolType = {"Long Course M", "Short Course Mts", "Short Course Yds"};
    private String[] distance1 = {"50","100","200","400"};
    private String[] strokeType = {"Fly", "Backstroke", "Breaststroke","Freestyle","I.M"};
    private EditText editTextTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_time);

        String user = FirebaseAuth.getInstance().getUid();
        myRef = database.getReference("users/" + user+"/SwimmingTime");
        add1 = findViewById(R.id.add1);
        editTextTime=findViewById(R.id.editTextTime);
        final Calendar calendar=Calendar.getInstance();
        editTextDate=findViewById(R.id.editTextDate);
        editTextDate.setInputType(InputType.TYPE_NULL);
        editTextDate.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
            int year =calendar.get(calendar.YEAR);
                int month =calendar.get(calendar.MONTH);
                int day =calendar.get(calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog=new DatePickerDialog(AddSwimmingTimeActivity.this, new DatePickerDialog.OnDateSetListener()
                        {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                 editTextDate.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime()));
                    }
                },year,month,day);
                datePickerDialog.show();
                date = new Date(year, month, day);
            }
        });


        pools = findViewById(R.id.pools);
        ArrayAdapter arrayAdapter1 = new ArrayAdapter(this, R.layout.option_item, poolType);
        pools.setText(arrayAdapter1.getItem(0).toString(), false);
        pools.setAdapter(arrayAdapter1);
        pools.setOnItemSelectedListener(this);


        dis = findViewById(R.id.dis);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, R.layout.option_item,distance1);
        dis.setText(arrayAdapter2.getItem(0).toString(), false);
        dis.setAdapter(arrayAdapter2);
        dis.setOnItemSelectedListener(this);

        stroke1 = findViewById(R.id.stroke1);
        ArrayAdapter arrayAdapter3 = new ArrayAdapter(this, R.layout.option_item, strokeType);
        stroke1.setText(arrayAdapter3.getItem(0).toString(), false);
        stroke1.setAdapter(arrayAdapter3);
        stroke1.setOnItemSelectedListener(this);


        add1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MySwimmingTimesListActivity.class);

                st = new SwimmingTime(pool.toString(), distance,stoke.toString(),time.toString(),date.toString());
                Log.d("SwimmingTime:",st.toString());
                myRef.push().setValue(st);

                startActivity(i);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(view == pools){
            pool = poolType[i];
        }else if(view == dis){
            distance = Integer.parseInt(distance1[i]);
        }else if(view == stroke1){
            stoke = strokeType[i];
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        pool = poolType[0];
        distance = Integer.parseInt(distance1[0]);
        stoke = strokeType[0];
    }
}