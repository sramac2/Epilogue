package com.example.android.epilogue;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Date;

public class DataActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView puffUsedToday;
    int puffused = 0;
    long last = new Date().getTime();
    int podWeek = 25;
    int noExceed = 2;
    TextView lastUsed;
    TextView podsThisWeek;
    TextView noOfExceeded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        puffUsedToday = findViewById(R.id.textView4);
        lastUsed = findViewById(R.id.textView5);
        podsThisWeek = findViewById(R.id.textView6);
        noOfExceeded = findViewById(R.id.textView7);
        final AlertDialog.Builder builder = new AlertDialog.Builder(DataActivity.this);
        builder.setMessage("Warning")
                .setTitle("You already have reched your limit ");
        builder.setNegativeButton("Ok!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                puffused++;
                podWeek++;
                puffUsedToday.setText("Number of puffs today: "+puffused);
                lastUsed.setText("Last Used "+"10:05 am");
                podsThisWeek.setText("Pods used this week: "+podWeek);
                noOfExceeded.setText("Number of time exceeded: "+noExceed);

                if(puffused==4){
                    builder.setMessage("You already have reched your limit ")
                            .setTitle("Warning! ");
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                else if(puffused==8){
                    noExceed++;
                    builder.setMessage("Warning")
                            .setTitle("You have reached your limit!");
                    AlertDialog dialog = builder.create();
                    dialog.show();

                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.data, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_main) {
            // Handle the camera action
        } else if (id == R.id.nav_daily_progress) {
            Intent intent = new Intent(DataActivity.this,ProgressActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_rewards) {
            Intent intent = new Intent(DataActivity.this, RewardsActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_settings) {
            Intent intent  = new Intent(DataActivity.this, SettingsActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
