package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.catalinadinu.androidquiz.clase.StudentiAdaptorPersonalizat;
import com.example.catalinadinu.androidquiz.clase.UtilizatorStudent;

import java.util.ArrayList;
import java.util.Arrays;

public class FormularFeedback extends Activity {

    private SearchView searchStudent;
    private ListView studentiFeedback;
    private ImageButton backContProfFdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formular_feedback);

        searchStudent = findViewById(R.id.searchViewStudentFdb);
        studentiFeedback = findViewById(R.id.listaStudentiFdb);
        backContProfFdb = findViewById(R.id.backContProfFdb);

        //facut pt adaptor personalizat
        UtilizatorStudent[] studenti = new UtilizatorStudent[]{
                new UtilizatorStudent("Popescu", "Ana", "ana@gmail.com", "A10"),
                new UtilizatorStudent("Popescu", "Vlad", "ion@gmail.com","A11"),
                new UtilizatorStudent("Popa", "Ioana", "ioana@gmail.com","A12"),
                new UtilizatorStudent("Anghelescu", "Robert", "rob@gmail.com","A13"),
                new UtilizatorStudent("Anghel", "Mihai", "victor@gmail.com","A14")
        };

        ArrayList<UtilizatorStudent> listaStudenti = new ArrayList<>();
        listaStudenti.addAll(Arrays.asList(studenti));

        //ArrayAdapter<UtilizatorStudent> basicAdapter=new ArrayAdapter<>(FormularFeedback.this,android.R.layout.simple_list_item_1,listaStudenti);

        StudentiAdaptorPersonalizat adaptorPersonalizat = new StudentiAdaptorPersonalizat(this,android.R.layout.simple_list_item_1 ,listaStudenti);
        studentiFeedback.setAdapter(adaptorPersonalizat);
    }



    //search view in care introduce codul studentului si dupa ce il gaseste in listview, apasa pe
    // el si ii apare un pop-up in care introduce nota si da salvare (pop-up cu introduceti nota si salvare)
    public void butonBackContProf(View view){
        Intent intentBack = new Intent(FormularFeedback.this, ContProfesor.class);
        startActivityForResult(intentBack, 5);
    }


}
