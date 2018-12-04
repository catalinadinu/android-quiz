package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.catalinadinu.androidquiz.clase.StudentiAdaptorPersonalizat;
import com.example.catalinadinu.androidquiz.clase.Test;
import com.example.catalinadinu.androidquiz.clase.TesteAdaptorPersonalizat;
import com.example.catalinadinu.androidquiz.clase.UtilizatorStudent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContStudent extends Activity {

    private Spinner spinnerMaterie;
    private Button incepeTest;
    private TextView numeStud;
    private TextView codStud;
    private ListView listViewTesteStudent;
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
        listViewTesteStudent = findViewById(R.id.listViewTesteStudent);
//        spinnerMaterie.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                String item = parent.getItemAtPosition(position).toString();
//                Toast.makeText(parent.getContext(), "Selectat: " + item, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

        //listview - adaptor personalizat
        Test[] testeStudent = new Test[]{
                new Test("Test POO", "5"),
                new Test("Test JAVA", "5"),
                new Test("Test DAM", "5"),
                new Test("Test TEHNOLOGII WEB", "5")
        };

        ArrayList<Test> listaTeste = new ArrayList<>();
        listaTeste.addAll(Arrays.asList(testeStudent));

        TesteAdaptorPersonalizat adaptorPersonalizat = new TesteAdaptorPersonalizat(this,android.R.layout.simple_list_item_1 ,listaTeste);
        listViewTesteStudent.setAdapter(adaptorPersonalizat);


        //item selectat din listview
        listViewTesteStudent.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        AdapterView.OnItemClickListener listClick = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ContStudent.this, TestStudent.class);
                startActivityForResult(intent, 8);
            }
        };

        listViewTesteStudent.setOnItemClickListener(listClick);



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
            }
        });
    }

    public void setariContStudent(View view){
        Intent intentSetariStudent = new Intent(ContStudent.this, setariContStudent.class);
        startActivityForResult(intentSetariStudent, 19);
    }
}
