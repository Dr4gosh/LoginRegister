package com.example.loginregister;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class Userinfo2 {
    JSONArray weather;
    String main;
    String temp;
    String temp_min;
    String temp_max;
    String pressure;
    public Userinfo2 (String main, String temp, String temp_min, String temp_max, String pressure){
        this.main = main;
        this.temp = temp;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.pressure = pressure;
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    static Userinfo2 parseFromJSON (JSONObject object) throws JsonProcessingException, JSONException {

        JSONObject main_temp = (JSONObject) object.get("main");
        JSONObject weather = (JSONObject) ((JSONArray) object.get("weather")).opt(0);
        String main = (String) weather.get("description");
        String temp = main_temp.get("temp").toString();
        String temp_min =  main_temp.get("temp_min").toString();
        String temp_max = main_temp.get("temp_max").toString();
        String pressure = main_temp.get("pressure").toString();
        return new Userinfo2( main, temp, temp_min, temp_max, pressure);

    }
    public String toString (){
        return "MAIN: " + this.main + "\n" + "TEMP MEDIE: " + this.temp + "\n" + "TEMP MIN: " + this.temp_min+ "\n" + "TEMP MAX: " + this.temp_max+ "\n" + "PRESSURE: " + this.pressure;
    }
}
