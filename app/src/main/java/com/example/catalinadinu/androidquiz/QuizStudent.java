package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.catalinadinu.androidquiz.clase.Intrebari;

public class QuizStudent extends Activity {


    private Intrebari listaIntrebari = new Intrebari();
    private String raspunsCorect;
    private int scorul =0;
    private int c =0;
    private int lungimeIntrebare = listaIntrebari.listaIntrebari.length;
    private int r=0;


    Button raspuns1;
    Button raspuns2;
    Button raspuns3;
    Button raspuns4;
    TextView scorTest;
    TextView intrebare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_student);

        raspuns1 = findViewById(R.id.rasp1);
        raspuns2 = findViewById(R.id.rasp2);
        raspuns3 = findViewById(R.id.rasp3);
        raspuns4 = findViewById(R.id.rasp4);

        intrebare = findViewById(R.id.intrebare);
        scorTest = findViewById(R.id.scor);

        scorTest.setText("Scor: " + scorul);
        incarcaIntrebare(r);


        raspuns1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(raspuns1.getText() == raspunsCorect) {
                    scorul++;
                    scorTest.setText("Scor: " + scorul);
                    if(r == lungimeIntrebare-1){
                        finQuiz();
                    }
                    else
                    {
                        r++;
                        incarcaIntrebare(r);
                    }
                }
                else
                {
                    fin();
                }
            }
        });

        raspuns2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(raspuns2.getText() == raspunsCorect) {
                    scorul++;
                    scorTest.setText("Scor: " + scorul);
                    if(r == lungimeIntrebare-1){
                        finQuiz();
                    }
                    else
                    {
                        r++;
                        incarcaIntrebare(r);
                    }
                }
                else
                {
                    fin();
                }
            }
        });
        raspuns3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(raspuns3.getText() == raspunsCorect) {
                    scorul++;
                    scorTest.setText("Scor: " + scorul);
                    if(r == lungimeIntrebare-1){
                        finQuiz();
                    }
                    else
                    {
                        r++;
                        incarcaIntrebare(r);
                    }
                }
                else
                {
                    fin();
                }
            }
        });
        raspuns4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(raspuns4.getText() == raspunsCorect) {
                    scorul++;
                    scorTest.setText("Scor: " + scorul);
                    if(r == lungimeIntrebare-1){
                        finQuiz();
                    }
                    else
                    {
                        r++;
                        incarcaIntrebare(r);
                    }
                }
                else
                {
                    fin();
                }
            }
        });
    }

    private void incarcaIntrebare(int numar)
    {
        intrebare.setText(listaIntrebari.obtineIntrebare(numar));
        raspuns1.setText(listaIntrebari.obtineGrila1(numar));
        raspuns2.setText(listaIntrebari.obtineGrila2(numar));
        raspuns3.setText(listaIntrebari.obtineGrila3(numar));
        raspuns4.setText(listaIntrebari.obtineGrila4(numar));

        raspunsCorect = listaIntrebari.obtineRaspCorect(numar);

    }

    private void fin()
    {
        AlertDialog.Builder quizTerminat = new AlertDialog.Builder(QuizStudent.this);
        quizTerminat
                .setMessage("Ati obtinut un scor de " + scorul + " puncte! Continuati sa exersati.")
                .setCancelable(false)
                .setPositiveButton(getString(R.string.maiIncearca),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(), QuizStudent.class));
                            }
                        })
                .setNegativeButton(getString(R.string.iesire),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(), ContStudent.class));
                            }
                        });


        AlertDialog alertDialog = quizTerminat.create();
        alertDialog.show();
    }
    private void finQuiz()
    {
        AlertDialog.Builder quizTerminat = new AlertDialog.Builder(QuizStudent.this);
        quizTerminat
                .setMessage("Ati obtinut un scor maxim de " + scorul+ " puncte! Felicitari!")
                .setCancelable(false)
                .setPositiveButton(getString(R.string.reIncearca),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(), QuizStudent.class));
                            }
                        })
                .setNegativeButton(getString(R.string.iesire),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(), ContStudent.class));
                            }
                        });
        AlertDialog alertDialog = quizTerminat.create();
        alertDialog.show();
    }

}