package com.example.catalinadinu.androidquiz;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.catalinadinu.androidquiz.clase.DatabaseContract;
import com.example.catalinadinu.androidquiz.clase.UtilizatorProfesor;

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
    public DatabaseContract profesorContractBD;

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

        profesorContractBD = new DatabaseContract(this);

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
                    profesorContractBD.insertProf();
                    //Log.d("plm", profesori.toString());
                    Intent intentConectare = new Intent(InregistrareProfilProfesor.this, ContProfesor.class);
                    startActivityForResult(intentConectare, 5);
                    //apel functie transfer obiect
                    trimiteNume();
                }
                else {
                    Toast.makeText(InregistrareProfilProfesor.this, "Parola nu coincide!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
