package com.greedy.dragmedown;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    AudioManager audioManager;

    public  void play(View view){

        mediaPlayer.start();

    }

    public  void  pause(View view){

        mediaPlayer.pause();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        int maxvolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentvolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        mediaPlayer = MediaPlayer.create(this,R.raw.dragmedown);
        SeekBar volumeControl = (SeekBar) findViewById(R.id.volumeseekBar);

        volumeControl.setMax(maxvolume);
        volumeControl.setProgress(currentvolume);
        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                Log.i("volume seekBar moved",Integer.toString(i));
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,i,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        final SeekBar musicseekBar = (SeekBar) findViewById(R.id.musicseekBar);
        musicseekBar.setMax(mediaPlayer.getDuration());
        musicseekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                Log.i(" music seekBar moved",Integer.toString(i));
                mediaPlayer.seekTo(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                musicseekBar.setProgress(mediaPlayer.getCurrentPosition());

            }
        },0,2500);

    }
}
