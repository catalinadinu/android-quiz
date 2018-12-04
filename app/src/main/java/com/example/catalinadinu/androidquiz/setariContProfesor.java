package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class setariContProfesor extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setari_cont_profesor);
    }

    public void deconectareProfesor(View view){
        Intent intentDeconectareProfesor = new Intent(setariContProfesor.this, MainActivity.class);
        startActivityForResult(intentDeconectareProfesor, 18);
    }
}
