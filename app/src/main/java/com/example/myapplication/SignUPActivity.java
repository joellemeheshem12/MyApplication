package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUPActivity extends AppCompatActivity {
    private EditText editTextFullName,editTextUserName,editTextPassword,editTextEmail;
    private Button buttonSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_upactivity);
        editTextFullName=findViewById(R.id. editTextFullName);
        editTextPassword=findViewById(R.id.editTextPassword);
        editTextUserName=findViewById(R.id.editTextUsername);
        editTextEmail=findViewById(R.id.editTextEmail);

        buttonSubmit=findViewById(R.id.buttonSubmit);
    }

    public void Submit(View view) {
        Intent intent= new Intent(this,WelcomeActivity.class) ;
        if(!editTextEmail.getText().toString().equals("")&&editTextEmail.getText().toString().contains("@")&&editTextEmail.getText().toString().contains("."))
        {
            intent.putExtra("name", editTextEmail.getText().toString());
            startActivity(intent);
        }
    }
}