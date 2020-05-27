package com.greedy.basicpharases;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public void playphrase(View view){

        Button buttonpressed = (Button) view;
        Log.i("button pressed",buttonpressed.getTag().toString());
        MediaPlayer mediaPlayer = MediaPlayer.create(this, getResources().getIdentifier(buttonpressed.getTag().toString(), "raw", getPackageName()));
        mediaPlayer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
