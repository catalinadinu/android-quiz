package com.example.catalinadinu.androidquiz;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.catalinadinu.androidquiz.clase.ContractBazaDate;
import com.example.catalinadinu.androidquiz.clase.StudentBD;
import com.example.catalinadinu.androidquiz.clase.UtilizatorStudent;

import java.io.FileOutputStream;

public class DetaliiContStudent extends AppCompatActivity {

    private TextView tVNumeStud;
    private TextView tVPrenumeStud;
    private TextView tVEmailStud;
    private Button buttonStergeCont;
    private Button salveaza;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalii_cont_student);

        tVNumeStud = findViewById(R.id.tVNumeStud);
        tVPrenumeStud = findViewById(R.id.tVPrenumeStud);
        tVEmailStud = findViewById(R.id.tVEmailStud);
        buttonStergeCont = findViewById(R.id.buttonStergeCont);
        salveaza = findViewById(R.id.salvareStud);


        ContractBazaDate database=new ContractBazaDate(getApplicationContext());
        Cursor cursor = database.getStudentBDDataCursor(InregistrareProfilStudent.studentDetaliiCont.getEmail());
        cursor.moveToFirst();

        String nume = cursor.getString(cursor.getColumnIndex(StudentBD.COLUMN_LAST_NAME));
        String prenume = cursor.getString(cursor.getColumnIndex(StudentBD.COLUMN_FIRST_NAME));
        final String emaill = cursor.getString(cursor.getColumnIndex(StudentBD.COLUMN_EMAIL));

        if (!cursor.isClosed())
        {
            cursor.close();
        }

        tVNumeStud.setText(nume);
        tVPrenumeStud.setText(prenume);
        tVEmailStud.setText(emaill);


        buttonStergeCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContractBazaDate bazaDate = new ContractBazaDate(getApplicationContext());
                bazaDate.deleteStudItembyPK(emaill);
                Toast.makeText(getApplicationContext(), "Contul tau a fost sters!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        String textViewSaveNumeStud = tVNumeStud.getText().toString();
        String textViewSavePrenumeStud = tVPrenumeStud.getText().toString();
        String textViewSaveEmailStud = tVEmailStud.getText().toString();
        final String rezultatSave = textViewSaveNumeStud + "," + textViewSavePrenumeStud + "," +
                textViewSaveEmailStud;

        salveaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFileStudent("raport.txt", rezultatSave);
            }
        });
    }

    public void saveFileStudent(String file, String text){

        try{
            FileOutputStream fos = openFileOutput(file, Context.MODE_PRIVATE);
            fos.write(text.getBytes());
            fos.close();
            Toast.makeText(DetaliiContStudent.this, "Date salvate cu succes", Toast.LENGTH_SHORT).show();
        }catch(Exception ex){

            ex.printStackTrace();
            Toast.makeText(DetaliiContStudent.this, "Eroare la salvare in fisier", Toast.LENGTH_SHORT).show();
        }

    }

}
