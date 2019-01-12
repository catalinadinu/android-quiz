package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.catalinadinu.androidquiz.clase.Intrebare;
import com.example.catalinadinu.androidquiz.clase.IntrebariAdaptorPersonalizat;

import java.util.ArrayList;
import java.util.List;

public class TestStudent extends Activity {
//    private RadioGroup radioGroupQ1;
//    private RadioButton radioButton1Q1;
//    private RadioButton radioButton2Q1;
//    private RadioButton radioButton3Q1;
//
//    private RadioGroup radioGroupQ2;
//    private RadioButton radioButton1Q2;
//    private RadioButton radioButton2Q2;
//    private RadioButton radioButton3Q2;
//
//    private CheckBox checkBox1Q3;
//    private CheckBox checkBox2Q3;
//    private CheckBox checkBox3Q3;
//
//    private CheckBox checkBox1Q4;
//    private CheckBox checkBox2Q4;
//    private CheckBox checkBox3Q4;
//
//    private TextView raspunsDeschisQ5;

    private ListView listViewIntrebari;
    private Button butonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_student);

        listViewIntrebari = findViewById(R.id.listViewIntrebari);
        butonSubmit = findViewById(R.id.butonSubmit);

        ArrayList<String> raspunsuri = new ArrayList<>();
        raspunsuri.add("caca");
        raspunsuri.add("bine");
        raspunsuri.add("nustu");


        ArrayList<Intrebare> intrebari = new ArrayList<>();
        intrebari.add(new Intrebare(1, "Cmf", raspunsuri, 1));
        intrebari.add(new Intrebare(2, "Cf", raspunsuri, 2));


        IntrebariAdaptorPersonalizat adaptor = new IntrebariAdaptorPersonalizat(getApplicationContext(), intrebari);
        listViewIntrebari.setAdapter(adaptor);
    }

    public void butonSubmit(View view){
        Intent intentSubmit = new Intent(TestStudent.this, FinalTest.class);
        startActivityForResult(intentSubmit, 12);
    }

}
