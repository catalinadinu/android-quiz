package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ContProfesor extends Activity {


    private Button adQuiz;
    private Button progres;
    private Button feedbackk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cont_profesor);

        adQuiz = findViewById(R.id.adQuiz);
       progres = findViewById(R.id.veziProgres);
       feedbackk = findViewById(R.id.feedback);
    }



    public void adaugareTest(View view){
        adQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAd = new Intent(ContProfesor.this, AdaugareTest.class);
                startActivityForResult(intentAd, 5);
            }
        });
    }

    public void VeziProgres(View view){
        progres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentProgres = new Intent(ContProfesor.this, Progres.class);
                startActivityForResult(intentProgres, 5);
            }
        });
    }

    public void FormFeedback(View view){
        feedbackk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFeedback = new Intent(ContProfesor.this, FormularFeedback.class);
                startActivityForResult(intentFeedback, 5);
            }
        });
    }
}
