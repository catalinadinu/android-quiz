package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.catalinadinu.androidquiz.clase.ContractBazaDate;
import com.example.catalinadinu.androidquiz.clase.ProfesorBD;
import com.example.catalinadinu.androidquiz.clase.UtilizatorProfesor;

public class ConectareProfesor extends Activity {

    private TextView emailProf;
    private TextView parolaProf;
    private TextView cod;
    private Button conectareProf;
    private UtilizatorProfesor utilProf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conectare_profesor);

        emailProf = findViewById(R.id.id_emailProfConectare);
        parolaProf =  findViewById(R.id.id_parolaProfConectare);
        cod = findViewById(R.id.id_codProfConectare);
        conectareProf = findViewById(R.id.id_butonConectare);

    }

    public void trimiteCodCont(){
        String codProf = cod.getText().toString();

        Intent intent = new Intent(ConectareProfesor.this, ContProfesor.class);
        intent.putExtra("COD", codProf);
        startActivity(intent);
    }

//    public void verificainBD(){
//        String emailTextView = emailProf.getText().toString();
//        //String parolaTextView = parolaProf.getText().toString();
//
//        ContractBazaDate db = new ContractBazaDate(this);
//        Cursor cursor = db.getInregistrareDataProfCursor(emailTextView);
//        Log.d("plm", cursor.getCount()+"");
//
//        if(cursor.getCount() < 1){
//            Toast.makeText(this, "Nu se poate!", Toast.LENGTH_LONG);
//        }
//        else {
//            cursor.moveToFirst();
//            String emailProfesor = cursor.getString(cursor.getColumnIndex(ProfesorBD.COLUMN_EMAIL));
//            String parolaProfesor = cursor.getString(cursor.getColumnIndex(ProfesorBD.COLUMN_PASSWORD));
//            if (emailProf.getText().toString().equals(emailProfesor) && parolaProf.getText().toString().equals(parolaProfesor)) {
//                Intent intentConectareProf = new Intent(ConectareProfesor.this, ContProfesor.class);
//                startActivityForResult(intentConectareProf, 5);
//                trimiteCodCont();
//            } else if (!(emailProf.getText().toString().equals(emailProfesor))) {
//                Toast.makeText(getApplicationContext(), "Emailul nu coincide cu cel din contul inregistrat!", Toast.LENGTH_LONG);
//            } else if (!(parolaProf.getText().toString().equals(parolaProfesor))) {
//                Toast.makeText(getApplicationContext(), "Parola nu coincide cu cea din contul inregistrat!", Toast.LENGTH_LONG);
//            }
//        }
//    }

    public void conectareProfesor(View view) {
        if (emailProf != null && parolaProf != null && cod != null) {
            if ("".equals(cod.getText().toString()) ||
                    "".equals(emailProf.getText().toString()) || "".equals(parolaProf.getText().toString())) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Eroare");
                builder.setMessage("Toate câmpurile sunt obligatorii!");
                builder.setPositiveButton("OK", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            else {
                Intent intentConectareProf = new Intent(ConectareProfesor.this, ContProfesor.class);
                startActivityForResult(intentConectareProf, 5);
                trimiteCodCont();
                }

            }
    }


}
