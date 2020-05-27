package com.greedy.friendlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myListView = (ListView) findViewById(R.id.myListView);
        final ArrayList<String> friendlist = new ArrayList<>();
        friendlist.add("sreema");
        friendlist.add("prashanth");
        friendlist.add("rishi");
        friendlist.add("hashim");
        friendlist.add("mrudul");
        friendlist.add("viki");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,friendlist);
        myListView.setAdapter(arrayAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Log.i("Selected name  ",friendlist.get(i));
                String selname = friendlist.get(i);
                Toast.makeText(MainActivity.this, selname, Toast.LENGTH_LONG).show();

            }
        });

    }
}
