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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class IntroActivity extends AppCompatActivity {
    private Button buttonTrainingSchedule,buttonMyTimes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        buttonTrainingSchedule=findViewById(R.id.buttonTrainingSchedule);
        buttonMyTimes=findViewById(R.id.buttonMyTimes);


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
        Intent intent= new Intent(this,AddTrainingActivity.class) ;
        startActivity(intent);
    }

    public void Submit2(View view) {
        Intent intent= new Intent(this,AddTimeActivity.class) ;
        startActivity(intent);
    }



}