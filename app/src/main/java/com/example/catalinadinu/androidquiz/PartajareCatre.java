package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.catalinadinu.androidquiz.clase.TesteAdaptorPersonalizat;
import com.example.catalinadinu.androidquiz.clase.UtilizatorProfesor;
import com.example.catalinadinu.androidquiz.clase.UtilizatorStudent;

import java.util.ArrayList;
import java.util.Arrays;

public class PartajareCatre extends Activity {
    private ListView listaProfi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partajare_catre);

        listaProfi = findViewById(R.id.LVpartajareCatre);

        UtilizatorProfesor[] profesor = new UtilizatorProfesor[]{
                new UtilizatorProfesor("Dumitrascu", "Cristina"),
                new UtilizatorProfesor("Sandoiu", "Stefan"),
                new UtilizatorProfesor("Matei", "Roxana"),
                new UtilizatorProfesor("Cristescu", "Daniel"),
                new UtilizatorProfesor("Nedelea", "Alexandru")
        };

        ArrayList<UtilizatorProfesor> listaProfesori = new ArrayList<>();
        listaProfesori.addAll(Arrays.asList(profesor));
        ArrayAdapter<UtilizatorProfesor> adaptorProfesori = new ArrayAdapter<UtilizatorProfesor>(this, android.R.layout.simple_list_item_1,listaProfesori);
        listaProfi.setAdapter(adaptorProfesori);

        listaProfi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(PartajareCatre.this, ContProfesor.class);
                startActivityForResult(intent, 5);
                Toast.makeText(PartajareCatre.this, "Testul a fost trimis cu succes!", Toast.LENGTH_SHORT);
            }
        });
    }
}
