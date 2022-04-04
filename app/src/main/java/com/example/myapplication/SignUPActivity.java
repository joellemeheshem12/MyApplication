package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileNotFoundException;
import java.util.Objects;

public class SignUPActivity extends AppCompatActivity  {
    private EditText editTextFullName, editTextUserName, editTextPassword, editTextEmail, editTextAge;
    private RadioButton gender;
    private Button buttonSignUP;
    private FirebaseAuth mAuth;
    private static final String TAG = "FIREBASE";
    private FirebaseAuth maFirebaseAuth = FirebaseAuth.getInstance();
    //write a message to the dataBase
    // gets the root of the real time database in the FB console
    private FirebaseDatabase database = FirebaseDatabase.getInstance("https://joelle-759cf-default-rtdb.europe-west1.firebasedatabase.app/");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_upactivity);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.actionbar)));
        //initialize firebase Auth
        mAuth = FirebaseAuth.getInstance();//gets the instance of the firebase connected th the project
        editTextFullName = findViewById(R.id.editTextFullName);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextUserName = findViewById(R.id.editTextUsername);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextAge = findViewById(R.id.editTextAge);
        buttonSignUP = findViewById(R.id.buttonSignUP);


    }


    public void signUP(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            DatabaseReference myRef = database.getReference("profiles/" + user.getUid());
                            String key = myRef.push().getKey();
                            User u1 = new User(editTextFullName.getText().toString(), email, editTextUserName.getText().toString(), editTextAge.getText().toString());
                            u1.setKey(key);
                            myRef = database.getReference("profiles/" + user.getUid() + "/" + key);
                            myRef.setValue(u1);

                            Intent i = new Intent(SignUPActivity.this, MainActivity2.class);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUPActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }


    public void Submit(View view) {
        signUP(editTextEmail.getText().toString(), editTextPassword.getText().toString());
    }
}