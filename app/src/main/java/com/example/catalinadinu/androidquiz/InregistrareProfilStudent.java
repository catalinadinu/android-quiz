package com.example.catalinadinu.androidquiz;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import com.example.catalinadinu.androidquiz.clase.ContractBazaDate;
import com.example.catalinadinu.androidquiz.clase.StudentBD;
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
    public static UtilizatorStudent studentDetaliiCont;


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
        studentContractBD = new ContractBazaDate(this);



    }


    public void trimiteNume() {

        String first = prenume.getText().toString();

        Intent intent = new Intent(InregistrareProfilStudent.this, ContStudent.class);
        intent.putExtra("PRENUME", first);

        startActivity(intent);
    }

    public void trimiteEmailStudent(){

        String emailStudentTextView = email.getText().toString();
        ContractBazaDate bazaDate = new ContractBazaDate(this);
        Cursor cursor = bazaDate.getInregistrareDataStudCursor(emailStudentTextView);


        if(cursor.getCount() == 1){
            cursor.moveToFirst();

            String emailStud = cursor.getString(cursor.getColumnIndex(StudentBD.COLUMN_EMAIL));

            if(email.getText().toString().equals(emailStud)){
                studentDetaliiCont = new UtilizatorStudent(emailStud);
            }
        }
//        else {
//            Toast.makeText(getApplicationContext(), "Emailul exista deja in baza de date!", Toast.LENGTH_LONG).show();
//        }

    }


    public void creeazaContStudent(View view) {
        if (nume != null && prenume != null && email != null && parola != null && confirmaParola != null) {
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
                    if (confirmaParola.getText().toString().equals(parola.getText().toString())) {
                        utilStud = new UtilizatorStudent(nume.getText().toString(), prenume.getText().toString(), email.getText().toString(),
                                parola.getText().toString(), confirmaParola.getText().toString());
                        studenti.add(utilStud);

                        if(studentContractBD.insertStud() == -1){
                            Toast.makeText(this, "Email-ul apartine unui cont existent!", Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Cont adaugat in baza de date!", Toast.LENGTH_LONG).show();
                            Intent intentConectare = new Intent(InregistrareProfilStudent.this, ContStudent.class);
                            startActivityForResult(intentConectare, 6);
                            trimiteNume();
                            trimiteEmailStudent();

                            Intent intentInreg = new Intent(InregistrareProfilStudent.this, ContStudent.class);
                            intentInreg.putExtra("inregistrareStud", "inregistrareStud");
                            startActivity(intentInreg);
                        }
                    }
                    else {
                        Toast.makeText(InregistrareProfilStudent.this, "Parola nu coincide!", Toast.LENGTH_SHORT).show();
                    }
                }
            }



            }

        }

}



