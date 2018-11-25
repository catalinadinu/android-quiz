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
    public UtilizatorStudent utilStud;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inregistrare_profil_student);

        nume=findViewById(R.id.id_numeStudI);
        prenume=findViewById(R.id.id_prenumeStudI);
        email=findViewById(R.id.id_mailStudI);
        parola=findViewById(R.id.id_parolaStudI);
        confirmaParola=findViewById(R.id.id_confirmParolaStudI);
        creeazaCont=findViewById(R.id.id_butonInregistreazaStud);
        //radioGroupTip = findViewById(R.id.id_radioGrup);

    }

    public void creeazaContStudent(View view)
    {
        if(nume!=null && prenume!=null && email!=null && parola!=null && confirmaParola != null)
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
                //String radioValue = ((RadioButton)findViewById(radioGroupTip.getCheckedRadioButtonId())).getText().toString();
                //UtilizatorStudent utilizator= new UtilizatorStudent();
                if(confirmaParola.equals(parola)){
                    utilStud = new UtilizatorStudent(nume.getText().toString(),prenume.getText().toString(), email.getText().toString(),
                            parola.getText().toString(), confirmaParola.getText().toString());
                    //Toast.makeText(InregistrareProfilStudent.this, utilizator.toString(), Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(InregistrareProfilStudent.this, "Parola nu coincide!", Toast.LENGTH_SHORT).show();
                }

                //Toast.makeText(Inregistrare.this, utilizator.toString(), Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent();
//                intent.putExtra("util", utilizator);
//                setResult(RESULT_OK, intent);
//                finish();
                creeazaCont.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentConectare = new Intent(InregistrareProfilStudent.this, ConectareStudent.class);
                        startActivityForResult(intentConectare, 4);
                    }
                });
            }
        }
    }
}
