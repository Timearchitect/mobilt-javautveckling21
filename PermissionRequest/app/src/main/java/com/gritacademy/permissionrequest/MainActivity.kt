package com.gritacademy.permissionrequest

import android.app.Activity
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    val CAMERA_PERMISSION_CODE=112
    val RECORD_PERMISSION_CODE=101
    lateinit var camBtn:Button
    lateinit var micBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        camBtn = findViewById<Button>(R.id.button2)
        micBtn = findViewById<Button>(R.id.button)

        camBtn.setOnClickListener(){
            checkPermission(android.Manifest.permission.CAMERA,CAMERA_PERMISSION_CODE)
        }
        micBtn.setOnClickListener(){
            checkPermission(android.Manifest.permission.RECORD_AUDIO,RECORD_PERMISSION_CODE)
        }
        var frag = BlankFragment()

        val mBundle = Bundle()
        mBundle.putString("mText","testing")
        frag.arguments = mBundle  //sätter in data i fragment

        supportFragmentManager.beginTransaction().replace(R.id.frame,frag).commit()
       // frag?.btn?.setText("hello")

    }

    fun checkPermission(permission:String,requestCode : Int){
        if(ContextCompat.checkSelfPermission(this,permission) == PackageManager.PERMISSION_GRANTED)
            Toast.makeText(this,"access already granted",Toast.LENGTH_LONG).show()
        else
            ActivityCompat.requestPermissions(this,arrayOf(permission),requestCode) // tar up dialogbox

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            CAMERA_PERMISSION_CODE->
            if(grantResults.size>0 &&grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                camBtn.setText("camera granted");
                Toast.makeText(this,"Camera permission granted",Toast.LENGTH_LONG).show()
            }else
                Toast.makeText(this,"Camera permission denied",Toast.LENGTH_LONG).show()

            RECORD_PERMISSION_CODE->
                if(grantResults.size>0 &&grantResults[0]==PackageManager.PERMISSION_GRANTED)
                {
                    micBtn.setText("record granted");
                    Toast.makeText(this,"Record permission granted",Toast.LENGTH_LONG).show()
                }else
                    Toast.makeText(this,"Record permission denied",Toast.LENGTH_LONG).show()
        }
    }
}