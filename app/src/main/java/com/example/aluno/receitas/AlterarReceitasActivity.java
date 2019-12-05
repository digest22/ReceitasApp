package com.example.aluno.receitas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.orm.SugarRecord;

public class AlterarReceitasActivity extends AppCompatActivity {



    Button btnSalvar;
    EditText editTextNome;
    EditText editTextIngredientes;
    EditText editTextModoPreparo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_receitas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final int idReceita = getIntent().getExtras().getInt("idEnvio");


        editTextNome= (EditText) findViewById(R.id.editTextNome);
        editTextIngredientes = (EditText) findViewById(R.id.editTextIngr);
        editTextModoPreparo = (EditText) findViewById(R.id.editTextPrep);




        final Receita rcp = SugarRecord.findById(Receita.class,2);

        editTextNome.setText(rcp.getNome());
        editTextIngredientes.setText(rcp.getIngredientes());
        editTextIngredientes.setText(rcp.getModoPreparo());



        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                String ingr = editTextIngredientes.getText().toString();
                String modo = editTextModoPreparo.getText().toString();



                rcp.setNome(nome);
                rcp.setIngredientes(ingr);
                rcp.setModoPreparo(modo);
                SugarRecord.save( rcp );
launchVisualizar();

            }
        });









    }
    private void launchVisualizar(){
        Intent intent = new Intent(this, VisualizarActivity.class);
        intent.putExtra("idEnvio", 2);
        startActivity(intent);
    }

}
