package com.example.aluno.receitas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

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

        List<Receita> listaReceitas = Receita.listAll(Receita.class);

//        String[] dados = new String[] { "Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread",
//                "Honeycomb", "Ice Cream Sandwich", "Jelly Bean",
//                "KitKat", "Lollipop", "Marshmallow", "Nougat" };


        String [] dados = new String[];
        int i=1;
        for (Receita dado : listaReceitas) {
            dados[i] = dado.getNome();
            i++;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dados);
        listItens.setAdapter(adapter);



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
        startActivity(intent);
    }

}
