package com.example.catalinadinu.androidquiz;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.catalinadinu.androidquiz.clase.Utilizator;

public class InregistrareProfilStudent extends AppCompatActivity {

    private EditText nume;
    private EditText prenume;
    private EditText email;
    private EditText parola;
    //private RadioGroup radioGroupTip;
    private Button creeazaCont;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inregistrare_profil_student);

        //nume=findViewById(R.id.id_numeInregistrare);
        //prenume=findViewById(R.id.id_prenumeInregistrare);
        //email=findViewById(R.id.id_mailInregistrare);
        //parola=findViewById(R.id.id_parolaInregistrare);
        //radioGroupTip = findViewById(R.id.id_radioGrup);
        //creeazaCont=findViewById(R.id.buttonInregistrare);

    }


    public void creeazaCont(View view)
    {
        if(nume!=null && prenume!=null && email!=null && parola!=null)
        {
            if("".equals(nume.getText().toString()) || "".equals(prenume.getText().toString()) ||
                    "".equals(email.getText().toString()) || "".equals(parola.getText().toString()) ||
                    "".equals(nume.getText().toString()))
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Eroare");
                builder.setMessage("Toate campurile sunt obligatorii!");
                builder.setPositiveButton("OK", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            else
            {
                //String radioValue = ((RadioButton)findViewById(radioGroupTip.getCheckedRadioButtonId())).getText().toString();
                Utilizator utilizator = new Utilizator(nume.getText().toString(),prenume.getText().toString(), email.getText().toString(),
                        parola.getText().toString());
                //Toast.makeText(Inregistrare.this, utilizator.toString(), Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent();
//                intent.putExtra("util", utilizator);
//                setResult(RESULT_OK, intent);
//                finish();
                creeazaCont.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentConectare = new Intent(InregistrareProfilStudent.this, ConectareStudent.class);
                        startActivityForResult(intentConectare, 2);
                    }
                });
            }
        }
    }
}
