package com.app.anunciosolx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.app.anunciosolx.model.Anuncio;

import io.objectbox.Box;

public class CadastroActivity extends AppCompatActivity {
    private EditText campoDescricao;
    private EditText campoValor;
    private EditText campoLocal;
    private Box<Anuncio> anuncioBox;
    private Anuncio anuncio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        anuncioBox = ((App)getApplication()).getBoxStore().boxFor(Anuncio.class);
        anuncio = new Anuncio();
        Intent intent = getIntent();
        long id = intent.getLongExtra("idAnuncio", -1);
        campoDescricao = findViewById(R.id.campo_descricao);
        campoValor = findViewById(R.id.campo_valor);
        campoLocal = findViewById(R.id.campo_local);

        if(id != -1) {
            anuncio = anuncioBox.get(id);

            campoDescricao.setText(anuncio.getDescricao());
            campoValor.setText(anuncio.getValor().toString());
            campoLocal.setText(anuncio.getLocal());
        }
    }

    public void salvar(View view) {
        String descricao = campoDescricao.getText().toString();
        String valor = campoValor.getText().toString();
        String local = campoLocal.getText().toString();

        anuncio.setDescricao(descricao);
        anuncio.setValor(Double.valueOf(valor));
        anuncio.setLocal(local);
        anuncio.setData();

        anuncioBox.put(anuncio);

        finish();
    }
}
