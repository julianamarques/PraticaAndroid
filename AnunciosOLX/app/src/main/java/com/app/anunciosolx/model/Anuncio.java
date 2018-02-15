package com.app.anunciosolx.model;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by Juliana on 12/02/2018.
 */

@Entity
public class Anuncio {
    @Id
    private long id;
    private String descricao;
    private Double valor;
    private String local;
    private String data;

    public Anuncio() {}

    public Anuncio(String descricao, Double valor, String local, String data) {
        this.descricao = descricao;
        this.valor = valor;
        this.local = local;
        this.data = data;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getValor() {
        return valor;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getLocal() {
        return local;
    }

    public void setData() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        this.data = simpleDateFormat.format(new Date());
    }

    public String getData() {
        return data;
    }
}
