package com.greedy.downloadwebcontent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    private Object String;

    public class downloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String result = "";
            URL url;
            HttpsURLConnection urlConnection = null;
            try {
                url = new URL(strings[0]);
                urlConnection = (HttpsURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();

                while (data != -1) {
                    char current = (char) data;
                    result += current;

                }
                return result;
            } catch (Exception e) {
                e.printStackTrace();
                return "Failed";
            }
        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        downloadTask task = new downloadTask();
        String  result = null;
        try {
            result = task.execute("https://zappycode.com").get();
        }catch (Exception e){
            e.printStackTrace();
        }
        Log.i("RESULT",result);
    }
}
