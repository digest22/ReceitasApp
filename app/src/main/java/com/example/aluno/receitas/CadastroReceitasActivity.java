package com.example.aluno.receitas;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CadastroReceitasActivity extends Activity {

    Button btnCancel;
    Button btnSalvar;

ImageButton imgBtnFoto;

    EditText editTextNome;
    EditText editTextIngredientes;
    EditText editTextModoPreparo;



    String receita;
String currentPhotoPath;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_receitas);
        editTextNome= (EditText) findViewById(R.id.editTextNome);
        receita = editTextNome.getText()+".recipe";


        btnCancel = (Button) findViewById(R.id.btnCancel);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                launchCancela();
            }
        });

        btnSalvar = (Button) findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                launchSalvar();
            }
        });

        imgBtnFoto = (ImageButton) findViewById(R.id.imgBtnFoto);

        imgBtnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaCamera();
            }
        });




    }


//    private static final int TIRAR_FOTO = 1020394857;
    @SuppressLint("SimpleDateFormat")
    public void chamaCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        File foto = null;
        try {
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String nomeImagem = "TESTE"+timeStamp+"_";
            File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            foto = File.createTempFile(nomeImagem,".jpg",storageDir);
            currentPhotoPath = foto.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (foto != null){
//            Uri fotoUri = FileProvider.getUriForFile(this,"com.example.android.fileprovider",foto);
//            intent.putExtra(MediaStore.EXTRA_OUTPUT,fotoUri);
            startActivityForResult(intent, 123);
        }




    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 123) {
            if(resultCode == Activity.RESULT_OK) {




//                        Colocar a thumb da foto no botão
                        Bundle extras = data.getExtras();
                        Bitmap imageBitmap = (Bitmap) extras.get("data");
                        imgBtnFoto.setImageBitmap(imageBitmap);

//                        Salvar a foto




            } else {
                Toast.makeText(this, "Não foi possível encontrar a foto.", Toast.LENGTH_SHORT).show();
            }
        }
    }












    private void launchCancela(){


         editTextNome = (EditText) findViewById(R.id.editTextNome);
         editTextIngredientes = (EditText) findViewById(R.id.editTextIngredientes);
         editTextModoPreparo = (EditText) findViewById(R.id.editTextModoPreparo);
         editTextNome.setText("");
         editTextIngredientes.setText("");
         editTextModoPreparo.setText("");


        Intent intent = new Intent(this, ListaActivity.class);
        startActivity(intent);


    }
    private void launchSalvar(){

/*
*   SALVAR RECEITA
*
*
* */
        Intent intent = new Intent(this, ListaActivity.class);
        startActivity(intent);
    }



}
