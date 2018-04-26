package com.pehls.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.pehls.myapplication.dados.repository.UserRepository;

public class Main_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);
        Bundle args = getIntent().getExtras();
        final String nome = args.getString("nome");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //UserRepository.getUser(nome).getImage();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.setDrawerTitle(1,nome);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);
        TextView name_txt = (TextView) findViewById(R.id.namePerfil_txt);
        name_txt.setText("Olá, "+nome);

        final AdView adView = new AdView(this);
        adView.setAdUnitId("pub-5942801438808720");
        adView.setAdSize(AdSize.BANNER);
        final LinearLayout adLinLay = (LinearLayout) findViewById(R.id.adLayout);
        adLinLay.addView(adView);

        final AdRequest.Builder adReq = new AdRequest.Builder();
        final AdRequest adRequest = adReq.build();
        adView.loadAd(adRequest);
        Log.v("Activity","onCreate");
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
        getMenuInflater().inflate(R.menu.main_, menu);
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

        if (id == R.id.nav_login) {
            Intent abreAtividadeLogin = new Intent(this, login_activity.class);
            startActivity(abreAtividadeLogin);
        } else if (id == R.id.nav_gallery) {
            Intent abreAtividadeGallery = new Intent(this, bookListActivity.class);
            startActivity(abreAtividadeGallery);
        } else if (id == R.id.nav_social) {
            Intent abreAtividadeSocial = new Intent(this, activity_social.class);
            startActivity(abreAtividadeSocial);
        } else if (id == R.id.nav_manage) {
            Intent abreAtividadeConfig = new Intent(this, Configs.class);
            startActivity(abreAtividadeConfig);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;


    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.v("Activity","onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("Activity","onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("Activity","onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("Activity","onStop");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("Activity","onRestart");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("Activity","onDestroy");

    }
}
