package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.catalinadinu.androidquiz.clase.Test;
import com.example.catalinadinu.androidquiz.clase.TesteAdaptorPersonalizat;

import java.util.ArrayList;
import java.util.Arrays;

public class Progres extends Activity {

    private ImageButton inapoiContProfesor;
    private ListView progresStudent;
    private TextView textViewCodStPreluat;
    String codStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progres);

        inapoiContProfesor = findViewById(R.id.inapoiContProf);
        progresStudent = findViewById(R.id.progresStudent);
        textViewCodStPreluat = findViewById(R.id.textViewCodStPreluat);

        //transfer
        //codStudent = getIntent().getExtras().getString("codStud");
        //textViewCodStPreluat.setText(codStudent);


        //listview
        Test[] testeStudent = new Test[]{
                new Test("Test SDD", "5"),
                new Test("Test JAVA", "5"),
                new Test("Test DAM", "5"),
                new Test("Test TEHNOLOGII WEB", "5")
        };

        ArrayList<Test> listaTesteProgres = new ArrayList<>();
        listaTesteProgres.addAll(Arrays.asList(testeStudent));

        TesteAdaptorPersonalizat adaptorPersonalizat = new TesteAdaptorPersonalizat(this,android.R.layout.simple_list_item_1 ,listaTesteProgres);
        progresStudent.setAdapter(adaptorPersonalizat);
    }

    public void butonInapoiContProf(View view){
        Intent intentBack = new Intent(Progres.this, ContProfesor.class);
        startActivityForResult(intentBack, 5);
    }
}
