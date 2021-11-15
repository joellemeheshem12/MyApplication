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

public class IntroActivity extends AppCompatActivity {
    private Button buttonTrainingSchedule,buttonMyTimes,buttonTrainingVideos,buttonMyProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        buttonTrainingSchedule=findViewById(R.id.buttonTrainingSchedule);
        buttonMyTimes=findViewById(R.id.buttonMyTimes);
        buttonTrainingVideos=findViewById(R.id.buttonTrainingVideos);
        buttonMyProgress=findViewById(R.id.buttonMyProgress);

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
                break;
            case R.id.exit_menu:
                // closeApplication();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        Intent intent= new Intent(this,ProfileActivity.class) ;
        startActivity(intent);
    }

}