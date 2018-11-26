package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;

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
    }

    //search view in care introduce codul studentului si dupa ce il gaseste in listview, apasa pe
    // el si ii apare un pop-up in care introduce nota si da salvare (pop-up cu introduceti nota si salvare)
    public void butonBackContProf(View view){
        Intent intentBack = new Intent(FormularFeedback.this, ContProfesor.class);
        startActivityForResult(intentBack, 5);
    }


}
