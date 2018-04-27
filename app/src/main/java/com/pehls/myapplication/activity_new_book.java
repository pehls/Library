package com.pehls.myapplication;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.pehls.myapplication.utils.BookUtils;

import org.w3c.dom.Text;

public class activity_new_book extends AppCompatActivity {
    private BookUtils bookUtils = new BookUtils();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_book);
        Bundle args = getIntent().getExtras();
        //final String nome = args.getString("nome");
        //((TextView) findViewById(R.id.title_name_txt)).setText(nome);
        ((Button) findViewById(R.id.salvar_book_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bookname = ((TextView) findViewById(R.id.bookname_txt)).getText().toString();
                String autor = ((TextView) findViewById(R.id.autor_txt)).getText().toString();
                if (!bookUtils.novo(bookname,autor)) {
                    Toast.makeText(getApplicationContext(), "Livro já existe!", Toast.LENGTH_LONG).show();
                } else {
                    Intent abreAtividadeLista = new Intent(activity_new_book.this, bookListActivity.class);
                    Bundle params = new Bundle();
                    //params.putString("nome", nome);
                    abreAtividadeLista.putExtras(params);
                    startActivity(abreAtividadeLista);
                    finish();
                }
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
