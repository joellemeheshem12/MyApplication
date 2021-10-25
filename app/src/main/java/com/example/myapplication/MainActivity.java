package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonLogin,buttonSignUP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonLogin=findViewById(R.id.buttonLogin);
        buttonSignUP=findViewById(R.id.buttonSignUP);
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