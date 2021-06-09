package com.example.loginregister;

import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.RequiresApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class dataAPI2 extends AsyncTask<Void,Void,Void> {
    String data2 = "";
    String displayText2 = "";
    String API_key = "7c6021a28721316e55523cfacebade8e";

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected Void doInBackground(Void... voids) {
        try {

            URL url = new URL( "http://api.openweathermap.org/data/2.5/weather?q=" + dataAPI1.userinfo.city + "&appid=" + this.API_key );
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( inputStream ) );
            String line = "";
            while(line !=null){
                line = bufferedReader.readLine();
                data2 = data2 + line;
            }

            JSONObject JO = new JSONObject(data2);
            Userinfo2 userinfo2 = Userinfo2.parseFromJSON( JO );
            this.displayText2 = userinfo2.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute( aVoid );

        MainActivity.data.setText(this.displayText2);

    }
}
