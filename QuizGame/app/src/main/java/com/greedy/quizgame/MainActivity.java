package com.greedy.quizgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.Random;

import static android.transition.Fade.IN;
import static android.view.View.INVISIBLE;

public class MainActivity extends AppCompatActivity {

    Button goButton;
    TextView timeTextView;
    TextView scoreTextView;
    TextView quizTextView;
    TextView resultTextView;
    TextView startTextView;
    Button buttonA;
    Button buttonB;
    Button buttonC;
    Button buttonD;
    Button playAgainButton;
    ConstraintLayout gameLayout;
    int locationOfCorrectAns;
    int score = 0;
    int noOfQuestions = 0;

    ArrayList<Integer> ans = new ArrayList<Integer>();

    public void start(View view){
        goButton.setVisibility(View.INVISIBLE);
        startTextView.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);
        playAgain(findViewById(R.id.timeTextView));
    }

    public void  chooseAns(View view){
        resultTextView.setVisibility(View.VISIBLE);
        Log.i("Tag : ",view.getTag().toString());
        if(Integer.toString(locationOfCorrectAns).equals(view.getTag().toString())){
            score++;
            Log.i("Result","correct");
            resultTextView.setText("CORRECT !");
        }else{
            Log.i("Result","wrong");
            resultTextView.setText("WRONG :(");
        }
        noOfQuestions++;
        scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(noOfQuestions));
        newQuestion();
    }

    public void newQuestion(){
        Random rand = new Random();
        Random rand1 = new Random();
        int a = rand.nextInt(31);
        int b = rand.nextInt(31);

        quizTextView.setText(Integer.toString(a) + "+" + Integer.toString(b));
        locationOfCorrectAns = rand.nextInt(4);
        ans.clear();
        for(int i = 0;i<4;i++){
            if(i==locationOfCorrectAns){
                ans.add(a+b);
            }else{
                int wrongAns = rand.nextInt(61);
                while(wrongAns == (a+b)){
                    wrongAns = rand1.nextInt(61);
                }
                ans.add(wrongAns);
            }
        }
        buttonA.setText(Integer.toString(ans.get(0)));
        buttonB.setText(Integer.toString(ans.get(1)));
        buttonC.setText(Integer.toString(ans.get(2)));
        buttonD.setText(Integer.toString(ans.get(3)));

    }

    public void playAgain(View view){
        playAgainButton.setVisibility(View.INVISIBLE);
        resultTextView.setVisibility(View.INVISIBLE);
        score = 0;
        noOfQuestions = 0;
        timeTextView.setText("30s");
        scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(noOfQuestions));
        newQuestion();
        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long l) {
                timeTextView.setText(String.valueOf(l/1000) + "s");
            }

            @Override
            public void onFinish() {
                resultTextView.setText("Time's Up !");
                playAgainButton.setVisibility(View.VISIBLE);
            }
        }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goButton = (Button) findViewById(R.id.goButton);
        startTextView = (TextView) findViewById(R.id.startTextView);
        timeTextView = (TextView) findViewById(R.id.timeTextView);
        scoreTextView = (TextView) findViewById(R.id.scoreTextView);
        quizTextView = (TextView) findViewById(R.id.quizTextView);
        resultTextView = (TextView) findViewById(R.id.resultTextView);
        buttonA = (Button) findViewById(R.id.buttonA);
        buttonB = (Button) findViewById(R.id.buttonB);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonD = (Button) findViewById(R.id.buttonD);
        playAgainButton = (Button) findViewById(R.id.playAgainButton);
        gameLayout = (ConstraintLayout) findViewById(R.id.gameLayout);
        goButton.setVisibility(View.VISIBLE);
        gameLayout.setVisibility(View.INVISIBLE);


    }
}
