package com.example.angel.multi_threading.workers;

import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import com.example.angel.multi_threading.utils.TaskCreator;

public class MyThread extends Thread {

    TextView tvMain;
    Handler handler;

    public MyThread(TextView tvMain) {
        this.tvMain = tvMain;
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void run() {
        super.run();

        //Before task is started
        handler.post(new Runnable() {
            @Override
            public void run() {
                tvMain.setText("Task starting");
            }
        });

        //Task is executed
        try {
            TaskCreator.createSimpleTask(this);

        }catch(InterruptedException e){
            e.printStackTrace();
        }

        //Task completed
        handler.post(new Runnable() {
            @Override
            public void run() {
                tvMain.setText("Task finished");
            }
        });
    }
}