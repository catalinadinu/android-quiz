package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.icu.text.LocaleDisplayNames;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.catalinadinu.androidquiz.clase.Utilizator;

public class InregistrareProfilProfesor extends AppCompatActivity {
    private EditText nume;
    private EditText prenume;
    private EditText email;
    private EditText parola;
    private EditText confirmaParola;
    private Button creeazaCont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inregistrare_profil_profesor);

        nume = findViewById(R.id.id_numeProfI);
        prenume = findViewById(R.id.id_prenumeProfI);
        email = findViewById(R.id.id_mailProfI);
        parola = findViewById(R.id.id_parolaProfI);
        confirmaParola = findViewById(R.id.id_confirmaParolaProfI);
        creeazaCont=findViewById(R.id.id_butonInregistreaza);
    }

    public void creeazaContProfesor(View view)
    {
        if(nume!=null && prenume!= null && email!= null && parola!=null && confirmaParola!= null)
        {
            if("".equals(nume.getText().toString()) || "".equals(prenume.getText().toString()) ||
                    "".equals(email.getText().toString()) || "".equals(parola.getText().toString()) ||
                    "".equals(confirmaParola.getText().toString()))
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Eroare");
                builder.setMessage("Toate câmpurile sunt obligatorii!");
                builder.setPositiveButton("OK", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            else
            {
                Utilizator utilizator = new Utilizator(nume.getText().toString(), prenume.getText().toString(), email.getText().toString(),
                        parola.getText().toString());

                creeazaCont.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentConectare = new Intent(InregistrareProfilProfesor.this, ConectareProfesor.class);
                        startActivityForResult(intentConectare, 3);
                    }
                });
            }
        }
    }
}
