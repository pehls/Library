package com.pehls.myapplication;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        final String nome = args.getString("nome");
        TextView title = (TextView) findViewById(R.id.title_name_txt);
        title.setText(nome);
        Button salvar_btn = (Button) findViewById(R.id.salvar_book_btn);
        salvar_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView bookname_txt = (TextView) findViewById(R.id.bookname_txt);
                TextView autor_txt = (TextView) findViewById(R.id.autor_txt);
                String bookname = bookname_txt.getText().toString();
                String autor = autor_txt.getText().toString();
                if (!bookUtils.novo(bookname,autor)) {
                    Toast.makeText(getApplicationContext(), "Livro já existe!", Toast.LENGTH_LONG).show();
                } else {
                    Intent abreAtividadeLista = new Intent(activity_new_book.this, bookListActivity.class);
                    Bundle params = new Bundle();
                    params.putString("nome", nome);
                    abreAtividadeLista.putExtras(params);
                    startActivity(abreAtividadeLista);
                    finish();
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "Salvando imagem do item x", Toast.LENGTH_LONG).show();
    }
}
