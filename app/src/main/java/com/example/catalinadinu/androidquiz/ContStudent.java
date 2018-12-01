package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ContStudent extends Activity {

    private Spinner spinnerMaterie;
    private Button incepeTest;
    private TextView numeStud;
    private TextView codStud;
    String prenumestudd;
    //String numeProf;
    String codstudd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cont_student);

        numeStud = findViewById(R.id.textViewNumeContPersonalStud);
        codStud = findViewById(R.id.textViewCodContStud);
        incepeTest = findViewById(R.id.id_boutonQuizNouS);
        spinnerMaterie = findViewById(R.id.id_spinnerMaterieS);
        spinnerMaterie.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selectat: " + item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //transfer
        if(getIntent().hasExtra("COD")){
            codstudd = getIntent().getExtras().getString("COD");
            codStud.setText(codstudd);
        }
        else if (getIntent().hasExtra("PRENUME")){
            prenumestudd = getIntent().getExtras().getString("PRENUME");
            //numeProf = getIntent().getExtras().getString("NUME");
            numeStud.setText(prenumestudd );//+ " " + numeProf);
        }

        List<String> materii = new ArrayList<>();
        materii.add("BTI");
        //materii.add("POO");

        ArrayAdapter<String> adaptor = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, materii);
        spinnerMaterie.setAdapter(adaptor);

    }


    public void IncepeTest(View view)
    {
        incepeTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valoareSpinner = spinnerMaterie.getSelectedItem().toString();
                if(valoareSpinner.equals("BTI")){
                    Intent intentIncepeTest = new Intent(ContStudent.this, TestStudent.class);
                    startActivityForResult(intentIncepeTest, 7);}
//                    else
//                {
//                    Intent intentIncepeTest = new Intent(ContStudent.this, Materie2Stud.class);
//                    startActivityForResult(intentIncepeTest, 7);
//                }
            }
        });
    }
}
