package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;

public class Progres extends Activity {

    private ImageButton inapoiContProfesor;
    private GridView progresStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progres);

        inapoiContProfesor = findViewById(R.id.inapoiContProf);
        progresStudent = findViewById(R.id.gridViewProgresStudent);
    }

    public void butonInapoiContProf(View view){
        Intent intentBack = new Intent(Progres.this, ContProfesor.class);
        startActivityForResult(intentBack, 5);
    }
}
