package com.greedy.timerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView textView;
    Button button;
    CountDownTimer countDownTimer;
    boolean counterActive = false;

    public void resetTimer(){
        textView.setText("01 : 00");
        seekBar.setProgress(60);
        seekBar.setEnabled(true);
        button.setText("START");
        counterActive = false;
    }

    public void buttonClicked(View view){
        if(counterActive){
            resetTimer();

        }else {
            counterActive = true;
            seekBar.setEnabled(false);
            button.setText("STOP!");
            countDownTimer = new CountDownTimer(seekBar.getProgress() * 1000 + 100, 1000) {
                @Override
                public void onTick(long l) {
                    updateTimer((int) l / 1000);
                }

                @Override
                public void onFinish() {
                    Log.i("Timer", "Done");
                    MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.air_horn);
                    mediaPlayer.start();
                    resetTimer();
                }
            }.start();
        }

    }

    public void updateTimer(int secleft){

        int min = secleft/60;
        String minstr = Integer.toString(min);
        if(min<=9){
            minstr = "0"+ Integer.toString(min);
        }
        int sec = secleft - (min * 60);
        String secstr = Integer.toString(sec);
        if(sec<=9){
            secstr = "0"+ Integer.toString(sec);
        }
        textView.setText(minstr +" : "+secstr);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        seekBar.setMax(900);
        seekBar.setProgress(60);
        textView.setText("01 : 00");
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                updateTimer(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
