package com.example.angel.weekend_;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean _thumbButtonPressed = false;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.actThumbUp:
                if (!_thumbButtonPressed) {
                    Toast.makeText(this, "You like this app huh?, so I do!", Toast.LENGTH_SHORT).show();
                    _thumbButtonPressed = true;
                } else
                    Toast.makeText(this, "You already like it!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.itPlaySound:
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.are_you_crazy);
                mediaPlayer.start();
                break;
            case R.id.itCoolActivity:

                Intent intentWebBrowser = new Intent(this, WebBrowser.class);
                startActivity(intentWebBrowser);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
    }
}
