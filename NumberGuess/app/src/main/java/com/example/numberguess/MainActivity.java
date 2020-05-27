package com.example.numberguess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomnum;

    public void Generaterandomnum(){
        Random rand = new Random();
        randomnum=rand.nextInt(50)+1;
    }

    public void guessb(View view){
        EditText editText = (EditText) findViewById(R.id.editText);
        int guessnum = Integer.parseInt(editText.getText().toString());
        String message;

        if(guessnum > randomnum){
            message="Guess Lesser!";
        }else if(guessnum < randomnum){
            message="Guess Higher!";
        }else{
            message="You got it..Now guess another";
            Generaterandomnum();
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Log.i("Guessed num",editText.getText().toString());
        Log.i("button","pressed");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Generaterandomnum();
    }
}
