package com.example.catalinadinu.androidquiz;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.catalinadinu.androidquiz.clase.ContractBazaDate;
import com.example.catalinadinu.androidquiz.clase.ProfesorBD;
import com.example.catalinadinu.androidquiz.clase.StudentBD;
import com.example.catalinadinu.androidquiz.clase.UtilizatorProfesor;
import com.example.catalinadinu.androidquiz.clase.UtilizatorStudent;

import java.util.ArrayList;
import java.util.List;


public class InregistrareProfilProfesor extends AppCompatActivity {
    private EditText nume;
    private EditText prenume;
    private EditText email;
    private EditText parola;
    private EditText confirmaParola;
    private Button creeazaCont;
    public UtilizatorProfesor utilProf;
    public static List<UtilizatorProfesor> profesori =  new ArrayList<>();
    public ContractBazaDate profesorContractBD;
    public static UtilizatorProfesor profesorDetaliiCont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inregistrare_profil_profesor);

        nume = findViewById(R.id.id_numeProfI);
        prenume = findViewById(R.id.id_prenumeProfI);
        email = findViewById(R.id.id_mailProfI);
        parola = findViewById(R.id.id_parolaProfI);
        confirmaParola = findViewById(R.id.id_confirmaParolaProfI);
        creeazaCont=findViewById(R.id.id_butonInregistreaza);

        profesorContractBD = new ContractBazaDate(this);

    }

    public void trimiteNume() {
        //intent implicit pentru a transfera parametrii
        //String last = nume.getText().toString();
        String first = prenume.getText().toString();

        Intent intent = new Intent(InregistrareProfilProfesor.this, ContProfesor.class);
        intent.putExtra("PRENUME", first);
        //intent.putExtra("NUME", last);
        startActivity(intent);
    }

    public void trimiteEmailProfesor(){
        //baza de date
        String emailProfTextView = email.getText().toString();
        ContractBazaDate bazaDate = new ContractBazaDate(this);
        Cursor cursor = bazaDate.getInregistrareDataProfCursor(emailProfTextView);

        Log.d("cursor", cursor.getCount()+"");
        if(cursor.getCount() == 1){
            cursor.moveToFirst();

            String emailProf = cursor.getString(cursor.getColumnIndex(ProfesorBD.COLUMN_EMAIL));

            if(email.getText().toString().equals(emailProf)){
                profesorDetaliiCont = new UtilizatorProfesor(emailProf);
            }
        }
//        else {
//            Toast.makeText(getApplicationContext(), "Emailul exista deja in baza de date!", Toast.LENGTH_LONG).show();
//        }

    }


        public void creeazaContProfesor(View view)
    {
        if(nume!=null && prenume!= null && email!= null && parola!=null && confirmaParola!= null)
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
            else  {
                if(confirmaParola.getText().toString().equals(parola.getText().toString())){
                    utilProf = new UtilizatorProfesor(nume.getText().toString(),prenume.getText().toString(), email.getText().toString(),
                            parola.getText().toString(), confirmaParola.getText().toString());
                    profesori.add(utilProf);

                    if(profesorContractBD.insertProf() ==  -1){
                        Toast.makeText(this, "Email-ul apartine unui cont existent!", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Cont adaugat in baza de date!", Toast.LENGTH_LONG).show();
                        Intent intentConectare = new Intent(InregistrareProfilProfesor.this, ContProfesor.class);
                        startActivityForResult(intentConectare, 5);
                        trimiteNume();
                        trimiteEmailProfesor();
                    }
                }
                else {
                    Toast.makeText(InregistrareProfilProfesor.this, "Parola nu coincide!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
