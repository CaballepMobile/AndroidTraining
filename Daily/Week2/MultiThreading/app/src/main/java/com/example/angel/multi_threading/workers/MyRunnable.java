package com.example.angel.multi_threading.workers;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.angel.multi_threading.utils.TaskCreator;

public class MyRunnable implements Runnable {

    Handler handler;

    public MyRunnable(Handler handler){
        this.handler = handler;
    }


    @Override
    public void run() {

        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putString("data", "Task starting");
        message.setData(bundle);

        //Before task ts starting
        this.handler.sendMessage(message);

        //During execution
        try {
            TaskCreator.createSimpleTask(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //After task is completed
        Message messageCompleted = new Message();
        bundle.putString("data", "Task completed");
        messageCompleted.setData(bundle);
        handler.sendMessage(messageCompleted);
    }
}