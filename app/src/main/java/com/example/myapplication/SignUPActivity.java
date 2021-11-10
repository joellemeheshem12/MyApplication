package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUPActivity extends AppCompatActivity {
    private EditText editTextFullName,editTextUserName,editTextPassword,editTextEmail;
    private Button buttonSignUp;
    private FirebaseAuth mAuth;
    private static final String TAG = "FIREBASE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_upactivity);
        //initialize firebase Auth
        mAuth = FirebaseAuth.getInstance();//gets the instance of the firebase connected th the project
        editTextFullName=findViewById(R.id. editTextFullName);
        editTextPassword=findViewById(R.id.editTextPassword);
        editTextUserName=findViewById(R.id.editTextUsername);
        editTextEmail=findViewById(R.id.editTextEmail);

        buttonSignUp=findViewById(R.id.buttonSignUP);

    }

    public void Submit(View view) {
        signup(editTextEmail.getText().toString(),editTextPassword.getText().toString());
    }
    public void signup(String name ,String password){
        mAuth.createUserWithEmailAndPassword(name, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent i = new Intent(SignUPActivity.this,IntroActivity.class);
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


}