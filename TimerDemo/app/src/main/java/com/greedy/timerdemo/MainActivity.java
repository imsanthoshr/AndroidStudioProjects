package com.greedy.timerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CountDownTimer(10000,1000){

            public void onTick(long millisecondsUntillDone){

                Log.i("Seconds Left ",String.valueOf(millisecondsUntillDone/1000) );

            }

            public void onFinish(){

                Log.i("Done","Time Out");
            }
        }.start();

        /*final Handler handeler = new Handler();

        Runnable run = new Runnable() {
            @Override
            public void run() {

                Log.i("Hey it's sandy here","A second passed by");
                handeler.postDelayed(this,1000);
            }
        };

        handeler.post(run);*/

    }
}
