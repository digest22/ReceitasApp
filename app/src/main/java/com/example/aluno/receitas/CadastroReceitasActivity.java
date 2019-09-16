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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.orm.SchemaGenerator;
import com.orm.SugarContext;
import com.orm.SugarDb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

    Bitmap pBitmap;

    String currentPhotoPath;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_receitas);

//        SugarContext.init(getApplicationContext());
//        SchemaGenerator schemaGenerator = new SchemaGenerator(this);
//        schemaGenerator.createDatabase(new SugarDb(this).getDB());



        editTextNome= (EditText) findViewById(R.id.editTextNome);
        editTextIngredientes = (EditText) findViewById(R.id.editTextIngredientes);
        editTextModoPreparo = (EditText) findViewById(R.id.editTextModoPreparo);


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
                String nome = editTextNome.getText().toString();
                String ingr = editTextIngredientes.getText().toString();
                String modo = editTextModoPreparo.getText().toString();

                Receita receita = new Receita();
                receita.setNome(nome);
                receita.setIngredientes(ingr);
                receita.setModoPreparo(modo);

                receita.save();

                editTextNome.setText("");
                editTextIngredientes.setText("");
                editTextModoPreparo.setText("");



                //                launchSalvar();
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

//        File foto = null;
//        try {
//            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//            String nomeImagem = "Apresentação"+timeStamp+"_";
//            File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
//            Toast.makeText(this, storageDir.getAbsolutePath(), Toast.LENGTH_LONG).show();
//
//            editTextIngredientes= (EditText) findViewById(R.id.editTextIngredientes);
//
//            editTextIngredientes.setText(getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath());
//            foto = File.createTempFile(nomeImagem,".jpg",storageDir);
//            currentPhotoPath = foto.getAbsolutePath();
//        } catch (IOException e) {
//            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
//        }
//        if (foto != null){
//          Uri fotoUri = FileProvider.getUriForFile(this,"com.example.android.fileprovider",foto);
//          intent.putExtra(MediaStore.EXTRA_OUTPUT,fotoUri);
        startActivityForResult(intent, 123);
//        }
    }


    public void saveBitmap(Bitmap pBitmap){

        try{

            File file = new File(Environment.getExternalStorageDirectory() + "/Livro_de_Receitas/Imagens");
            file.mkdir();
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String nomeImagem = "Apresentação"+timeStamp+"_";

            File ifile= new File(Environment.getExternalStorageDirectory() + "/Livro_de_Receitas/Imagens/", nomeImagem+".png");
            Toast.makeText(this, ifile.getAbsolutePath(), Toast.LENGTH_LONG).show();

            FileOutputStream outStream = new FileOutputStream(ifile);
            pBitmap.compress(Bitmap.CompressFormat.PNG, 100, outStream);
            outStream.close();

        }
        catch(Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            Log.e("Could not save", e.toString());
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

                saveBitmap(imageBitmap);

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

//
//        try{
//
//            File file = new File(Environment.getExternalStorageDirectory() + "/Livro_de_Receitas/Receitas");
//            file.mkdir();
//
//
//            editTextNome= (EditText) findViewById(R.id.editTextNome);
//
//            String nomeArquivo = "Apresentação_" + editTextNome.getText();
//
//            File ifile= new File(Environment.getExternalStorageDirectory() + "/Livro_de_Receitas/Receitas/", nomeArquivo+".rec");
//            Toast.makeText(this, ifile.getAbsolutePath(), Toast.LENGTH_LONG).show();
//
//            FileOutputStream outStream = new FileOutputStream(ifile);
//            pBitmap.compress(Bitmap.CompressFormat.PNG, 100, outStream);
//            outStream.close();
//
//        }
//        catch(Exception e){
//            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
//            Log.e("Could not save", e.toString());
//        }
//
//
//
//
//
//






        Intent intent = new Intent(this, ListaActivity.class);
        startActivity(intent);
    }



}
