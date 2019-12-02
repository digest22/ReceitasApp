package com.example.aluno.receitas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VisualizarActivity extends AppCompatActivity {


    Button btnVoltar;
    Button btnExcluir;
    TextView textNome;
    TextView textIngr;
    TextView textPrep;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);


        int idReceita = getIntent().getExtras().getInt("idEnvio");

        Receita rcp = Receita.findById(Receita.class,idReceita);
        textNome = (TextView) findViewById(R.id.textNome);
        textIngr = (TextView) findViewById(R.id.textIngredientes);
        textPrep = (TextView) findViewById(R.id.textPreparo);
        textNome.setText(rcp.getNome());
        textIngr.setText(rcp.getIngredientes());
        textPrep.setText(rcp.getModoPreparo());



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
                rcp.;
            }
        });











    }

    private void launchLista(){
        Intent intent = new Intent(this, ListaActivity.class);
        startActivity(intent);
    }

    private void launchExcluir(){





        Intent intent = new Intent(this, ListaActivity.class);
        startActivity(intent);
    }
}
