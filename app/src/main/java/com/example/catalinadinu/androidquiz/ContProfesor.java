package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ContProfesor extends AppCompatActivity {


    private Button adQuiz;
    private Button progres;
    private Button feedbackk;
    private ListView listaQuiz;
    //asta e la plezneala sa vedem daca merge, inlocuim pe urma cu un ArrayList
    String[] listaNumeQuiz = {"Quiz 1","Quiz 2","Quiz 3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cont_profesor);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_cont_profesor, listaNumeQuiz);

        adQuiz = findViewById(R.id.adQuiz);
        progres = findViewById(R.id.veziProgres);
        feedbackk = findViewById(R.id.feedback);
        listaQuiz = (ListView)findViewById(R.id.listaQuizProf);
        listaQuiz.setAdapter(adapter);

//        listaQuiz.setOnItemClickListener();

//        list.setOnItemClickListener(new AdapterView.onItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
//                Intent appInfo = new Intent(YourActivity.this, ApkInfoActivity.class);
//                startActivity(appInfo);
//            }
//        });

//        ListView listView = (ListView) findViewById(R.id.mobile_list);
//        listView.setAdapter(adapter);
    }



    public void adaugareTest(View view){
        adQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAd = new Intent(ContProfesor.this, AdaugareTest.class);
                startActivityForResult(intentAd, 5);
            }
        });
    }

    public void VeziProgres(View view){
        progres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentProgres = new Intent(ContProfesor.this, Progres.class);
                startActivityForResult(intentProgres, 5);
            }
        });
    }

    public void FormFeedback(View view){
        feedbackk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFeedback = new Intent(ContProfesor.this, FormularFeedback.class);
                startActivityForResult(intentFeedback, 5);
            }
        });
    }


}
