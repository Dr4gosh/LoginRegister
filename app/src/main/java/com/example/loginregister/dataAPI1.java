package com.example.loginregister;

import android.os.AsyncTask;

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

public class dataAPI1 extends AsyncTask<Void,Void,Void> {
    String data = "";
    String displayText = "";
    static Userinfo userinfo ;
    @Override
    protected Void doInBackground(Void... voids) {
       try {

           URL url = new URL( "http://api.ipstack.com/check?access_key=0364ca9834a6ca46ba09a77a39ef633f" );
           HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
           InputStream inputStream = httpURLConnection.getInputStream();
           BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( inputStream ) );
           String line = "";
           while(line !=null){
               line = bufferedReader.readLine();
               data = data + line;
           }

           JSONObject JO = new JSONObject(data);
           dataAPI1.userinfo = Userinfo.parseFromJSON( JO );
           this.displayText = userinfo.toString();


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

        MainActivity.data.setText(this.displayText);

    }
}
