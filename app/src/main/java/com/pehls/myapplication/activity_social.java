package com.pehls.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class activity_social extends AppCompatActivity
implements android.support.design.widget.NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_social);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Breve novas redes sociais", Toast.LENGTH_LONG).show();

            }
        });
        android.support.v4.widget.DrawerLayout drawer = (android.support.v4.widget.DrawerLayout) findViewById(R.id.drawer_layout_social);
        drawer.setDrawerTitle(0,"");
        android.support.v7.app.ActionBarDrawerToggle toggle = new android.support.v7.app.ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        android.support.design.widget.NavigationView navigationView = (android.support.design.widget.NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);

    }
     @Override
    public void onBackPressed() {
        android.support.v4.widget.DrawerLayout drawer = (android.support.v4.widget.DrawerLayout) findViewById(R.id.drawer_layout_social);
        if (drawer.isDrawerOpen(android.support.v4.view.GravityCompat.START)) {
            drawer.closeDrawer(android.support.v4.view.GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
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
    public boolean onNavigationItemSelected(android.view.MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_login) {
            android.content.Intent abreAtividadeLogin = new android.content.Intent(this, login_activity.class);
            startActivity(abreAtividadeLogin);
        } else if (id == R.id.nav_gallery) {
            android.content.Intent abreAtividadeGallery = new android.content.Intent(this, bookListActivity.class);
            startActivity(abreAtividadeGallery);
        } else if (id == R.id.nav_social) {
            android.content.Intent abreAtividadeSocial = new android.content.Intent(this, activity_social.class);
            startActivity(abreAtividadeSocial);
        } else if (id == R.id.nav_manage) {
            android.content.Intent abreAtividadeConfig = new android.content.Intent(this, Configs.class);
            startActivity(abreAtividadeConfig);
        }

        android.support.v4.widget.DrawerLayout drawer = (android.support.v4.widget.DrawerLayout) findViewById(R.id.drawer_layout_social);
        drawer.closeDrawer(android.support.v4.view.GravityCompat.START);
        return true;
    }

}
