package com.example.loginregister;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONException;
import org.json.JSONObject;

public class Userinfo {
    String ip;
    String country_code;
    String city;
    public Userinfo (String ip, String country_code, String city){
        this.ip = ip;
        this.country_code = country_code;
        this.city = city;

    }
    static Userinfo parseFromJSON (JSONObject object) throws JsonProcessingException, JSONException {
        String ip = object.get("ip").toString();
        String contry_code = object.get("country_code").toString();
        String city = object.get("city").toString();
        return new Userinfo( ip, contry_code, city );

    }
    public String toString (){
      return "Ip andress: " + this.ip + "\n" + "Country code: " + this.country_code + "\n" + "City: " + this.city;
    }
}
