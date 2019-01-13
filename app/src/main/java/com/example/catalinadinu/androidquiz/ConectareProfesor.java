package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.catalinadinu.androidquiz.clase.ContractBazaDate;
import com.example.catalinadinu.androidquiz.clase.HttpHandler;
import com.example.catalinadinu.androidquiz.clase.ProfesorBD;
import com.example.catalinadinu.androidquiz.clase.UtilizatorProfesor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ConectareProfesor extends Activity {

    private TextView emailProf;
    private TextView parolaProf;
    private TextView cod;
    private Button conectareProf;
    private UtilizatorProfesor utilProf;
    public static List<UtilizatorProfesor> profesoriConectare = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conectare_profesor);

        emailProf = findViewById(R.id.id_emailProfConectare);
        parolaProf =  findViewById(R.id.id_parolaProfConectare);
        cod = findViewById(R.id.id_codProfConectare);
        conectareProf = findViewById(R.id.id_butonConectare);

        ConectareProfiJSON c = new ConectareProfiJSON();
        c.execute();
    }

    public void trimiteCodCont(){
        String codProf = cod.getText().toString();

        Intent intent = new Intent(ConectareProfesor.this, ContProfesor.class);
        intent.putExtra("COD", codProf);
        startActivity(intent);
    }

//    public void verificainBD(){
//        String emailTextView = emailProf.getText().toString();
//        //String parolaTextView = parolaProf.getText().toString();
//
//        ContractBazaDate db = new ContractBazaDate(this);
//        Cursor cursor = db.getInregistrareDataProfCursor(emailTextView);
//        Log.d("plm", cursor.getCount()+"");
//
//        if(cursor.getCount() < 1){
//            Toast.makeText(this, "Nu se poate!", Toast.LENGTH_LONG);
//        }
//        else {
//            cursor.moveToFirst();
//            String emailProfesor = cursor.getString(cursor.getColumnIndex(ProfesorBD.COLUMN_EMAIL));
//            String parolaProfesor = cursor.getString(cursor.getColumnIndex(ProfesorBD.COLUMN_PASSWORD));
//            if (emailProf.getText().toString().equals(emailProfesor) && parolaProf.getText().toString().equals(parolaProfesor)) {
//                Intent intentConectareProf = new Intent(ConectareProfesor.this, ContProfesor.class);
//                startActivityForResult(intentConectareProf, 5);
//                trimiteCodCont();
//            } else if (!(emailProf.getText().toString().equals(emailProfesor))) {
//                Toast.makeText(getApplicationContext(), "Emailul nu coincide cu cel din contul inregistrat!", Toast.LENGTH_LONG);
//            } else if (!(parolaProf.getText().toString().equals(parolaProfesor))) {
//                Toast.makeText(getApplicationContext(), "Parola nu coincide cu cea din contul inregistrat!", Toast.LENGTH_LONG);
//            }
//        }
//    }

    private class ConectareProfiJSON extends AsyncTask<Void,Void,Void> {

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            Toast.makeText(getApplicationContext(),"Datele din JSON se descarca!",Toast.LENGTH_SHORT).show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            HttpHandler sh = new HttpHandler();
            String url = "https://pastebin.com/raw/viSk5R02";
            String jsonStr = sh.makeServiceCall(url);

            //Log.d("cacatttttt", "am ajuns aici " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObject = new JSONObject(jsonStr);
                    JSONArray profesori = jsonObject.getJSONArray("profesor");

                    for (int i = 0; i < profesori.length(); i++) {
                        JSONObject profObj = profesori.getJSONObject(i);
                        //profesor.setEmail(profObj.getString("email"));
                        String email = profObj.getString("email");
                        //Log.d("plm", email);
                        String parola = profObj.getString("parola");
                        //Log.d("plm", parola);
                        String cod = profObj.getString("cod");
                        //Log.d("plm", cod);
                       // profesor.setCod(profObj.getString("cod"));
                        UtilizatorProfesor profesor = new UtilizatorProfesor(email, parola, cod);
                        profesoriConectare.add(profesor); //?
                        Log.d("plss", "Date descarcate "+profesor.afisareConectare());
                        Log.d("lista", profesoriConectare+"");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Nu se poate parsa fisierul JSON!",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result)
        {
            super.onPostExecute(result);
            Toast.makeText(getApplicationContext(), "Fisierul JSON parsat!", Toast.LENGTH_SHORT).show();
        }


    }



    public void conectareProfesor(View view) {
        if (emailProf != null && parolaProf != null && cod != null) {
            if ("".equals(cod.getText().toString()) ||
                    "".equals(emailProf.getText().toString()) || "".equals(parolaProf.getText().toString())) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Eroare");
                builder.setMessage("Toate câmpurile sunt obligatorii!");
                builder.setPositiveButton("OK", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            else {

                for(UtilizatorProfesor prof : profesoriConectare){
                    if(!emailProf.getText().toString().equals(prof.getEmail()) &&
                            !parolaProf.getText().toString().equals(prof.getParola()) &&
                            !cod.getText().toString().equals(prof.getCod())){
                        Log.d("email", emailProf.getText().toString() +"+"+prof.getEmail());
                        Toast.makeText(getApplicationContext(), "Datele nu sunt introduse corect!", Toast.LENGTH_SHORT).show();
                    }
//                    else if(){
//                        Toast.makeText(getApplicationContext(), "Parola nu este corecta!", Toast.LENGTH_SHORT).show();
//                    }
//                    else if(){
//                        Toast.makeText(getApplicationContext(), "Codul nu este corect!", Toast.LENGTH_SHORT).show();
//                    }
                    else if(emailProf.getText().toString().equals(prof.getEmail()) &&
                            parolaProf.getText().toString().equals(prof.getParola()) && cod.getText().toString().equals(prof.getCod())){
                        Log.d("caca", emailProf.getText().toString()+""+ emailProf.getText().toString().equals(prof.getEmail()+""));

                        Toast.makeText(getApplicationContext(), "Cont corect!", Toast.LENGTH_SHORT).show();
                        Intent intentConectareProf = new Intent(ConectareProfesor.this, ContProfesor.class);
                        startActivityForResult(intentConectareProf, 5);
                        trimiteCodCont();
                    }
                }
            }
        }
    }


}
