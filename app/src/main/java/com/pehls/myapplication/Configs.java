package com.pehls.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class Configs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configs);
        Log.v("Activity","onCreate");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "Salvando configurações", Toast.LENGTH_LONG).show();
        Log.v("Activity","onPause");

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
