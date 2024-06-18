package com.example.chess_bagrut_final;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AndTheWinnerIs extends AppCompatActivity {

    TextView winner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_and_the_winner_is);
        winner = findViewById(R.id.WinnerColor);

        Intent intent = new Intent();
        String wineer = intent.getStringExtra("Winner");
        winner.setText(wineer);
    }
}