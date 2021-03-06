package com.example.angel.multi_threading.workers;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.example.angel.multi_threading.utils.Tagger;
import com.example.angel.multi_threading.utils.TaskCreator;

public class MyAsyncTask extends AsyncTask<String, Integer, String> {

    TextView tvMain;

    public MyAsyncTask(TextView tvMain) {
        this.tvMain = tvMain;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        tvMain.setText("Task starting...");
        Log.d(Tagger.get(this), "onPreExecute: Thread: " + Thread.currentThread().getName());
    }

    @Override
    protected String doInBackground(String... strings) {
        Log.d(Tagger.get(this), "doInBackground: " + strings[0]);
        Log.d(Tagger.get(this), "doInBackground: Thread: " + Thread.currentThread().getName());

        publishProgress(1);

        try {
            TaskCreator.createSimpleTask(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Task completed lulululu";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Log.d(Tagger.get(this), "onProgressUpdate: Thread: " + Thread.currentThread().getName());
        tvMain.setText("Task in progress");
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        tvMain.setText(s);
        Log.d(Tagger.get(this), "onPostExecute: Thread: " + Thread.currentThread().getName());
    }
}
