package com.example.catalinadinu.androidquiz;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    //1 - inregistrare profesor
    //2 - inregistrare student
    //3 - conectrare profesor>
    //4 - conectare student
    //5 - cont profesor
    //6 - cont student
    //7 - adaugare teste
    //8 - test student
    //9 - vizualizare test
    //10 - feedback prof
    //11 - progres
    //12 - final test
    //13 - feedback aplicatie
    //14 - contact
    //15 - informatii aplicatie
    //16 - partajare catre
    //17- popupfeedback
    //18 - setari cont profesor
    //19 - setari cont student

    private Button inregistrare;
    private Button conectare;
    private RadioGroup radioGroupTip;
    private RadioButton profilProfesor;
    private RadioButton profilStudent;
    private ImageButton info;
    private ImageButton rateAplicatie;
    private ImageButton contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inregistrare = findViewById(R.id.id_inregistrare);
        conectare = findViewById(R.id.id_conectare);
        radioGroupTip = findViewById(R.id.radioGroupTip);
        profilProfesor = findViewById(R.id.id_profilProf);
        profilStudent = findViewById(R.id.id_profilStud);
        info = findViewById(R.id.id_butonInfo);
        rateAplicatie = findViewById(R.id.id_butonRate);
        contact = findViewById(R.id.id_butonContact);
        info = findViewById(R.id.id_butonInfo);

        inregistrare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioGroupTip.getCheckedRadioButtonId()==-1){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Eroare");
                    builder.setMessage("Selectarea unui profil este obligatorie!");
                    builder.setPositiveButton("OK", null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                else if(profilProfesor.isChecked()) { //profesor
                    Intent intentInregristrare = new Intent(MainActivity.this, InregistrareProfilProfesor.class);
                    startActivityForResult(intentInregristrare, 1);
                }
                else{
                        Intent intentInregristrare = new Intent(MainActivity.this, InregistrareProfilStudent.class);
                        startActivityForResult(intentInregristrare, 2);
                    }
                }
        });

        conectare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioGroupTip.getCheckedRadioButtonId()==-1){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Eroare");
                    builder.setMessage("Selectarea unui profil este obligatorie!");
                    builder.setPositiveButton("OK", null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                else if(profilProfesor.isChecked()) { //profesor
                    Intent intentConectare = new Intent(MainActivity.this, ConectareProfesor.class);
                    startActivityForResult(intentConectare, 3);
                }
                else{
                    Intent intentConectare = new Intent(MainActivity.this, ConectareStudent.class);
                    startActivityForResult(intentConectare, 4);
                }

            }
        });


    }

    public void onRadioButtonClicked(View view)
    {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId())
        {
            case(R.id.id_profilProf):
                if(checked)
                    break;
            case(R.id.id_profilStud):
                if(checked)
                    break;
        }
    }

    public void feedbackAplicatie(View view)
    {
        Intent intent = new Intent(MainActivity.this, FeedbackAplicatie.class);
        startActivityForResult(intent, 13);
    }

    public void informatii(View view)
    {
        Intent intentInfo = new Intent(MainActivity.this, Info.class);
        startActivityForResult(intentInfo, 15);

    }

    public void contact(View view)
    {
        Intent intentContact = new Intent(MainActivity.this, Contact.class);
        startActivityForResult(intentContact,14);
    }
}
