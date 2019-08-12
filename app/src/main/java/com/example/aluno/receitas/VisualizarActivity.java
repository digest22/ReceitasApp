package com.example.aluno.receitas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VisualizarActivity extends AppCompatActivity {


    Button btnVoltar;
    Button btnExcluir;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);

        btnVoltar = (Button) findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                launchLista();
            }
        });

        btnExcluir = (Button) findViewById(R.id.btnExcluir);

        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                launchExcluir();
            }
        });





    }

    private void launchLista(){
        Intent intent = new Intent(this, ListaActivity.class);
        startActivity(intent);
    }

    private void launchExcluir(){
        /* CÓDIGO PARA EXCLUIR*/
        Intent intent = new Intent(this, ListaActivity.class);
        startActivity(intent);
    }
}
