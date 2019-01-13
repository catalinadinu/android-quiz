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
import com.example.catalinadinu.androidquiz.clase.ProfesorBD;
import com.example.catalinadinu.androidquiz.clase.StudentBD;

import java.io.FileOutputStream;

public class DetaliiContProfesor extends AppCompatActivity {

    private TextView tVNumeProf;
    private TextView tVPrenumeProf;
    private TextView tVEmailProf;
    private Button buttonStergeContProf;
    private Button salveaza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalii_cont_profesor);

        tVNumeProf =  findViewById(R.id.tVNumeProf);
        tVPrenumeProf = findViewById(R.id.tVPrenumeProf);
        tVEmailProf = findViewById(R.id.tVEmailProf);
        buttonStergeContProf = findViewById(R.id.buttonStergeContProf);
        salveaza = findViewById(R.id.txtProf);

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

        String textViewSaveNumeProf = tVNumeProf.getText().toString();
        String textViewSavePrenumeProf = tVPrenumeProf.getText().toString();
        String textViewSaveEmailProf = tVEmailProf.getText().toString();
        final String rezultatSave = textViewSaveNumeProf + "," + textViewSavePrenumeProf + "," +
                textViewSaveEmailProf;

        salveaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFile("raport.txt", rezultatSave);
            }
        });

    }

      public void saveFile(String file, String text){

        try{
              Log.d("kkkkkkkkk", "am ajuns aici");
              FileOutputStream fos = openFileOutput(file, Context.MODE_PRIVATE);
              Log.d("rahat", "am ajuns aici");
              fos.write(text.getBytes());
              Log.d("mata", "am ajuns aici");
              fos.close();
              Log.d("flori", "am ajuns aici");
              Toast.makeText(DetaliiContProfesor.this, "Date salvate cu succes", Toast.LENGTH_SHORT).show();
          }catch(Exception ex){

              ex.printStackTrace();
              Toast.makeText(DetaliiContProfesor.this, "Eroare la salvare in fisier", Toast.LENGTH_SHORT).show();
          }

      }
}
