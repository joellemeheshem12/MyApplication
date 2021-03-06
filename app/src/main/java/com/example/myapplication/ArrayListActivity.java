package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

public class ArrayListActivity extends AppCompatActivity implements View.OnClickListener
{

    //the object of the view- design
   private ListView myListView;
   //the object for the adaptor connecting the data to the view
   private CustomAdaptor myAdapter;
   //object containing the items to be displayed - data
   private ArrayList<Train> list;
   //get instance of authentication project In FB console
   private FirebaseAuth maFirebaseAuth = FirebaseAuth.getInstance();
   //gets the root of the real time database in the FB console
   private FirebaseDatabase database = FirebaseDatabase.getInstance("https://joelle-759cf-default-rtdb.europe-west1.firebasedatabase.app/");
   private FloatingActionButton createnotefab;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_list);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.actionbar)));

        String UID =maFirebaseAuth.getUid();
        //build a ref for for user related data in real time database using user ID
        DatabaseReference myRef = database.getReference("users/"+UID+"/Trainning");
       //adds an item to the firebase under the referenced specified
        list = new ArrayList<>();

        createnotefab=findViewById(R.id.createnotefab);


        //reference to the list view so it can be programed
        myListView = findViewById(R.id.myListView);
        //connect adaptor with data
        myAdapter = new CustomAdaptor(this, R.layout.item_row,list);
        //connect adaptor with view
        myListView.setAdapter(myAdapter);
       myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Toast.makeText(getApplicationContext(),"Item:"+list.get(i),Toast.LENGTH_LONG).show();

           }
       });
        myListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                list.remove(i);
                myAdapter.notifyDataSetChanged();
                return false;
            }
        });

      myRef.addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot snapshot) {
              for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                Train train =dataSnapshot.getValue(Train.class);
                list.add(train);
                myAdapter.notifyDataSetChanged();
              }
          }

          @Override
          public void onCancelled(@NonNull DatabaseError error) {

          }
      });




    }

    public void onClick(View view) {
        Intent intent= new Intent(this,AddTrainingActivity.class) ;
        startActivity(intent);
    }




}