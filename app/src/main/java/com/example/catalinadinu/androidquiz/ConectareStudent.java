package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.catalinadinu.androidquiz.clase.UtilizatorStudent;

public class ConectareStudent extends Activity {

    private TextView email;
    private TextView parola;
    private TextView cod;
    private Button conectareStud;
    private UtilizatorStudent utilizatorStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conectare_student);

        email = findViewById(R.id.id_mailConectareStud);
        parola = findViewById(R.id.id_parolaConectareStud);
        cod = findViewById(R.id.id_codConectareStud);
        conectareStud = findViewById(R.id.id_butonConectareStud);
    }

    public void trimiteNumeCont(){
//
//        Intent intent = new Intent(ConectareProfesor.this, ContProfesor.class);
//        intent.putExtra("Nume", lastName);
//        intent.putExtra("Prenume", firstName);
//        startActivity(intent);

        String codStud = cod.getText().toString();

        Intent intent = new Intent(ConectareStudent.this, ContStudent.class);
        intent.putExtra("COD", codStud);
        startActivity(intent);
    }

    public void conectareStudent(View view){
        if(email != null && parola != null && cod != null){
            if("".equals(email.getText().toString()) || "".equals(parola.getText().toString()) || "".equals(cod.getText().toString())){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Eroare");
                builder.setMessage("Toate câmpurile sunt obligatorii!");
                builder.setPositiveButton("OK", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            else {
//                utilizatorStudent = new UtilizatorStudent(email.getText().toString(),
//                        parola.getText().toString(), cod.getText().toString());
                Intent intentConectareStud = new Intent(ConectareStudent.this, ContStudent.class);
                startActivityForResult(intentConectareStud, 6);
                trimiteNumeCont();
            }

        }
    }
}
