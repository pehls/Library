package com.pehls.myapplication;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.pehls.myapplication.utils.loginUtils;

public class login_activity extends AppCompatActivity {
    loginUtils login = new loginUtils();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView forget_txt = (TextView) findViewById(R.id.esqueceu_txt);
        forget_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreRecuperarSenha = new Intent(login_activity.this, EsqueceuSenhaActivity.class);
                startActivity(abreRecuperarSenha);
            }
        });
        findViewById(R.id.login_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView user_txt = (TextView) findViewById(R.id.new_email_txt);
                final String user = user_txt.getText().toString();
                TextView pass_txt = (TextView) findViewById(R.id.pass_txt);
                final String password = pass_txt.getText().toString();
                if (login.confere(user, password)) {
                    Intent abreAtividadeMain = new Intent(login_activity.this, Main_Activity.class);
                    Bundle params = new Bundle();
                    params.putString("nome", user);
                    abreAtividadeMain.putExtras(params);
                    startActivity(abreAtividadeMain);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Senha está errada! ", Toast.LENGTH_LONG).show();
                }


            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abreAtividadeNewBook = new Intent(login_activity.this, newLogin.class);
                startActivity(abreAtividadeNewBook);
            }
        });
        Log.v("Activity","onCreate");

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
