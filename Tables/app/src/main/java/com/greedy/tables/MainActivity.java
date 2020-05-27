package com.greedy.tables;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView tableListView;
    TextView textView;
    TextView textView2;
    
    public void genTable(int tableNumber){
        ArrayList<String> tableContent = new ArrayList<String>();
        textView.setVisibility(View.VISIBLE);
        textView2.setVisibility(View.INVISIBLE);
        for (int j=1;j<=20;j++){
            tableContent.add(j +" * "+ tableNumber +" = " + Integer.toString(j*tableNumber));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,tableContent);
        tableListView.setAdapter(arrayAdapter);
        
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar tableSeekBar = (SeekBar) findViewById(R.id.tableSeekBar);
        tableListView = (ListView) findViewById(R.id.tableListView);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        tableSeekBar.setMax(20);
        tableSeekBar.setProgress(10);
        tableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int tableNumber;
                if(i<min){
                    tableNumber=min;
                    tableSeekBar.setProgress(min);
                }else{
                    tableNumber=i;
                }
                Log.i("Table number  ",Integer.toString(tableNumber));
                textView.setText(Integer.toString(tableNumber) + "'th  Table : ");
                genTable(tableNumber);

                
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
