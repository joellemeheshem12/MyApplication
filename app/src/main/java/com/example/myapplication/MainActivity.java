package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int NOTIFICATION_REMINDER_NIGHT = 1;
    private Button buttonLogin,buttonSignUP;
    private Intent musicIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonLogin=findViewById(R.id.buttonLogin);
        buttonSignUP=findViewById(R.id.buttonSignUP);

        //this will start the service which in turn will the music
        musicIntent =new Intent(this,MusicService.class);
        startService(musicIntent);

        Intent notifyIntent = new Intent(this,NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast
                (this, NOTIFICATION_REMINDER_NIGHT, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,  System.currentTimeMillis(),
                1000 * 60 * 60 * 24, pendingIntent);
    }


    public void SignUP(View view) {
        Intent intent= new Intent(this,SignUPActivity.class) ;
        startActivity(intent);
    }

    public void login(View view){
        Intent intent= new Intent(this,LogInActivity.class) ;
        startActivity(intent);
    }

}