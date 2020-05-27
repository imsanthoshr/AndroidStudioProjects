package com.greedy.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText cityText;
    EditText resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityText = (EditText) findViewById(R.id.cityText);
        resultText = (EditText) findViewById(R.id.resultText);

    }

    public void getWeather (View view){
        DownloadTask task = new DownloadTask();
        task.execute("https://openweathermap.org/data/2.5/weather?q="+cityText.getText().toString()+"&appid=439d4b804bc8187953eb36d2a8c26a02");
        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(cityText.getWindowToken(),0);
    }

    public class DownloadTask extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... urls) {
            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {

                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();

                while (data != -1) {
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }

                return result;

            } catch (Exception e) {
                e.printStackTrace();
                resultText.setText(null);
                Toast.makeText(getApplicationContext(), "Can't find Weather for that :(", Toast.LENGTH_SHORT).show();
                return null;
            }
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                JSONObject jsonObject = new JSONObject(s);

                String weatherInfo = jsonObject.getString("weather");

                Log.i("Weather content", weatherInfo);

                JSONArray arr = new JSONArray(weatherInfo);
                String message = "";

                for (int i=0; i < arr.length(); i++) {
                    JSONObject jsonPart = arr.getJSONObject(i);

                    String main = jsonPart.getString("main");
                    String description = jsonPart.getString("description");

                    if(!main.equals("") && !description.equals("")){
                        message += "\r\n" + main +" : "+ description + "\r\n";
                    }
                    else{
                        resultText.setText(null);
                        Toast.makeText(getApplicationContext(), "Can't find Weather for that :(", Toast.LENGTH_SHORT).show();
                    }
                }

                if(!message.equals("")){
                    resultText.setText(message);
                }
                else{
                    resultText.setText(null);
                    Toast.makeText(getApplicationContext(), "Can't find Weather for that :(", Toast.LENGTH_SHORT).show();
                }

            } catch (Exception e) {
                resultText.setText(null);
                Toast.makeText(getApplicationContext(), "Can't find Weather for that :(", Toast.LENGTH_SHORT).show();
                e.printStackTrace();

            }

        }
    }
}
