package com.gritacademy.firebase;

import android.app.Application;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

public class JavaOpenWeather extends Application {


    public void test(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url =
                "api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=a30ec4c48c2bd8d198876012abb69e27&mode=json";


        JsonObjectRequest JsonRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                 (response) -> {
                        // Display the first 500 characters of the response string.
                        Log.w("weather", response.toString());
                },
                 error -> {
                        Log.w("weather", "error");
                });


    }






}
