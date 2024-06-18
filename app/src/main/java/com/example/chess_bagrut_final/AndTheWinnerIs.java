package com.example.chess_bagrut_final;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AndTheWinnerIs extends AppCompatActivity {

    TextView winner;
    ImageView winnerpiece;
    Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_and_the_winner_is);
        winner = findViewById(R.id.WinnerColor);
        winnerpiece = findViewById(R.id.WinnerImage);
        exit = findViewById(R.id.sign_in);
        //Intent intent = new Intent();
        String winnercolor = getIntent().getStringExtra("Winner");
        System.out.println(winnercolor);
        winner.setText(winnercolor + " Wins!");
        if(winnercolor == null) {
            winner.setText("Draw!");
        }
        else if(winnercolor.equals("white")){
            winnerpiece.setImageResource(R.drawable.kingcharles);
        }
        else {
            winnerpiece.setImageResource(R.drawable.tachalarip);
        }

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}