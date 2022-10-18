package com.gritacademy.firebase

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import org.json.JSONObject
import org.json.simple.parser.JSONParser
import java.util.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val logTag = "test"
        Log.d(logTag, "start")
        threadsExample()
        firebaseCodes()
        openWeather()

        setContentView(R.layout.activity_main)
    }

    private fun threadsExample() {
        var at = AlriksThread()
        at.start();
        var at2 = AlriksThread()
        at2.start();
        var at3 = AlriksThread()
        at3.start();

        var t: ApiCaller = ApiCaller("weather")
        t.start()
    }

    private fun openWeather() {
        val API_KEY = "a30ec4c48c2bd8d198876012abb69e27"
        val url2 =
            "https://api.openweathermap.org/data/3.0/onecall?lat=33.44&lon=-94.04&exclude=hourly,daily&appid=a30ec4c48c2bd8d198876012abb69e27&mode=json"
        val url3 =
            "api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=a30ec4c48c2bd8d198876012abb69e27&mode=json"

        val url = "http://api.openweathermap.org/data/2.5/weather?q=" +
                "malmo" + ",se&units=metric&APPID=034e4427ae8ee2ed99f6d8fcf3deca16&mode=json"


        val queue = Volley.newRequestQueue(this)


        val JsonRequest = JsonObjectRequest(Request.Method.GET, url, null,
            { response: JSONObject ->
                // Display the first 500 characters of the response string.
                Log.w("weather", response.toString())

                try {
                    // Simple-json lib
                    val parser = JSONParser()
                    val coord: Any = response.get("coord")
                    val weather: Any = response.get("weather")
                    Log.w("weather", coord.toString())
                    Log.w("weather", weather.toString())


                } catch (e: Exception) {
                    Log.e("weather", e.message.toString())
                }

            },
            { error: VolleyError ->
                Log.w("weather", "error")
            })


        queue.add(JsonRequest)
    }

    internal fun firebaseCodes() {
        val db = Firebase.firestore

        val user = hashMapOf(
            "username" to "Alrik",
            "password" to "1234567"
        )

        // Add a new document with a generated ID
        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d("alrik", "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w("alrik", "Error adding document", e)
            }
        // läsa
        db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("alrik", "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w("alrik", "Error getting documents.", exception)
            }

        //listeners
        val docRef = db.collection("users").document("KGPyCjygYYHn7b95NiR6")
        docRef.addSnapshotListener { snapshot, e ->
            if (e != null) {
                Log.w("alrik", "Listen failed.", e)
                return@addSnapshotListener
            }

            if (snapshot != null && snapshot.exists()) {
                Log.d("alrik", "Current data: ${snapshot.data}")
            } else {
                Log.d("alrik", "Current data: null")
            }
        }
    }
}