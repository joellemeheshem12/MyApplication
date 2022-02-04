package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button TrainingSchedule,MyTimes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TrainingSchedule=findViewById(R.id.TrainingSchedule);
        MyTimes=findViewById(R.id.MyTimes);


    }
//inflates the design of the required menu on top of the activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.camera_menu:
                Toast.makeText(this, "Camera", Toast.LENGTH_LONG).show();
                Intent intent= new Intent(this,CameraActivity.class) ;
                startActivity(intent);
                break;
            case R.id.exit_menu:
                // closeApplication();
                this.finishAffinity();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        Intent intent= new Intent(this, CameraActivity.class) ;
        startActivity(intent);
    }
    public void Submit1(View view) {
        Intent intent= new Intent(this,ArrayListActivity.class) ;
        startActivity(intent);
    }

    public void Submit2(View view) {
        Intent intent= new Intent(this, MySwimmingTimesListActivity.class) ;
        startActivity(intent);
    }
}