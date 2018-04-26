package com.pehls.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.pehls.myapplication.utils.loginUtils;

public class newLogin extends AppCompatActivity {
    loginUtils login = new loginUtils();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button logar_btn = (Button) findViewById(R.id.confirmar_new_login_btn);
        logar_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView user_txt = (TextView) findViewById(R.id.new_email_txt);
                TextView senha_txt = (TextView) findViewById(R.id.newpass_txt);
                String user = user_txt.getText().toString();
                String senha = senha_txt.getText().toString();
                if (!login.novo(user, senha)) {
                    Toast.makeText(getApplicationContext(), "Usuario já existe!", Toast.LENGTH_LONG).show();
                } else {
                    Intent abreAtividadeMain = new Intent(newLogin.this, Main_Activity.class);
                    Bundle params = new Bundle();
                    params.putString("nome", user);
                    abreAtividadeMain.putExtras(params);
                    startActivity(abreAtividadeMain);
                }
            }
        });



    }

}
