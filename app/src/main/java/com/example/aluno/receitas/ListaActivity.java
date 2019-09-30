package com.example.aluno.receitas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class ListaActivity extends AppCompatActivity {

    Button btnVoltar;
    Button btnAdicionar;
    ListView listV;
    Button btnTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        listV = (ListView) findViewById(R.id.listView);






        btnVoltar = (Button) findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                launchInicio();
            }
        });




        btnTemp = (Button) findViewById(R.id.btnTemp);

        btnTemp.setOnClickListener(new View.OnClickListener() {
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
