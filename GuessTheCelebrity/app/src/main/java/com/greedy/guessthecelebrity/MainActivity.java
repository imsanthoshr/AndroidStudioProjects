package com.greedy.guessthecelebrity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class MainActivity extends AppCompatActivity {


    public class downloadTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... urls) {
            String result = "";
            URL url ;
            HttpsURLConnection urlConnection = null;
            try{
                url=new URL(urls[0]);
                urlConnection = (HttpsURLConnection)url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();
                while (data != -1){
                    char current = (char) data;
                    result+=current;
                    data = reader.read();
                }
                return result;

            }catch(Exception e){
                e.printStackTrace();
                return null;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        downloadTask task = new downloadTask();
        String result = "";
        try{
            task.execute("https://www.google.com").get();
            Log.i("URL  ",result);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
