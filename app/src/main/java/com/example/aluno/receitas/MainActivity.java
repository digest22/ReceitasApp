package com.example.aluno.receitas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

ImageButton imgBtnCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgBtnCadastro = (ImageButton) findViewById(R.id.imgBtnCadastro);

        imgBtnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchCadastro();



            }
        });




    }
    private void launchCadastro(){
        Intent intent = new Intent(this, CadastroReceitasActivity.class);
        startActivity(intent);
    }
}
