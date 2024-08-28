package com.gritacademy.helloworldapp;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity  implements SensorEventListener {
    boolean connected;
    FragmentManager fm;
    int fragNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fm = getSupportFragmentManager();

        Log.i("alrik", "onCreate");

        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
        Log.d("alrik", sensor.toString() );

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE); // från mobilen/emulatorn

        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED)
            connected = true;
        else
            connected = false;

        Button b = (Button) findViewById(R.id.connectBtn);
        TextView tv = (TextView) findViewById(R.id.textView);
        ImageView iv = (ImageView) findViewById(R.id.imageView);

        b.setText(R.string.test); // setText från resurs mappen

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
            }
        };

        b.setOnClickListener((e)-> {
                Toast.makeText(MainActivity.this, "Change Fragemnts", Toast.LENGTH_SHORT).show();
                tv.setText(String.valueOf(connected));

        if(fragNumber==1) {
            fm.beginTransaction()
                    .add(R.id.fragmentContainerView2, BlankFragment2.class, null) // gets the first animations
                    .commit();
            fragNumber=2;
        }else{
            fm.beginTransaction()
                    .add(R.id.fragmentContainerView2, BlankFragment.class, null) // gets the first animations
                    .commit();
            fragNumber=1;
        }


        });


        ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback(){
            @Override
                public void onAvailable( Network network) {
                connected=true;
                tv.setText(String.valueOf(connected? "CONNECTED" : "DISCONNECTED" ));
            }
            @Override
            public void onLost( Network network) {
                connected=false;
                tv.setText(String.valueOf(connected? "CONNECTED" : "DISCONNECTED" ));
            }
        };

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            connectivityManager.registerDefaultNetworkCallback(networkCallback);
        }



        int count = 0;
        float xRotation = 0, zRotation = 0;
        while (count < 100) {
            count++;
            Log.i("alrik", String.valueOf(count));
        }
//
//        b.setOnClickListener( e -> {
//            Toast.makeText(this, "ALRIK YO!!", Toast.LENGTH_LONG).show();
//            tv.setText("TJENARE!!! Torsten");
//        });
//        View.OnClickListener onClickListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, String.valueOf(view.getId()), Toast.LENGTH_SHORT).show();
//            }
//        };
//        b.setOnClickListener(onClickListener);
//        b.setOnClickListener(  v ->   {
//            Toast.makeText(this, String.valueOf(((Button)v).getText()), Toast.LENGTH_SHORT).show();
//        });

        if (true) {
            System.out.println("TJENA");
            Log.i("alrik", "Hello World");
            Toast.makeText(this, String.valueOf(connected), Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.d("alrik", Arrays.toString(   sensorEvent.values) );

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override
    protected void onStart() {
        super.onStart();
       // Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
        Log.i("alrik", "onStart");


    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
        Log.i("alrik", "onSTop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
        Log.i("alrik", "ondestroy");


    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
        Log.i("alrik", "onPause");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("alrik", "onResume");

    }

}