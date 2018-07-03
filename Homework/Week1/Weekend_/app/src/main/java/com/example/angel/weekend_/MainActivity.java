package com.example.angel.weekend_;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent;
        switch (item.getItemId()){
            case R.id.itProfile:

                intent = new Intent(getApplicationContext(), Profile.class);
                setIntent(intent);

            break;
            case R.id.itSettings:

                intent = new Intent(getApplicationContext(), Settings.class);
                setIntent(intent);

            break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
