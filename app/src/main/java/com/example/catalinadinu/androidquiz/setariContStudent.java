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
import com.example.catalinadinu.androidquiz.clase.StudentBD;

public class setariContStudent extends Activity {

    private TextView parolaVecheStudent;
    private TextView parolaNouaStudent;
    private Button schimbaParolaStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setari_cont_student);

        parolaVecheStudent = findViewById(R.id.parolaVecheStudent);
        parolaNouaStudent = findViewById(R.id.parolaNouaStudent);
        schimbaParolaStudent = findViewById(R.id.schimbaParolaStudent);

        schimbaParolaStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContractBazaDate bazaDate = new ContractBazaDate(getApplicationContext());
                Cursor cursor = bazaDate.getInregistrareDataStudCursor(InregistrareProfilStudent.studentDetaliiCont.getEmail());

                //Log.d("cursor", cursor.getCount()+"");
                if(cursor.getCount() == 1){
                    cursor.moveToNext();
                    String parolaStudent = cursor.getString(cursor.getColumnIndex(StudentBD.COLUMN_PASSWORD));
                    //Log.d("intru", cursor.getString(cursor.getColumnIndex(StudentBD.COLUMN_PASSWORD)));

                    if(!cursor.isClosed()){
                        cursor.close();
                    }

                    if(parolaVecheStudent.getText().toString().equals(parolaStudent)){
                        bazaDate.updateParolaStudent(InregistrareProfilStudent.studentDetaliiCont.getEmail(), parolaNouaStudent.getText().toString());
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

    public void deconectare(View view){
        Intent intentDeconectare = new Intent(setariContStudent.this, MainActivity.class);
        startActivityForResult(intentDeconectare, 0);
    }


    public void detaliiCont(View view){
        Intent intentDetaliiCont = new Intent(setariContStudent.this, DetaliiContStudent.class);
        startActivityForResult(intentDetaliiCont, 21);
    }
}

