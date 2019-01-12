package com.example.catalinadinu.androidquiz;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import com.example.catalinadinu.androidquiz.clase.ContractBazaDate;
import com.example.catalinadinu.androidquiz.clase.UtilizatorStudent;

import java.util.ArrayList;
import java.util.List;

public class InregistrareProfilStudent extends AppCompatActivity {

    private EditText nume;
    private EditText prenume;
    private EditText email;
    private EditText parola;
    private EditText confirmaParola;
    private Button creeazaCont;
    public UtilizatorStudent utilStud;
    public static List<UtilizatorStudent> studenti = new ArrayList<>();
    public ContractBazaDate studentContractBD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inregistrare_profil_student);

        nume = findViewById(R.id.id_numeStudI);
        prenume = findViewById(R.id.id_prenumeStudI);
        email = findViewById(R.id.id_mailStudI);
        parola = findViewById(R.id.id_parolaStudI);
        confirmaParola = findViewById(R.id.id_confirmParolaStudI);
        creeazaCont = findViewById(R.id.id_butonInregistreazaStud);
        //radioGroupTip = findViewById(R.id.id_radioGrup);

        studentContractBD = new ContractBazaDate(this);

    }


//    public void validareEmail() {
//        if (!(emailValue.matches(emailPattern))) {
//            Toast.makeText(getApplicationContext(), "Email invalid!", Toast.LENGTH_SHORT).show();
//        }
//    }

    public void trimiteNume() {
        //intent implicit pentru a transfera parametrii
        //String last = nume.getText().toString();
        String first = prenume.getText().toString();

        Intent intent = new Intent(InregistrareProfilStudent.this, ContStudent.class);
        intent.putExtra("PRENUME", first);
        //intent.putExtra("NUME", last);
        startActivity(intent);
    }


    public void creeazaContStudent(View view) {
        if (nume != null && prenume != null && email != null && parola != null && confirmaParola != null) {
            //String emailValue = email.getText().toString().trim();
            //String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

            if (nume != null && prenume != null && email != null && parola != null && confirmaParola != null) {
                if ("".equals(nume.getText().toString()) || "".equals(prenume.getText().toString()) ||
                        "".equals(email.getText().toString()) || "".equals(parola.getText().toString()) ||
                        "".equals(confirmaParola.getText().toString())) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Eroare");
                    builder.setMessage("Toate câmpurile sunt obligatorii!");
                    builder.setPositiveButton("OK", null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                } else {
                    if (confirmaParola.getText().toString().equals(parola.getText().toString())) { //&& (emailValue.matches(emailPattern))) {
                        utilStud = new UtilizatorStudent(nume.getText().toString(), prenume.getText().toString(), email.getText().toString(),
                                parola.getText().toString(), confirmaParola.getText().toString());
                        studenti.add(utilStud);
                        //Log.d("MUIE", studenti.toString());
                        studentContractBD.insertStud();
                        Intent intentConectare = new Intent(InregistrareProfilStudent.this, ContStudent.class);
                        startActivityForResult(intentConectare, 6);
                        trimiteNume();
                    }
                    else{
                        Toast.makeText(InregistrareProfilStudent.this, "Parola nu coincide!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
                 //else if (!(confirmaParola.equals(parola)) || !(emailValue.matches(emailPattern))) {
                  //  Toast.makeText(InregistrareProfilStudent.this, "Email-ul nu e introdus corect sau parola nu coincide!", Toast.LENGTH_SHORT).show();


            }

        }

}



