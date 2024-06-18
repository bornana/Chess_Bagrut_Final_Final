package com.example.chess_bagrut_final;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity{
    boolean succesfull = true;
    private DatabaseReference mDatabase;
    private EditText usernameEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Intent musicServiceIntent = new Intent(SignUp.this, MusicService.class);
        startService(musicServiceIntent);

        mDatabase = FirebaseDatabase.getInstance().getReference("users");

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);

        findViewById(R.id.sign_up_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
                if(succesfull){
                    startActivity(new Intent(SignUp.this, PlayOptions.class));
                }
            }
        });
    }

    private void signUp() {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        User newUser = new User(username, password, 0, 0, 0);
        mDatabase.child("users").child(username).setValue(newUser).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                succesfull = true;
                Toast.makeText(SignUp.this, "User Created Successfully", Toast.LENGTH_SHORT).show();
                finish();
            }
            else {
                succesfull = false;
                System.out.println(task.getException());
                Toast.makeText(SignUp.this, "Sign Up Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
