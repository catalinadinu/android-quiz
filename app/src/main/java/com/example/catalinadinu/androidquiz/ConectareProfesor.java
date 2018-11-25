package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConectareProfesor extends Activity {

    private Button conectareProf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conectare_profesor);

        conectareProf = findViewById(R.id.id_butonConectare);
    }

    public void conectareProfesor(View view){
        conectareProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentConectareProf = new Intent(ConectareProfesor.this, ContProfesor.class);
                startActivityForResult(intentConectareProf, 5);
            }
        });
    }
}
