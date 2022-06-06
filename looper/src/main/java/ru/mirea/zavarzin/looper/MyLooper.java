package ru.mirea.zavarzin.looper;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;


public class MyLooper extends Thread{

    Handler handler;
    int age;
    @SuppressLint("HandlerLeak")
    @Override
    public void run(){
        Log.d("MyLooper", "run");
        Looper.prepare();
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg){
                age = msg.getData().getInt("AGE");
                // задержка
                try {
                    Thread.sleep(age*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Log.d("MyLooper", "Возраст: " + age);
                Log.d("MyLooper", "Работа: " +msg.getData().getString("JOB"));
            }
        };
        Looper.loop();
    }
}
