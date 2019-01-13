package com.example.catalinadinu.androidquiz;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.catalinadinu.androidquiz.clase.Test;
import com.example.catalinadinu.androidquiz.clase.TesteAdaptorPersonalizat;

import java.util.ArrayList;
import java.util.Arrays;
import android.view.Menu;
import android.widget.Toast;

import static android.app.ActionBar.*;

public class ContProfesor extends AppCompatActivity {

    ImageView imagine;
    Integer REQUEST_CAMERA = 1;
    Integer SELECT_FILE = 0;
    FloatingActionButton poza;

    private TextView numeUtilizator;
    private TextView codProfesor;
    private Button adQuiz;
    private Button progres;
    private Button feedbackk;
    private ListView listaQuiz;
    private TextView hintIntroducereCod;
    private ImageButton setariContProfesor;

    String prenumeProf;
    String codproff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cont_profesor);

        numeUtilizator = findViewById(R.id.textViewNumeContPersonal);
        codProfesor = findViewById(R.id.textViewCodCont);
        adQuiz = findViewById(R.id.adQuiz);
        progres = findViewById(R.id.veziProgres);
        feedbackk = findViewById(R.id.feedback);
        listaQuiz = findViewById(R.id.listaQuizProf);
        hintIntroducereCod = findViewById(R.id.hintIntroducereCod);
        setariContProfesor = findViewById(R.id.setariContProfesor);

        //transfer
        if(getIntent().hasExtra("COD")){
            codproff = getIntent().getExtras().getString("COD");
            codProfesor.setText(codproff);
        }
        else if (getIntent().hasExtra("PRENUME")){
            prenumeProf = getIntent().getExtras().getString("PRENUME");
            numeUtilizator.setText(prenumeProf );
        }

        //intent inregistrare
        if(getIntent().hasExtra("inregistrare"))
        {
            setariContProfesor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentAd = new Intent(ContProfesor.this, setariContProfesor.class);
                    startActivityForResult(intentAd, 18);
                }
            });
        }
        else {
            setariContProfesor.setVisibility(View.GONE);
        }


        //transfer
        if(getIntent().hasExtra("COD")){
            codproff = getIntent().getExtras().getString("COD");
            codProfesor.setText(codproff);
        }
        else if (getIntent().hasExtra("PRENUME")){
            prenumeProf = getIntent().getExtras().getString("PRENUME");
            numeUtilizator.setText(prenumeProf );
        }


        //listview - adaptor personalizat
        Test[] testeStudent = new Test[]{
                new Test("Test PAW", "5"),
                new Test("Test SDD", "5"),
                new Test("Test JAVA", "5"),
                new Test("Test MULTIMEDIA", "5"),
                new Test("Test DAM", "5"),
                new Test("Test POO", "5"),
                new Test("Test MULTIMEDIA", "5"),
                new Test("Test TEHNOLOGII WEB", "5")
        };

        ArrayList<Test> listaTeste = new ArrayList<>();
        listaTeste.addAll(Arrays.asList(testeStudent));

        TesteAdaptorPersonalizat adaptorPersonalizat = new TesteAdaptorPersonalizat(this,android.R.layout.simple_list_item_1 ,listaTeste);
        listaQuiz.setAdapter(adaptorPersonalizat);


        //item selectat din listview
        listaQuiz.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ContProfesor.this, VizualizareTest.class);
                startActivityForResult(intent, 9);
            }
        });


        //stops the keyboard popup until you press the textview
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        imagine = (ImageView) findViewById(R.id.avatar);
        poza = (FloatingActionButton) findViewById(R.id.poza);
        poza.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                selectImage();
            }
        });



    }

    private void selectImage(){
        final CharSequence[] items = {"CAMERA", "GALERY", "CANCEL"};
        AlertDialog.Builder builder = new AlertDialog.Builder(ContProfesor.this);
        builder.setTitle("Adauga un avatar");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                 if(items[i].equals("CAMERA")){
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, REQUEST_CAMERA);
                 }
                 else if(items[i].equals("GALERY")){
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    startActivityForResult(intent.createChooser(intent, "SELECT FILE"),SELECT_FILE);

                 }
                 else if(items[i].equals("CANCEL")){
                     dialog.dismiss();
                 }
            }
        });

        builder.show();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == Activity.RESULT_OK)
        {
            if(requestCode == REQUEST_CAMERA){

                Bundle bundle = data.getExtras();
                final Bitmap bmp = (Bitmap) bundle.get("data");
                imagine.setImageBitmap(bmp);

            }else if(requestCode == SELECT_FILE){
                Uri selectedImageUri = data.getData();
                imagine.setImageURI(selectedImageUri);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.schimbaParola)
        {
            Intent intentSchimbareParola = new Intent(ContProfesor.this, setariContProfesor.class);
            startActivityForResult(intentSchimbareParola, 18);
        }
        else if(item.getItemId() == R.id.deconectare){
            Intent intentDeconectare = new Intent(ContProfesor.this, MainActivity.class);
            startActivityForResult(intentDeconectare, 0);
        }
        else{
            return super.onOptionsItemSelected(item);
        }
        return true;
    }


    public void adaugareTest(View view){
        Intent intentAd = new Intent(ContProfesor.this, AdaugareTest.class);
        startActivityForResult(intentAd, 7);
    }

    public void VeziProgres(View view){
        if(hintIntroducereCod!=null){
            if("".equals(hintIntroducereCod.getText().toString())){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Eroare");
                builder.setMessage("Introduceți codul studentului!");
                builder.setPositiveButton("OK", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            else{
                Intent intentProgres = new Intent(ContProfesor.this, Progres.class);
                startActivityForResult(intentProgres, 11);
            }

        }

    }

    public void FormFeedback(View view){
        Intent intentFeedback = new Intent(ContProfesor.this, FormularFeedback.class);
        startActivityForResult(intentFeedback, 10);
    }

}
