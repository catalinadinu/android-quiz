package com.example.catalinadinu.androidquiz;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.catalinadinu.androidquiz.clase.ContractBazaDate;
import com.example.catalinadinu.androidquiz.clase.ProfesorBD;
import com.example.catalinadinu.androidquiz.clase.StudentBD;

public class DetaliiContProfesor extends AppCompatActivity {

    private TextView tVNumeProf;
    private TextView tVPrenumeProf;
    private TextView tVEmailProf;
    private Button buttonStergeContProf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalii_cont_profesor);

        tVNumeProf =  findViewById(R.id.tVNumeProf);
        tVPrenumeProf = findViewById(R.id.tVPrenumeProf);
        tVEmailProf = findViewById(R.id.tVEmailProf);
        buttonStergeContProf = findViewById(R.id.buttonStergeContProf);

        ContractBazaDate database=new ContractBazaDate(getApplicationContext());
        //aici crapa
        Cursor cursor = database.getProfBDDataCursor(InregistrareProfilProfesor.profesorDetaliiCont.getEmail());
        cursor.moveToFirst();

        String nume = cursor.getString(cursor.getColumnIndex(ProfesorBD.COLUMN_LAST_NAME));
        String prenume = cursor.getString(cursor.getColumnIndex(ProfesorBD.COLUMN_FIRST_NAME));
        final String emaill = cursor.getString(cursor.getColumnIndex(ProfesorBD.COLUMN_EMAIL));

        if (!cursor.isClosed())
        {
            cursor.close();
        }

        tVNumeProf.setText(nume);
        tVPrenumeProf.setText(prenume);
        tVEmailProf.setText(emaill);

        //functie pentru stergere
        buttonStergeContProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContractBazaDate bazaDate = new ContractBazaDate(getApplicationContext());
                bazaDate.deleteProfItembyPK(emaill);
                Toast.makeText(getApplicationContext(), "Contul tau a fost sters!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });

    }
}
