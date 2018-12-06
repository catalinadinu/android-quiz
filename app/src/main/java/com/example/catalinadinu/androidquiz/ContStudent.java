package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.catalinadinu.androidquiz.clase.Materie;
import com.example.catalinadinu.androidquiz.clase.StudentiAdaptorPersonalizat;
import com.example.catalinadinu.androidquiz.clase.Test;
import com.example.catalinadinu.androidquiz.clase.TesteAdaptorPersonalizat;
import com.example.catalinadinu.androidquiz.clase.UtilizatorStudent;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.view.Menu;

public class ContStudent extends Activity {

    private Spinner spinnerMaterie;
    private ProgressBar progressBar;
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
        progressBar = findViewById(R.id.progressBar);
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

        //citesteJson();
    }

//    public void citesteJson() {
//        Log.d("intra", "aici intra");
//        List<Materie> materii = new ArrayList<>();
//        Log.d("intra2", "si aici intra");
//        String address = "https://api.myjson.com/bins/10l6xq";
//        HttpURLConnection connection = null;
//            try {
//                URL url = new URL(address);
//                connection = (HttpURLConnection) url.openConnection();
//                InputStream inputStream = connection.getInputStream();
//                BufferedReader reader =
//                        new BufferedReader(new InputStreamReader(inputStream));
//                StringBuilder stringBuilder = new StringBuilder();
//                String line = null;
//                while ((line = reader.readLine()) != null) {
//                    stringBuilder.append(line);
//                }
//                String result = stringBuilder.toString();
//                Log.d("JSON", result);
//                Materie materie = new Materie();
//                JSONObject jsonObject = new JSONObject(result);
//                //JSONObject mainObject = jsonObject.getJSONObject("main");
//                Log.d("MA-TA", "PISPETINE");
//                materie.denumire = jsonObject.getString("denumire");
//                //JSONArray weatherArray = jsonObject.getJSONArray("weather");
//                //JSONObject weatherObject = (JSONObject) weatherArray.get(0);
//                materie.an = jsonObject.getString("an");
//                materie.tipExaminare = jsonObject.getString("tipExaminare");
//                materie.semestru = jsonObject.getString("semestru");
//                materii.add(materie);
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                if (connection != null) {
//                    connection.disconnect();
//                }
//            }
//
//        ArrayAdapter<Materie> adaptor = new ArrayAdapter<>(ContStudent.this, R.layout.support_simple_spinner_dropdown_item, materii);
//        spinnerMaterie.setAdapter(adaptor);
//    }


    public void IncepeTest(View view)
    {
        incepeTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valoareSpinner = spinnerMaterie.getSelectedItem().toString();
                if(!("".equals(valoareSpinner))){
                    Intent intentIncepeTest = new Intent(ContStudent.this, TestStudent.class);
                    startActivityForResult(intentIncepeTest, 7);}
            }
        });
    }

    public void setariContStudent(View view){
        Intent intentAd = new Intent(ContStudent.this, setariContStudent.class);
        startActivityForResult(intentAd, 19);
    }



//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if(item.getItemId() == R.id.schimbaParola)
//        {
//            Intent intentSchimbareParola = new Intent(ContStudent.this, setariContStudent.class);
//            startActivityForResult(intentSchimbareParola, 18);
//        }
//        else if(item.getItemId() == R.id.deconectare){
//            Intent intentDeconectare = new Intent(ContStudent.this, MainActivity.class);
//            startActivityForResult(intentDeconectare, 0);
//        }
//        else{
//            return super.onOptionsItemSelected(item);
//        }
//        return true;
//    }

    //clasa cu metode asincrone in care citim json-ul si adaugam materiilor citite in spinner
//    class MaterieTest extends AsyncTask<String, Integer, Materie> { //param, progress, result
//
//        @Override
//        protected void onPreExecute() {
//            if(progressBar != null) {
//                progressBar.setVisibility(View.VISIBLE);
//            }
//        }
//
//
//        @Override
//        protected Materie doInBackground(String... strings){
//            return cc;
//        }
//
//        @Override
//        protected void onPostExecute(Materie materie) {
//            if(progressBar != null) {
//                progressBar.setVisibility(View.INVISIBLE);
//            }
//
//
//        }
//    }
}
