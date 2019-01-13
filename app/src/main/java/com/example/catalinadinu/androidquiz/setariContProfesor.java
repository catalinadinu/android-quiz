package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class setariContProfesor extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setari_cont_profesor);
    }

    public void schimbaParola(View view){
        Toast.makeText(setariContProfesor.this,"Parola a fost modificată cu succes.", Toast.LENGTH_LONG).show();
    }

    public void deconectare(View view){
        Intent intentDeconectare = new Intent(setariContProfesor.this, MainActivity.class);
        startActivityForResult(intentDeconectare, 0);
    }
}
