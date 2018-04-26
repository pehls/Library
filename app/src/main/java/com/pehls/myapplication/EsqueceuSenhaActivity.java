package com.pehls.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EsqueceuSenhaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esqueceu_senha);
        Button send_btn = (Button) findViewById(R.id.send_forget_btn);
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView email = (TextView) findViewById(R.id.nome_forget_txt);
                Toast.makeText(getApplicationContext(), "Email enviado para " + email.getText().toString(), Toast.LENGTH_LONG).show();
                finish();
            }
        });

        Log.v("Activity","onCreate");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "Salvando imagem do item x", Toast.LENGTH_LONG).show();
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
