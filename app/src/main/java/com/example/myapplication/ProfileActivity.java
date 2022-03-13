package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int CAMERA_REQUEST = 0;
    private static final int GALLERY_REQUEST = 1;
    //attributes
    private Button buttonCamera, buttonGallery, button2;
    private ImageView imageViewProfile;
    //for picture of camera
    private Bitmap picture;
    private String image;

    private TextView fullname;
    private TextView username;
    private TextView email;
    private TextView age;
    private User u;

    private FirebaseDatabase database = FirebaseDatabase.getInstance("https://joelle-759cf-default-rtdb.europe-west1.firebasedatabase.app/");
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser user = mAuth.getCurrentUser();

    private DatabaseReference myRef = database.getReference("profiles/" + user.getUid());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        buttonCamera = findViewById(R.id.buttonCamera);
        buttonCamera.setOnClickListener(this);
        buttonGallery = findViewById(R.id.buttonGallery);
        buttonGallery.setOnClickListener(this);
        imageViewProfile = findViewById(R.id.imageViewProfile);


        fullname = findViewById(R.id.fullname);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        age = findViewById(R.id.age);


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    u = dataSnapshot.getValue(User.class);
                    Log.i("Profile111", "user" + u + "Id" + user.getUid() + "u" + u.getFullname() + u.getUsername() + u.getEmail() + u.getAge());
                    updateUserData(u);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void updateUserData(User user) {
        fullname.setText(user.getFullname());
        username.setText(user.getUsername());
        email.setText(user.getEmail());
        age.setText(user.getAge());
        Bitmap b = StringToBitMap(user.getImage());
        imageViewProfile.setImageBitmap(b);
    }

    public void SaveImage(Bitmap bitmap) {
        DatabaseReference myRef1 = database.getReference("profiles/" + user.getUid() + "/" + u.getKey());

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] arr = baos.toByteArray();
        image = Base64.encodeToString(arr, Base64.DEFAULT);
        myRef1.child("image").setValue(image);

        //save to fb

    }

    public Bitmap StringToBitMap(String image) {
        try {
            byte[] encodeByte = Base64.decode(image, Base64.DEFAULT);

            InputStream inputStream = new ByteArrayInputStream(encodeByte);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonCamera) {
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i, CAMERA_REQUEST);
        } else {
            Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i, GALLERY_REQUEST);

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST) {
            if (resultCode == RESULT_OK) {
                picture = (Bitmap) data.getExtras().get("data");
                //set image captured to be the new image
                imageViewProfile.setImageBitmap(picture);
                SaveImage(picture);


            }
        } else {
            if (resultCode == RESULT_OK) {
                Uri targetUri = data.getData();
                try {
                    //Decode an input stream into a bitmap.
                    picture = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                    imageViewProfile.setImageBitmap(picture);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}