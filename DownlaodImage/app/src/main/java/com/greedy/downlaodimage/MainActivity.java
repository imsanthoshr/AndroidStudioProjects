package com.greedy.downlaodimage;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;

    public void downloadImage(View view){
        Log.i("Button","Pressed");
        imageDownloader task = new imageDownloader();
        Bitmap myimage;
        try {
            myimage = task.execute("https://upload.wikimedia.org/wikipedia/en/a/aa/Bart_Simpson_200px.png").get();
            imageView.setImageBitmap(myimage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    public class imageDownloader extends AsyncTask<String,Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... urls) {
                try {
                    URL url = new URL(urls[0]);
                    HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                    connection.connect();
                    InputStream in = connection.getInputStream();
                    Bitmap mybitmap = BitmapFactory.decodeStream(in);
                    return  mybitmap;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }

        }
    }
}
