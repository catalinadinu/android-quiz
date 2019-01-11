package com.example.catalinadinu.androidquiz;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.example.catalinadinu.androidquiz.clase.DatabaseContract;
import com.example.catalinadinu.androidquiz.clase.ProfPartajare;
import com.example.catalinadinu.androidquiz.clase.ProfesorBD;

public class PartajareCatre extends Activity {
    private Spinner spinnerMaterieProf;
    private ListView listaProfi;
    private ProgressBar progressBar;
    ArrayList<ProfPartajare> profesori = new ArrayList<ProfPartajare>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partajare_catre);

        spinnerMaterieProf = findViewById(R.id.spinnerMaterieProf);
        listaProfi = findViewById(R.id.LVpartajareCatre);
        progressBar = findViewById(R.id.progressBar);

//        UtilizatorProfesor[] profesor = new UtilizatorProfesor[]{
//                new UtilizatorProfesor("Dumitrascu", "Cristina"),
//                new UtilizatorProfesor("Sandoiu", "Stefan"),
//                new UtilizatorProfesor("Matei", "Roxana"),
//                new UtilizatorProfesor("Cristescu", "Daniel"),
//                new UtilizatorProfesor("Nedelea", "Alexandru")
//        };
//
//        ArrayList<UtilizatorProfesor> listaProfesori = new ArrayList<>();
//        listaProfesori.addAll(Arrays.asList(profesor));
//        ArrayAdapter<UtilizatorProfesor> adaptorProfesori = new ArrayAdapter<UtilizatorProfesor>(this, android.R.layout.simple_list_item_1,listaProfesori);
//        listaProfi.setAdapter(adaptorProfesori);

        List<String> materiiProf = new ArrayList<>();
        materiiProf.add("BTI");
        materiiProf.add("POO");
        materiiProf.add("PAW");
        materiiProf.add("JAVA");
        materiiProf.add("PEAG");
        ArrayAdapter<String> adaptor = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, materiiProf);
        spinnerMaterieProf.setAdapter(adaptor);


        //AfisareProfesori a = new AfisareProfesori();
        //a.execute();

        spinnerMaterieProf.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                for(ProfPartajare p : profesori) {
//                    if (spinnerMaterieProf.getSelectedItem().toString().equals(p.materie)) {
//
//                    }
//                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        listaProfi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(PartajareCatre.this, ContProfesor.class);
                startActivityForResult(intent, 5);
                Toast.makeText(PartajareCatre.this, "Testul a fost trimis cu succes!", Toast.LENGTH_SHORT);
            }
        });

        DatabaseContract contract = new DatabaseContract(this);
        Cursor result  = contract.getProfDataCursor(); // Here you take the cursor from DemoDatabase

        // The input for a simple cursor adapter

        // Cursor which takes the attributes from the Contract (DemoDatabase)
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter
                (//simple_list_item_2 because you give it 2 thingies to display --- ID & Faculty
                        this,android.R.layout.simple_list_item_2,result,
                        new String[]{ProfesorBD.COLUMN_ID,ProfesorBD.COLUMN_LAST_NAME},
                        new int[]{android.R.id.text1,android.R.id.text2} // text 1 & text 2 because in a list view you can display 2 thingies
                );

        listaProfi.setAdapter(simpleCursorAdapter); // you link the adapter to the list view
    }


//    class AfisareProfesori extends AsyncTask<Void, Integer, ProfPartajare> {
//
//        @Override
//        protected void onPreExecute() {
//            if (progressBar != null) {
//                progressBar.setVisibility(View.VISIBLE);
//            }
//        }
//
//        @Override
//        protected ProfPartajare doInBackground(Void... voids) {
//                String address = "http://api.myjson.com/bins/eiftq";
//                HttpURLConnection connection = null;
//                try {
//                    URL url = new URL(address);
//                    connection = (HttpURLConnection) url.openConnection();
//                    InputStream inputStream = connection.getInputStream();
//                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//                    StringBuilder stringBuilder = new StringBuilder();
//                    String line = null;
//                    while ((line = reader.readLine()) != null) {
//                        stringBuilder.append(line);
//                    }
//                    String result = stringBuilder.toString();
//                    Log.d("JSON", result);
//                    ProfPartajare profesor = new ProfPartajare();
//                    JSONObject jsonObject = new JSONObject(result);
//                    profesor.nume = jsonObject.getString("nume");
//                    profesor.prenume = jsonObject.getString("prenume");
//                    profesor.materie = jsonObject.getString("materie");
//                    profesori.add(profesor);
//                    return profesor;
//
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                } finally {
//                    if (connection != null) {
//                        connection.disconnect();
//                    }
//                }
//            return null;
//        }
//
//
//        @Override
//        protected void onPostExecute(ProfPartajare profPartajare) {
//            if(progressBar != null) {
//                progressBar.setVisibility(View.INVISIBLE);
//            }
//
//            ArrayAdapter<ProfPartajare> adaptor = new ArrayAdapter<>(PartajareCatre.this, android.R.layout.simple_list_item_1,profesori);
//            listaProfi.setAdapter(adaptor);
//        }
//    }
}


