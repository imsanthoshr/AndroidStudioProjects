package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    boolean sivaisshowing = true;
    public void fade(View view){
        Log.i("info","image tapped");
        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        ImageView imageView1 = (ImageView)findViewById(R.id.imageView1);
        if(sivaisshowing){
            sivaisshowing = false;
            imageView.animate().alpha(0).setDuration(1000);
            imageView1.animate().alpha(1).setDuration(1000);
        }else{
            sivaisshowing = true;
            imageView.animate().alpha(1).setDuration(1000);
            imageView1.animate().alpha(0).setDuration(1000);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
