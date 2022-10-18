package com.gritacademy.firebase;

import android.util.Log;

public class AlriksThread extends Thread{

    @Override
    public synchronized void start() {
        super.start();




    }

    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(1000);

            Log.d("alrik","hej");

            Thread.sleep(1000);
            Log.d("alrik","Klar");


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void interrupt() {
        super.interrupt();
    }
}
