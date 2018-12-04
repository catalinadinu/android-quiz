package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class setariContStudent extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setari_cont_student);
    }

    public void deconectareStudent(View view){
        Intent intentDeconectareStudent = new Intent(setariContStudent.this, MainActivity.class);
        startActivityForResult(intentDeconectareStudent, 18);
    }
}
