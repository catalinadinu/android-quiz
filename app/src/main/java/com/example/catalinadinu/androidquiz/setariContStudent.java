package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class setariContStudent extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setari_cont_student);
    }

    public void deconectare(View view){
        Intent intentDeconectare = new Intent(setariContStudent.this, MainActivity.class);
        startActivityForResult(intentDeconectare, 0);
    }

    public void schimbaParola(View view){
        Toast.makeText(setariContStudent.this,"Parola a fost modificată cu succes.", Toast.LENGTH_LONG).show();
    }
}

