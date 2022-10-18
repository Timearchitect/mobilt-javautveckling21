package com.gritacademy.firebase

import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley


class ApiCaller(name: String) : Thread(name) {
    public lateinit var test: String
    override fun run() {
        super.run()


    }

    override fun start() {
        super.start()
        val url =  "https://api.openweathermap.org/data/3.0/onecall?lat=33.44&lon=-94.04&exclude=hourly,daily&appid={a30ec4c48c2bd8d198876012abb69e27}"
       // val url = "http://api.openweathermap.org/data/2.5/weather?q=" +
        //        "malmo" + ",se&units=metric&APPID=a30ec4c48c2bd8d198876012abb69e27&mode=json"
        Log.d("weather","delayed")
        Thread.sleep(500)
        Log.d("weather","got it")
        // Send API request with Volley.


    }

    override fun interrupt() {
        super.interrupt()
    }




}