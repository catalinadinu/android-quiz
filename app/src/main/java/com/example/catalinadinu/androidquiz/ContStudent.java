package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.catalinadinu.androidquiz.clase.Materie;
import com.example.catalinadinu.androidquiz.clase.StudentiAdaptorPersonalizat;
import com.example.catalinadinu.androidquiz.clase.Test;
import com.example.catalinadinu.androidquiz.clase.TesteAdaptorPersonalizat;
import com.example.catalinadinu.androidquiz.clase.UtilizatorStudent;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.view.Menu;

public class ContStudent extends Activity {

    private Spinner spinnerMaterie;
    private ProgressBar progressBar;
    private Button incepeTest;
    private TextView numeStud;
    private TextView codStud;
    private ListView listViewTesteStudent;
    private ImageButton setariContStudent;
    ImageView imagine;
    Integer REQUEST_CAMERA = 1;
    Integer SELECT_FILE = 0;
    FloatingActionButton poza;
    String prenumestudd;
    String codstudd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cont_student);

        numeStud = findViewById(R.id.textViewNumeContPersonalStud);
        codStud = findViewById(R.id.textViewCodContStud);
        incepeTest = findViewById(R.id.id_boutonQuizNouS);
        progressBar = findViewById(R.id.progressBar);
        spinnerMaterie = findViewById(R.id.id_spinnerMaterieS);
        listViewTesteStudent = findViewById(R.id.listViewTesteStudent);
        setariContStudent = findViewById(R.id.setariContStudent);


        //intent inregistrare
        if(getIntent().hasExtra("inregistrareStud"))
        {
            setariContStudent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentAd = new Intent(ContStudent.this, setariContStudent.class);
                    startActivityForResult(intentAd, 19);
                }
            });
        }
        else {
            setariContStudent.setVisibility(View.GONE);
        }

        //listview - adaptor personalizat
        Test[] testeStudent = new Test[]{
                new Test("Test POO", "5"),
                new Test("Test JAVA", "5"),
                new Test("Test DAM", "5"),
                new Test("Test TEHNOLOGII WEB", "5")
        };

        ArrayList<Test> listaTeste = new ArrayList<>();
        listaTeste.addAll(Arrays.asList(testeStudent));

        TesteAdaptorPersonalizat adaptorPersonalizat = new TesteAdaptorPersonalizat(this,android.R.layout.simple_list_item_1 ,listaTeste);
        listViewTesteStudent.setAdapter(adaptorPersonalizat);


        //item selectat din listview
        listViewTesteStudent.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        AdapterView.OnItemClickListener listClick = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ContStudent.this, TestStudent.class);
                startActivityForResult(intent, 8);
            }
        };

        listViewTesteStudent.setOnItemClickListener(listClick);



        //transfer
        if(getIntent().hasExtra("COD")){
            codstudd = getIntent().getExtras().getString("COD");
            codStud.setText(codstudd);
        }
        else if (getIntent().hasExtra("PRENUME")){
            prenumestudd = getIntent().getExtras().getString("PRENUME");
            numeStud.setText(prenumestudd );
        }

        List<String> materii = new ArrayList<>();
        materii.add("BTI");
        materii.add("POO");
        materii.add("JAVA");
        materii.add("PAW");
        materii.add("SDD");

        ArrayAdapter<String> adaptor = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, materii);
        spinnerMaterie.setAdapter(adaptor);

        //citesteJson();

        imagine = (ImageView) findViewById(R.id.profil);
        poza = (FloatingActionButton) findViewById(R.id.poza);
        poza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
            }
        });
    }


    private void selectImage(){
        final CharSequence[] items = {"CAMERA", "GALERY", "CANCEL"};
        AlertDialog.Builder builder = new AlertDialog.Builder(ContStudent.this);
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
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

    public void IncepeTest(View view)
    {
        incepeTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valoareSpinner = spinnerMaterie.getSelectedItem().toString();
                if(!("".equals(valoareSpinner))){
                    Intent intentIncepeTest = new Intent(ContStudent.this, QuizStudent.class);
                    startActivityForResult(intentIncepeTest, 22);}
            }
        });
    }

}
