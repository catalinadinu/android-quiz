package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.catalinadinu.androidquiz.clase.UtilizatorStudent;

public class ConectareStudent extends Activity {

    private TextView email;
    private TextView parola;
    private TextView cod;
    private TextView datele;
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
        datele = findViewById(R.id.datee);
    }

    public void saveInfoo(View view){
        SharedPreferences sharePref = getSharedPreferences("userinfo",Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharePref.edit();
        editor.putString("email", email.getText().toString());
        editor.putString("parola", parola.getText().toString());
        editor.putString("cod", cod.getText().toString());
        editor.apply();

        Toast.makeText(this, "Date salvate!", Toast.LENGTH_LONG).show();
        String email = sharePref.getString("email", "");
        String parola = sharePref.getString("parola", "");
        String cod = sharePref.getString("cod", "");

        datele.setText(email + " "+ parola + " "+ cod);

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
