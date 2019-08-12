package com.example.aluno.receitas;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
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

public class CadastroReceitasActivity extends AppCompatActivity {

    Button btnCancel;
    Button btnSalvar;

ImageButton imgBtnFoto;

    EditText editTextNome;
    EditText editTextIngredientes;
    EditText editTextModoPreparo;



    String receita;





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



/*
     PERMISSOES CAMERA
    private void getPermissions() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }
        else
            dispatchTakePictureIntent();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    dispatchTakePictureIntent();
                } else {
                    Toast.makeText(this, "Não vai funcionar!!!", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }
     PERMISSOES CAMERA FIM



    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile = null;
            try {
                File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                photoFile = File.createTempFile("PHOTOAPP", ".jpg", storageDir);
                mCurrentPhotoPath = "file:" + photoFile.getAbsolutePath();
            }
            catch(IOException ex){
                Toast.makeText(getApplicationContext(), "Erro ao tirar a foto", Toast.LENGTH_SHORT).show();
            }

            if (photoFile != null) {
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            try {
                ImageButton imgBtnFoto = (ImageButton)findViewById(R.id.imgBtnFoto);
                Bitmap bm1 = BitmapFactory.decodeStream(getContentResolver().openInputStream(Uri.parse(mCurrentPhotoPath)));
                imgBtnFoto.setImageBitmap(bm1);
            }catch(FileNotFoundException fnex){
                Toast.makeText(getApplicationContext(), "Foto não encontrada!", Toast.LENGTH_LONG).show();
            }
        }
    }*/

}
