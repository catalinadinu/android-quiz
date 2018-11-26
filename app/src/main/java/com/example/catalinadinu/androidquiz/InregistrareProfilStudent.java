package com.example.catalinadinu.androidquiz;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import com.example.catalinadinu.androidquiz.clase.UtilizatorStudent;

public class InregistrareProfilStudent extends AppCompatActivity {

    private EditText nume;
    private EditText prenume;
    private EditText email;
    private EditText parola;
    private EditText confirmaParola;
    //private RadioGroup radioGroupTip;
    private Button creeazaCont;
    private UtilizatorStudent utilStud;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inregistrare_profil_student);

        nume = findViewById(R.id.id_numeStudI);
        prenume = findViewById(R.id.id_prenumeStudI);
        email = findViewById(R.id.id_mailStudI);
        parola = findViewById(R.id.id_parolaStudI);
        confirmaParola = findViewById(R.id.id_confirmParolaStudI);
        creeazaCont = findViewById(R.id.id_butonInregistreazaStud);
        //radioGroupTip = findViewById(R.id.id_radioGrup);

    }

//    public void validareEmail() {
//        if (!(emailValue.matches(emailPattern))) {
//            Toast.makeText(getApplicationContext(), "Email invalid!", Toast.LENGTH_SHORT).show();
//        }
//    }

        public void creeazaContStudent (View view)
        {
            String emailValue = email.getText().toString().trim();
            String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

            if (nume != null && prenume != null && email != null && parola != null && confirmaParola != null) {
                if ("".equals(nume.getText().toString()) || "".equals(prenume.getText().toString()) ||
                        "".equals(email.getText().toString()) || "".equals(parola.getText().toString()) ||
                        "".equals(confirmaParola.getText().toString())) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Eroare");
                    builder.setMessage("Toate câmpurile sunt obligatorii!");
                    builder.setPositiveButton("OK", null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                } else if ((confirmaParola.equals(parola)) && (emailValue.matches(emailPattern))) {
                    utilStud = new UtilizatorStudent(nume.getText().toString(), prenume.getText().toString(), email.getText().toString(),
                            parola.getText().toString(), confirmaParola.getText().toString());

                    creeazaCont.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intentConectare = new Intent(InregistrareProfilStudent.this, ConectareStudent.class);
                           startActivityForResult(intentConectare, 4);                 }
                 });
                } else if (!(confirmaParola.equals(parola)) || !(emailValue.matches(emailPattern))){
                    Toast.makeText(InregistrareProfilStudent.this, "Email-ul nu e introdus corect sau parola nu coincide!", Toast.LENGTH_SHORT).show();
                }

            }

//                if (confirmaParola.equals(parola)) {
////                    utilStud = new UtilizatorStudent(nume.getText().toString(), prenume.getText().toString(), email.getText().toString(),
////                            parola.getText().toString(), confirmaParola.getText().toString());
//                    //Toast.makeText(InregistrareProfilStudent.this, utilizator.toString(), Toast.LENGTH_SHORT).show();
//                } else {
////                    Toast.makeText(InregistrareProfilStudent.this, "Parola nu coincide!", Toast.LENGTH_SHORT).show();
//                }
//                if (!(emailValue.matches(emailPattern))) {
//                    Toast.makeText(getApplicationContext(), "Email invalid!", Toast.LENGTH_SHORT).show();
//                }




            creeazaCont.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentConectare = new Intent(InregistrareProfilStudent.this, ConectareStudent.class);
                    startActivityForResult(intentConectare, 4);
                }
            });
        }
    }




