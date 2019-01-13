package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.catalinadinu.androidquiz.clase.ContractBazaDate;
import com.example.catalinadinu.androidquiz.clase.ProfesorBD;
import com.example.catalinadinu.androidquiz.clase.StudentBD;

public class setariContProfesor extends Activity {

    private TextView parolaVecheProfesor;
    private TextView parolaNouaProfesor;
    private Button schimbaParolaProfesor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setari_cont_profesor);

        parolaVecheProfesor = findViewById(R.id.parolaVecheProfesor);
        parolaNouaProfesor = findViewById(R.id.parolaNouaProfesor);
        schimbaParolaProfesor = findViewById(R.id.schimbaParolaProfesor);

        schimbaParolaProfesor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContractBazaDate bazaDate = new ContractBazaDate(getApplicationContext());
                Cursor cursor = bazaDate.getInregistrareDataProfCursor(InregistrareProfilProfesor.profesorDetaliiCont.getEmail());

                //Log.d("cursor", cursor.getCount()+"");
                if(cursor.getCount() == 1){
                    cursor.moveToNext();
                    String parolaProfesor = cursor.getString(cursor.getColumnIndex(ProfesorBD.COLUMN_PASSWORD));
                    //Log.d("intru", cursor.getString(cursor.getColumnIndex(StudentBD.COLUMN_PASSWORD)));

                    if(!cursor.isClosed()){
                        cursor.close();
                    }

                    if(parolaVecheProfesor.getText().toString().equals(parolaProfesor)){
                        bazaDate.updateParolaProfesor(InregistrareProfilProfesor.profesorDetaliiCont.getEmail(), parolaNouaProfesor.getText().toString());
                        bazaDate.close();
                        Toast.makeText(getApplicationContext(), "Parola a fost modificata cu succes!", Toast.LENGTH_LONG).show();
                        finish();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Parola actuala a contului este introdusa gresit!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    public void schimbaParola(View view){
        Toast.makeText(setariContProfesor.this,"Parola a fost modificată cu succes.", Toast.LENGTH_LONG).show();
    }

    public void deconectare(View view){
        Intent intentDeconectare = new Intent(setariContProfesor.this, MainActivity.class);
        startActivityForResult(intentDeconectare, 0);
    }

    public void detaliiContProf(View view){
        Intent intent = new Intent(setariContProfesor.this, DetaliiContProfesor.class);
        startActivity(intent);
    }

}
