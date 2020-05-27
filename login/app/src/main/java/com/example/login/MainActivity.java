package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public void loginb(View view){
        EditText editText = (EditText) findViewById(R.id.editText);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        Log.i("info","it worked");
        Log.i("user_name",editText.getText().toString());
        Log.i("password",editText2.getText().toString());
        Toast.makeText(this, "HI "+editText.getText().toString()+"!!!", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
