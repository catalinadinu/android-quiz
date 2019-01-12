package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.example.catalinadinu.androidquiz.clase.HttpHandler;
import com.example.catalinadinu.androidquiz.clase.ProfPartajare;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PartajareCatre extends Activity {
    private ListView listaProfi;
    private ProgressBar progressBar;
    List<ProfPartajare> profesorii = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partajare_catre);

        listaProfi = findViewById(R.id.LVpartajareCatre);
        progressBar = findViewById(R.id.progressBar);

        AfisareProfesori a = new AfisareProfesori();
        a.execute();


        listaProfi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(PartajareCatre.this, ContProfesor.class);
                startActivityForResult(intent, 5);
                Toast.makeText(PartajareCatre.this, "Testul a fost trimis cu succes!", Toast.LENGTH_SHORT);
            }
        });

        //afisare din baza de date 
//        ContractBazaDate contract = new ContractBazaDate(this);
//        Cursor result  = contract.getProfDataCursor(); // Here you take the cursor from DemoDatabase 
//        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter 
//                (//simple_list_item_2 because you give it 2 thingies to display --- ID & Faculty 
//                        this,android.R.layout.simple_list_item_2,result, 
//                        new String[]{ProfesorBD.COLUMN_ID,ProfesorBD.COLUMN_LAST_NAME}, 
//                        new int[]{android.R.id.text1,android.R.id.text2} // text 1 & text 2 because in a list view you can display 2 thingies 
//                ); 
// 
//        listaProfi.setAdapter(simpleCursorAdapter); // you link the adapter to the list view 
    }


    class AfisareProfesori extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            if (progressBar != null) {
                progressBar.setVisibility(View.VISIBLE);
            }
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            String url = "https://pastebin.com/raw/rpakVWiX";
            String jsonStr = sh.makeServiceCall(url);

            if (jsonStr != null)
            {
                try {
                    JSONObject jsonObject = new JSONObject(jsonStr);
                    JSONArray profesori = jsonObject.getJSONArray("profesor");

                    for(int i = 0; i < profesori.length(); i++){
                        JSONObject profObj = profesori.getJSONObject(i);
                        ProfPartajare profesor = new ProfPartajare();
                        profesor.nume = profObj.getString("nume");
                        profesor.prenume = profObj.getString("prenume");
                        profesor.materie = profObj.getString("materie");
                        profesorii.add(profesor);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            else {
                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        Toast.makeText(getApplicationContext(),
                                "Nu se poate parsa fisierul JSON!",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }


        @Override
        protected void onPostExecute(Void result) {
            if(progressBar != null) {
                progressBar.setVisibility(View.INVISIBLE);
            }

            ArrayAdapter<ProfPartajare> adaptor = new ArrayAdapter<>(PartajareCatre.this, android.R.layout.simple_list_item_1,profesorii);
            listaProfi.setAdapter(adaptor);
        }
    }
} 
 
 