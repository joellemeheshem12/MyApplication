package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;


public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.actionbar)));
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
            case R.id.profile_menu:
                Toast.makeText(this, "Profile", Toast.LENGTH_LONG).show();
                Intent intent= new Intent(this,ProfileActivity.class) ;
                startActivity(intent);
                break;
            case R.id.exit_menu:
                // closeApplication();
                this.finishAffinity();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick1(View view) {
        Intent intent= new Intent(this,ArrayListActivity.class) ;
        startActivity(intent);
    }

    public void onClick2(View view) {
        Intent intent= new Intent(this,InfoActivity.class) ;
        startActivity(intent);
    }

    public void onClick3(View view) {
        Intent intent= new Intent(this,VideoActivity.class) ;
        startActivity(intent);
    }
}