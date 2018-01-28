package com.app.contador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int valorAtual;
    private EditText valorEntrada;
    private TextView txtDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valorEntrada = findViewById(R.id.valor_entrada);
        txtDisplay = findViewById(R.id.txt_display);

        setValorAtual(0);
    }
    
    public void incrementar(View view) {
        setValorAtual(this.valorAtual + getValorEntrada());
    }

    private int getValorEntrada() {
        String entrada = valorEntrada.getText().toString();
        int valor = 0;

        if(!entrada.trim().isEmpty()){
            valor = Integer.valueOf(entrada);
        }

        else {
            Toast.makeText(this, R.string.digite_um_numero, Toast.LENGTH_LONG).show();
        }

        return (valor >= 0 && valor <= 10) ? valor : 0;
    }

    public void decrementar(View view) {
        setValorAtual(this.valorAtual - getValorEntrada());
    }

    public void setValorAtual(int valor) {
        if(valor >= 0 && valor <= 100) {
            this.valorAtual = valor;
            txtDisplay.setText(String.valueOf(this.valorAtual));
        }
    }
}
