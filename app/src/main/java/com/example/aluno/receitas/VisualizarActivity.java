package com.example.aluno.receitas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.orm.SugarRecord;

public class VisualizarActivity extends AppCompatActivity {

    Button btnEdit;
    Button btnVoltar;
    Button btnExcluir;
    TextView textNome;
    TextView textIngr;
    TextView textPrep;
    Button btnAlterar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);


        int idReceita = getIntent().getExtras().getInt("idEnvio");

        final Receita rcp = Receita.findById(Receita.class,idReceita);
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
                SugarRecord.delete(rcp);
                Toast.makeText(VisualizarActivity.this, "Excluido", Toast.LENGTH_SHORT).show();
                launchLista();
            }
        });
        btnAlterar = (Button) findViewById(R.id.btnEdit);
        btnAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchAlterar(rcp.getId());
            }
        });











    }

    private void launchLista(){
        Intent intent = new Intent(this, ListaActivity.class);
        startActivity(intent);
    }
    private void launchAlterar(Long id){



        Intent intent = new Intent(this, AlterarReceitasActivity.class);
        intent.putExtra("idEnvio",id);
        startActivity(intent);
    }
}
