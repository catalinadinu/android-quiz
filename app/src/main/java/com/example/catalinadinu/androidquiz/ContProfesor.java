package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ContProfesor extends AppCompatActivity {

    private TextView numeUtilizator;
    private Button adQuiz;
    private Button progres;
    private Button feedbackk;
    private ListView listaQuiz;
    //String prenumeProf;
    //String numeProf;
    //asta e la plezneala sa vedem daca merge, inlocuim pe urma cu un ArrayList
    //String[] listaNumeQuiz = {"Quiz 1","Quiz 2","Quiz 3"}; //aici cred ca trebuie clasa facuta pt quiz

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cont_profesor);

        numeUtilizator = findViewById(R.id.textViewNumeContPersonal);
        adQuiz = findViewById(R.id.adQuiz);
        progres = findViewById(R.id.veziProgres);
        feedbackk = findViewById(R.id.feedback);
        listaQuiz = findViewById(R.id.listaQuizProf);

        //transfer
//        prenumeProf = getIntent().getExtras().getString("Prenume");
//        numeProf = getIntent().getExtras().getString("Nume");
//        numeUtilizator.setText(prenumeProf + " " + numeProf);

        listaQuiz.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ContProfesor.this, VizualizareTest.class);
                startActivityForResult(intent, 9);
            }
        });
    }



    public void adaugareTest(View view){
        Intent intentAd = new Intent(ContProfesor.this, AdaugareTest.class);
        startActivityForResult(intentAd, 7);
    }

    public void VeziProgres(View view){
        Intent intentProgres = new Intent(ContProfesor.this, Progres.class);
        startActivityForResult(intentProgres, 11);
    }

    public void FormFeedback(View view){
        Intent intentFeedback = new Intent(ContProfesor.this, FormularFeedback.class);
        startActivityForResult(intentFeedback, 10);
    }


}
