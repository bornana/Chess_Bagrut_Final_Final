package com.example.chess_bagrut_final;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class PlayOptions extends AppCompatActivity {
    Button pass_and_play, play_with_bot, exit;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_options);
        pass_and_play = findViewById(R.id.pass_and_play);
        play_with_bot = findViewById(R.id.play_with_bot);
        exit = findViewById(R.id.exit);
        Intent musicServiceIntent = new Intent(PlayOptions.this, MusicService.class);
        startService(musicServiceIntent);
        pass_and_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayOptions.this, MainActivity.class);
                intent.putExtra("is_bot", false);
                stopService(musicServiceIntent);
                startActivity(intent);
                finish();
            }
        });
        play_with_bot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(musicServiceIntent);
                Intent intent = new Intent(PlayOptions.this, MainActivity.class);
                intent.putExtra("is_bot", true);
                startActivity(intent);
                finish();
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.exit(0);
            }
        });
    }

}
