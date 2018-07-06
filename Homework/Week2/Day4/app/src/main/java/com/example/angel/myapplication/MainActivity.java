package com.example.angel.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}


/*
1. Use implicit intents
	a) to take a picture from the phone and show it in the ImageView.
	b) share string with other apps (Mail, Sms etc)
	c) to call a number directly from the app (by parse Phone number)
2. Have a EMI calculator which updates the textview with an integer value which can be updated using a “seekbar” as we move it left and right.  And calculate the EMI.
3. have a user form to add person object and then pass the list of persons to the another activity to view all persons in a ListView. (You can use the toString() for each item in the listView)

 */