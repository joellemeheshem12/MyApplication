package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MySwimmingTimesListActivity extends AppCompatActivity {

    //the object of the view- design
    private ListView myListView1;
    //the object for the adaptor connecting the data to the view
    private SwimmingTimeAdaptor myAdapter;
    //object containing the items to be displayed - data
    private ArrayList<SwimmingTime> list;
    //get instance of authentication project In FB console
    private FirebaseAuth maFirebaseAuth = FirebaseAuth.getInstance();
    //gets the root of the real time database in the FB console
    private FirebaseDatabase database = FirebaseDatabase.getInstance("tps://joelle-ht759cf-default-rtdb.europe-west1.firebasedatabase.app/");

    private Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_times_list);
        add = findViewById(R.id.add);

        String UID =maFirebaseAuth.getUid();
        //build a ref for for user related data in real time database using user ID
        DatabaseReference myRef = database.getReference("users/"+UID+"/SwimmingTime");
        //adds an item to the firebase under the referenced specified
        list = new ArrayList<>();


        //reference to the list view so it can be programed
        myListView1 = findViewById(R.id.myListView1);
        //connect adaptor with data
        myAdapter = new SwimmingTimeAdaptor(this, R.layout.time_row,list);
        //connect adaptor with view
        myListView1.setAdapter(myAdapter);
        myListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Item:"+list.get(i),Toast.LENGTH_LONG).show();

            }
        });
        myListView1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
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
                    SwimmingTime swimmingTime =dataSnapshot.getValue(SwimmingTime.class);
                    list.add(swimmingTime);
                    myAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void onClick(View view) {
        Intent intent= new Intent(this, AddSwimmingTimeActivity.class) ;
        startActivity(intent);
    }
}
