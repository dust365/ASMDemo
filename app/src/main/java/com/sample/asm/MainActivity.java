package com.sample.asm;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startThread();
        MM();
    }

    public void startThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "test").start();
    }



    public void MM() {
//        Log.d("AAA","1111");
//        try {
            Toast.makeText(this,"#####",Toast.LENGTH_LONG).show();
//              String s="qqq";
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        Log.d("AAA","2222");
    }
}


