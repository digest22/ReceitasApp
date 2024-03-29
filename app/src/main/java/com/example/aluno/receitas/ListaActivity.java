package com.example.aluno.receitas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ListaActivity extends AppCompatActivity {

    Button btnVoltar;
    Button btnAdicionar;
    ListView listItens;
    Button btnReset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        listItens = (ListView) findViewById(R.id.listItens);


//        List<Receita> listaReceitas = Receita.listAll(Receita.class);
//        String[] dados = new String[listaReceitas.size()+1];
//        int i = 1;
//        String teste = "";
//        for (Receita r: listaReceitas) {
//            dados[i] = r.getNome();
//            i++;
//            Toast.makeText(this, r.getNome()+i, Toast.LENGTH_SHORT).show();
//        }



        String[] PENS = new String[]{
                "MONT Blanc",
                "Gucci",
                "Parker",
                "Sailor",
                "Porsche Design",
                "Rotring",
                "Sheaffer",
                "Waterman"
        };
        listItens.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, PENS));




//        String[] dados = new String[listaReceitas.size()];
//        int i = 1;

//        App parou de funfionar; se comenta o for ele funciona. le items do bank pelo id normalmente; talvez erro ao ler a lista?
//        for (Receita r: listaReceitas){
//            dados[i] = r.getNome();
//            i++;
//        }

////
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dados);
//        listItens.setAdapter(adapter);
/* // */


    btnVoltar = (Button) findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                launchInicio();
            }
        });




        btnReset = (Button) findViewById(R.id.btnReset);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                launchVisualizar();
            }
        });






        btnAdicionar = (Button) findViewById(R.id.btnAdicionar);





        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchAdicionar();
            }
        });



    }

    private void launchAdicionar(){
        Intent intent = new Intent(this, CadastroReceitasActivity.class);
        startActivity(intent);
    }
    private void launchInicio(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void launchVisualizar(){
        Intent intent = new Intent(this, VisualizarActivity.class);
        intent.putExtra("idEnvio", 2);
        startActivity(intent);
    }

}
