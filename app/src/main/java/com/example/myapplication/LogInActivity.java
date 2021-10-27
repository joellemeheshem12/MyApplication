package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class LogInActivity extends AppCompatActivity implements View.OnLongClickListener ,DialogInterface.OnClickListener{
    private static final String TAG = "FIREBASE";
    private EditText  editTextUsername,editTextPassword;
private Button buttonLogin,buttonSignUP;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //return a reference to the  instance of the project firebase
        mAuth = FirebaseAuth.getInstance();
        editTextUsername=findViewById(R.id. editTextUsername);
        editTextPassword=findViewById(R.id.editTextPassword);
        buttonLogin=findViewById(R.id.buttonLogin);
        //sets the required button to response to long click, otherwise it won't
        buttonLogin.setOnLongClickListener(this);
        buttonSignUP=findViewById(R.id.buttonSignUP);
        SharedPreferences sp = getSharedPreferences("settings",MODE_PRIVATE);
        String username = sp.getString("username","");
        String password = sp.getString("password","");
        if(username.equals("")&& !password.equals(""))
        {
            editTextUsername.setText(username);
            editTextPassword.setText(password);
        }

    }
    public void login(View view){
        Intent intent= new Intent(this,IntroActivity.class) ;
        if(!editTextUsername.getText().toString().equals("")&&editTextUsername.getText().toString().contains("@")&&editTextUsername.getText().toString().contains("."))
        {
            //saving email and  password of user in a local file for future use
            SharedPreferences sp= getSharedPreferences("settings",MODE_PRIVATE);
            //open editor for editing
            SharedPreferences.Editor editor= sp.edit();
            //write the wanted settings
            editor.putString("username",editTextUsername.getText().toString());
            editor.putString("password",editTextPassword.getText().toString());
            //save and close file
            editor.commit();
            intent.putExtra("username", editTextUsername.getText().toString());

            login(editTextUsername.getText().toString(),editTextPassword.getText().toString());

            startActivity(intent);
        }
    }

    public void SignUP(View view) {
        Intent intent= new Intent(this,SignUPActivity.class) ;
        startActivity(intent);
    }

    public void onClick(DialogInterface dialog, int which)
    {
        if(which==dialog.BUTTON_POSITIVE)
        {
            super.onBackPressed();
            dialog.cancel();
        }
        if(which==dialog.BUTTON_NEGATIVE)
        {
            dialog.cancel();
        }
    }
    public void onBackPressed()
    {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setMessage("Are you sure?");
        builder.setCancelable(false);
        builder.setPositiveButton("YES",this);
        builder.setNegativeButton("NO",this);
        AlertDialog dialog= builder.create();
        dialog.show();
    }

    @Override
    public boolean onLongClick(View view) {
        return false;
    }

    public void login(String email,String password)
    {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent i = new Intent(LogInActivity.this,IntroActivity.class);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LogInActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }


                    }
                });
    }


}