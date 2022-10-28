package com.gritacademy.canvasgritbackground

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity() {
//    val CAMERA_REQUEST: Int = 1888;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
        } else {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        }

        //   var inflatedView = this.layoutInflater.inflate(R.layout.activity_list_item,null)
        //   var button:Button= inflatedView.findViewById<Button>(R.id.button1)
        //   button.setText("click here")

       val alriksCanvas: AlriksCanvas = AlriksCanvas(this)
        // alriksCanvas.systemUiVisibility= WindowManager.LayoutParams.FLAG_FULLSCREEN
        // alriksCanvas.setSystemUiVisibility( WindowManager.LayoutParams.FLAG_FULLSCREEN)

       setContentView(alriksCanvas)
//
//        val btn = findViewById<View>(R.id.button1) as Button
//
//        btn.setOnClickListener(View.OnClickListener {
//            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//            startActivityForResult(cameraIntent, CAMERA_REQUEST)
//        })
        // requestPermission()
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
//            Toast.makeText(this,"yea",Toast.LENGTH_LONG).show()
//        }
//    }
//
//    private fun requestPermission() {
//        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),
//            CAMERA_REQUEST)
//    }
//
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<String>, grantResults: IntArray,
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        when (requestCode) {
//            CAMERA_REQUEST,
//
//            -> {
//                // If request is cancelled, the result arrays are empty.
//                if ((grantResults.isNotEmpty() &&
//                            grantResults[0] == PackageManager.PERMISSION_GRANTED)
//                ) {
//                    // Permission is granted. Continue the action or workflow
//                    // in your app.
//                    Log.d("alrik", "granted")
//                } else {
//                    // Explain to the user that the feature is unavailable because
//                    // the features requires a permission that the user has denied.
//                    // At the same time, respect the user's decision. Don't link to
//                    // system settings in an effort to convince the user to change
//                    // their decision.
//                    Log.d("alrik", "no granted")
//
//                }
//                return
//            }
//
//            // Add other 'when' lines to check for other
//            // permissions this app might request.
//            else -> {
//                // Ignore all other requests.
//            }
//        }
//    }


}