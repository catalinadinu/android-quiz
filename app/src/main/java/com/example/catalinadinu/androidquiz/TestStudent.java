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

        ArrayList<String> raspunsuri1 = new ArrayList<>();
        raspunsuri1.add("o clasă poate implementa mai multe interfețe, însă poate extinde o singură clasă abstractă");
        raspunsuri1.add("o clasă abstractă are cel puțin o metodă abstractă");
        raspunsuri1.add("în interfețe și clase abstracte nu pot fi definite metode statice");


        ArrayList<String> raspunsuri2 = new ArrayList<>();
        raspunsuri2.add("expunerea unei interfețe high-level de lucru cu obiectul");
        raspunsuri2.add("posibilitatea suprascrierii (overriding) metodelor");
        raspunsuri2.add("construirea de obiecte complexe și ascunderea modului lor de funcționare");

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
        intrebari.add(new Intrebare(4, "Care combinație reprezintă, într-o clasă pe " +
                "nume Test, o suprascriere, respectiv o supraîncărcare validă " +
                "(overriding și overloading) pentru metoda equals din java.lang.Object??", raspunsuri4));
        intrebari.add(new Intrebare(5, "Care dintre următoarele clase sunt imutabile?", raspunsuri5));

        IntrebariAdaptorPersonalizat adaptor = new IntrebariAdaptorPersonalizat(getApplicationContext(), intrebari);
        listViewIntrebari.setAdapter(adaptor);
    }

    public void butonSubmit(View view){
        Intent intentSubmit = new Intent(TestStudent.this, FinalTest.class);
        startActivityForResult(intentSubmit, 12);
    }

}
