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
    private Button buttonLogin,buttonSignUP,buttonCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonLogin=findViewById(R.id.buttonLogin);
        buttonSignUP=findViewById(R.id.buttonSignUP);
        buttonCamera=findViewById(R.id.buttonCamera);
    }
    public void SignUP(View view) {
        Intent intent= new Intent(this,SignUPActivity.class) ;
        startActivity(intent);
    }
    public void login(View view){
        Intent intent= new Intent(this,LogInActivity.class) ;
        startActivity(intent);
    }


    public void Submit(View view) {
        Intent intent= new Intent(this,ProfileActivity.class) ;
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings_menu:
                Toast.makeText(this, "Settings", Toast.LENGTH_LONG).show();
                break;
            case R.id.exit_menu:
                this.finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}