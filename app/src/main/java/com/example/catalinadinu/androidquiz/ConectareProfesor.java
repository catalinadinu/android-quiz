package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.catalinadinu.androidquiz.clase.UtilizatorProfesor;

public class ConectareProfesor extends Activity {

    private TextView email;
    private TextView parola;
    private TextView cod;
    private Button conectareProf;
    private UtilizatorProfesor utilProf;
    //String firstName;
    //String lastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conectare_profesor);

        email = findViewById(R.id.id_emailProfConectare);
        parola =  findViewById(R.id.id_parolaProfConectare);
        cod = findViewById(R.id.id_codProfConectare);
        conectareProf = findViewById(R.id.id_butonConectare);


//        if(getIntent() !=null){
//            firstName = getIntent().getExtras().getString("PRENUME");
//            lastName = getIntent().getExtras().getString("NUME");
//
//        }
//        Log.d(firstName.toString(), "plmmmmmmm");
//        Log.d(lastName.toString(), "plmmmmmmm2");
    }

    public void trimiteNumeCont(){
//
//        Intent intent = new Intent(ConectareProfesor.this, ContProfesor.class);
//        intent.putExtra("Nume", lastName);
//        intent.putExtra("Prenume", firstName);
//        startActivity(intent);

        String codProf = cod.getText().toString();

        Intent intent = new Intent(ConectareProfesor.this, ContProfesor.class);
        intent.putExtra("COD", codProf);
        startActivity(intent);
    }

    public void conectareProfesor(View view) {
        //String emailValue = email.getText().toString().trim();
        //String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (email != null && parola != null && cod != null) {
            if ("".equals(cod.getText().toString()) ||
                    "".equals(email.getText().toString()) || "".equals(parola.getText().toString())) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Eroare");
                builder.setMessage("Toate câmpurile sunt obligatorii!");
                builder.setPositiveButton("OK", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            } else {
               // if (emailValue.matches(emailPattern)) {
                    utilProf = new UtilizatorProfesor(email.getText().toString(),
                            parola.getText().toString(), cod.getText().toString());
                    //Toast.makeText(InregistrareProfilStudent.this, utilizator.toString(), Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(ConectareProfesor.this, "Email invalid!", Toast.LENGTH_SHORT).show();
                Intent intentConectareProf = new Intent(ConectareProfesor.this, ContProfesor.class);
                startActivityForResult(intentConectareProf, 5);

                trimiteNumeCont();
            }

            }

        }
}
