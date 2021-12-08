package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ArrayListActivity extends AppCompatActivity
{

    //the object of the view- design
   private ListView myListView;
   //the object for the adaptor connecting the data to the view
   private CustomAdaptor myAdapter;
   //object containing the items to be displayed - data
   private ArrayList<Item> list;

   private FirebaseAuth maFirebaseAuth = FirebaseAuth.getInstance();
   private FirebaseDatabase database = FirebaseDatabase.getInstance("https://joelle-759cf-default-rtdb.europe-west1.firebasedatabase.app/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_list);
        // Write a message to the database

        String UID =maFirebaseAuth.getUid();
        DatabaseReference myRef = database.getReference("users");
        myRef.push().setValue(new Item("This is my first item",R.drawable.img,true,50));
        list = new ArrayList<>();

        list.add(new Item("This is my first Item",R.drawable.img,true,50));
        list.add(new Item("This is my second item",R.drawable.img,true,50));

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

    }

}