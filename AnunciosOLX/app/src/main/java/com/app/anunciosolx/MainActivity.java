package com.app.anunciosolx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.app.anunciosolx.adapter.ListaAnunciosAdapter;
import com.app.anunciosolx.model.Anuncio;

import java.util.List;

import io.objectbox.Box;

public class MainActivity extends AppCompatActivity {
    Box<Anuncio> anuncioBox;
    RecyclerView recyclerAnuncios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anuncioBox = ((App)getApplication()).getBoxStore().boxFor(Anuncio.class);
        recyclerAnuncios = findViewById(R.id.rv_lista_anuncios);
    }

    @Override
    protected void onResume() {
        super.onResume();

        List<Anuncio> anuncios = anuncioBox.getAll();
        ListaAnunciosAdapter adapter = new ListaAnunciosAdapter(this, anuncios, anuncioBox);

        recyclerAnuncios.setAdapter(adapter);
        recyclerAnuncios.setLayoutManager(new LinearLayoutManager(this));
        recyclerAnuncios.hasFixedSize();
    }


    public void abrirCadastro(View view) {
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
    }
}
