package com.example.angel.multi_threading;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.angel.multi_threading.utils.Tagger;
import com.example.angel.multi_threading.workers.MyAsyncTask;
import com.example.angel.multi_threading.workers.MyRunnable;
import com.example.angel.multi_threading.workers.MyThread;

public class MainActivity extends AppCompatActivity implements Handler.Callback  {

    private TextView tvMain;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMain = findViewById(R.id.tvMain);
        handler = new Handler(this); //Handler.Callback, this is aiming to handleMessage method

        //Another option:
        /*
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                return false;
            }
        });
        */

        Log.d(Tagger.get(getApplicationContext()), "onCreate: " + Thread.currentThread().getName());
    }

    public void onMultithreading(View view) {

        Log.d(Tagger.get(getApplicationContext()), "onMultithreading: " + Thread.currentThread().getName());

        switch (view.getId()) {

            case R.id.btnThread:
                MyThread myThread = new MyThread(tvMain);
                myThread.start();
                break;

            case R.id.btnRunnable:

                MyRunnable myRunnable = new MyRunnable(handler);
                //myRunnable.run(); //Does not run

                Thread thread = new Thread(myRunnable);
                thread.start(); //Run runnable in a new Thread
                break;

            case R.id.btnAsyncTask:

                MyAsyncTask myAsyncTask = new MyAsyncTask(tvMain);
                myAsyncTask.execute("This is just if you want to use the doInBackground string parameter!");

                break;

        }
    }

    @Override
    public boolean handleMessage(Message message) {

        tvMain.setText(message.getData().getString("data"));
        return false;
    }
}