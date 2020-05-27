package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public void curconveb(View view){
        Log.i("info","Button pressed !!");
        EditText editText=(EditText) findViewById(R.id.editText);
        String dollarv = editText.getText().toString();
        Double dollardouble = Double.parseDouble(dollarv);
        Double INRdouble = dollardouble * 71.56;
        String INRv = Double.toString(INRdouble);
        Log.i("dollar",editText.getText().toString());
        Toast.makeText(this, "$ "+dollarv+" is about  ₹ "+INRv, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
