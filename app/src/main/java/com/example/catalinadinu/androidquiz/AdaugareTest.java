package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.catalinadinu.androidquiz.clase.Intrebare;
import com.example.catalinadinu.androidquiz.clase.IntrebareDeschisa;
import com.example.catalinadinu.androidquiz.clase.IntrebareDeschisaAdaptor;
import com.example.catalinadinu.androidquiz.clase.IntrebareGrilaAdaptor;
import com.example.catalinadinu.androidquiz.clase.IntrebariAdaptorPersonalizat;

import java.util.ArrayList;
import java.util.List;

public class AdaugareTest extends Activity {

    private Spinner spinnerTipIntrebare;
    private ListView listViewRaspunsGrila;
    private ListView listViewRaspunsDeschis;
    private Button adTest;

    //aici ar trebui sa se adauge testul in tabela pe care o sa o facem mai tarziu
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adaugare_test);

        spinnerTipIntrebare = findViewById(R.id.spinnerTipIntrebare);
        listViewRaspunsGrila = findViewById(R.id.listViewRaspGrila);
        listViewRaspunsDeschis = findViewById(R.id.listViewRaspDeschis);
        adTest = findViewById(R.id.adTestButton);


        spinnerTipIntrebare.setPrompt("Selecteaza tipul intrebarii");
        List<String> tipuriIntrebari = new ArrayList<>();
        tipuriIntrebari.add("Grila");
        tipuriIntrebari.add("Raspuns deschis");
        ArrayAdapter<String> adaptor = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, tipuriIntrebari);
        spinnerTipIntrebare.setAdapter(adaptor);

        ArrayList<String> raspunsuriGrila = new ArrayList<>();
        raspunsuriGrila.add("2 bytes");
        raspunsuriGrila.add("4 bytes");
        raspunsuriGrila.add("8 bytes");

        final ArrayList<Intrebare> intrebareGrila = new ArrayList<>();
        intrebareGrila.add(new Intrebare(1, "Cat ocupa o variabila de tip int?", raspunsuriGrila, 2));

        final ArrayList<IntrebareDeschisa> intrebareDeschisa = new ArrayList<>();
        intrebareDeschisa.add(new IntrebareDeschisa(1, "Ce este o clasa abstracta?"));

        spinnerTipIntrebare.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spinnerTipIntrebare.getSelectedItem().toString().equals("Grila")){
                    IntrebareGrilaAdaptor adaptorGrila = new IntrebareGrilaAdaptor(getApplicationContext(), intrebareGrila);
                    listViewRaspunsGrila.setAdapter(adaptorGrila);
                    //listViewRaspunsDeschis.setVisibility(View.GONE);
                }
                else if(spinnerTipIntrebare.getSelectedItem().toString().equals("Raspuns deschis")){
                    Log.d("plm", "urmeaza");
                    IntrebareDeschisaAdaptor adaptorDeschis  = new IntrebareDeschisaAdaptor(getApplicationContext(), intrebareDeschisa);
                    listViewRaspunsDeschis.setAdapter(adaptorDeschis);
                    listViewRaspunsGrila.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//        Log.d("grila", listViewRaspunsGrila.getVisibility()+"");
//        Log.d("deschis", listViewRaspunsDeschis.getVisibility()+"");
//        if(listViewRaspunsGrila.getVisibility() == View.VISIBLE){
//            listViewRaspunsDeschis.setVisibility(View.GONE);
//        }
//        else if(listViewRaspunsDeschis.getVisibility() == View.VISIBLE){
//            listViewRaspunsGrila.setVisibility(View.GONE);
//        }
    }

    public void adaugaTest(View view)
    {
        Intent intentAd = new Intent(AdaugareTest.this, ContProfesor.class);
        startActivityForResult(intentAd, 5);
    }
}
