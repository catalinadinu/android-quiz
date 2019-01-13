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

    private ListView listViewIntrebari;
    private Button butonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_student);

        listViewIntrebari = findViewById(R.id.listViewIntrebari);
        butonSubmit = findViewById(R.id.butonSubmit);

        ArrayList<String> raspunsuri1 = new ArrayList<>();
        raspunsuri1.add("o clasa poate implementa mai multe interfete, insa poate extinde o singura clasa abstracta");
        raspunsuri1.add("o clasa abstracta are cel putin o metoda abstracta");
        raspunsuri1.add("in interfete si clase abstracte nu pot fi definite metode statice");


        ArrayList<String> raspunsuri2 = new ArrayList<>();
        raspunsuri2.add("expunerea unei interfete high-level de lucru cu obiectul");
        raspunsuri2.add("posibilitatea suprascrierii (overriding) metodelor");
        raspunsuri2.add("construirea de obiecte complexe si ascunderea modului lor de functionare");

        ArrayList<String> raspunsuri3 = new ArrayList<>();
        raspunsuri3.add("List<Integer> list = new List<Integer>()");
        raspunsuri3.add("ArrayList<Integer> list = new List<Integer>()");
        raspunsuri3.add("List<Integer> list = new ArrayList<Integer>()");


        ArrayList<String> raspunsuri4 = new ArrayList<>();
        raspunsuri4.add("public boolean equals(Object t) / public int equals(Test t)");
        raspunsuri4.add("public Boolean equals (Object t) / public int equals (Object b)");
        raspunsuri4.add("boolean equals(Object o) / public boolean equals(Test t)");

        ArrayList<String> raspunsuri5 = new ArrayList<>();
        raspunsuri5.add("Object, String");
        raspunsuri5.add("Integer, String");
        raspunsuri5.add("public class Test { private final int x = 3 };");

        ArrayList<Intrebare> intrebari = new ArrayList<>();
        intrebari.add(new Intrebare(1, "Care afirmatie este corecta?", raspunsuri1));
        intrebari.add(new Intrebare(2, "Care dintre urmatoarele variante nu defineste incapsularea?", raspunsuri2));
        intrebari.add(new Intrebare(3, "Care declaratie este corecta?", raspunsuri3));
        intrebari.add(new Intrebare(4, "Care combinație reprezinta, intr-o clasa pe " +
                "nume Test, o suprascriere, respectiv o supraincarcare valida " +
                "(overriding si overloading) pentru metoda equals din java.lang.Object??", raspunsuri4));
        intrebari.add(new Intrebare(5, "Care dintre urmatoarele clase sunt imutabile?", raspunsuri5));

        IntrebariAdaptorPersonalizat adaptor = new IntrebariAdaptorPersonalizat(getApplicationContext(), intrebari);
        listViewIntrebari.setAdapter(adaptor);
    }

    public void butonSubmit(View view){
        Intent intentSubmit = new Intent(TestStudent.this, ContStudent.class);
        startActivityForResult(intentSubmit, 6);
    }

}
