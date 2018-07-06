package com.example.angel.multi_threading.utils;

import android.util.Log;

public class TaskCreator {

    public static void createSimpleTask(Object object) throws InterruptedException{
        for (int i = 0; i < 5; i++) {

            Thread.sleep(500);
            Log.d(Tagger.get(object), "createSimpleTask: "
                    + " Thread: "
                    + 1
                    +Thread.currentThread().getName());


        }
    }
}
