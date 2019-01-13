package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.catalinadinu.androidquiz.clase.HttpHandler;
import com.example.catalinadinu.androidquiz.clase.UtilizatorProfesor;
import com.example.catalinadinu.androidquiz.clase.UtilizatorStudent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ConectareStudent extends Activity {

    private TextView email;
    private TextView parola;
    private TextView cod;
    private TextView datele;
    private Button conectareStud;
    private UtilizatorStudent utilizatorStudent;
    public static List<UtilizatorStudent> studentiConectare = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conectare_student);

        email = findViewById(R.id.id_mailConectareStud);
        parola = findViewById(R.id.id_parolaConectareStud);
        cod = findViewById(R.id.id_codConectareStud);
        conectareStud = findViewById(R.id.id_butonConectareStud);

        ConectareStudentiJSON cc = new ConectareStudentiJSON();
        cc.execute();
        datele = findViewById(R.id.datee);
    }

    private class ConectareStudentiJSON extends AsyncTask<Void,Void,Void> {

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            Toast.makeText(getApplicationContext(),"Datele din JSON se descarca!",Toast.LENGTH_SHORT).show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            HttpHandler sh = new HttpHandler();
            String url = "https://pastebin.com/raw/i3PFMRNx";
            String jsonStr = sh.makeServiceCall(url);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObject = new JSONObject(jsonStr);
                    JSONArray studenti = jsonObject.getJSONArray("student");

                    for (int i = 0; i < studenti.length(); i++) {
                        JSONObject profObj = studenti.getJSONObject(i);
                        String email = profObj.getString("email");
                        String parola = profObj.getString("parola");
                        String cod = profObj.getString("cod");
                        UtilizatorStudent student = new UtilizatorStudent(email, parola, cod);
                        studentiConectare.add(student); //?
                        //Log.d("plss", "Date descarcate "+student.afisareConectare());
                        //Log.d("lista", studentiConectare+"");
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


    public void saveInfoo(View view){
        SharedPreferences sharePref = getSharedPreferences("userinfo",Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharePref.edit();
        editor.putString("email", email.getText().toString());
        editor.putString("parola", parola.getText().toString());
        editor.putString("cod", cod.getText().toString());
        editor.apply();

        Toast.makeText(this, "Date salvate!", Toast.LENGTH_LONG).show();
        String email = sharePref.getString("email", "");
        String parola = sharePref.getString("parola", "");
        String cod = sharePref.getString("cod", "");

        datele.setText(email + " "+ parola + " "+ cod);

    }


    public void trimiteNumeCont(){
        String codStud = cod.getText().toString();

        Intent intent = new Intent(ConectareStudent.this, ContStudent.class);
        intent.putExtra("COD", codStud);
        startActivity(intent);
    }

    public void conectareStudent(View view){
        if(email != null && parola != null && cod != null){
            if("".equals(email.getText().toString()) || "".equals(parola.getText().toString()) || "".equals(cod.getText().toString())){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Eroare");
                builder.setMessage("Toate câmpurile sunt obligatorii!");
                builder.setPositiveButton("OK", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            else {
                for(UtilizatorStudent stud : studentiConectare) {
                    if (!email.getText().toString().equals(stud.getEmail()) &&
                            !parola.getText().toString().equals(stud.getParola()) &&
                            !cod.getText().toString().equals(stud.getCodStudent())) {
                        Log.d("email", email.getText().toString() + "+" + stud.getEmail());
                        Toast.makeText(getApplicationContext(), "Datele nu sunt introduse corect!", Toast.LENGTH_SHORT).show();
                    }
//                    else if(){
//                        Toast.makeText(getApplicationContext(), "Parola nu este corecta!", Toast.LENGTH_SHORT).show();
//                    }
//                    else if(){
//                        Toast.makeText(getApplicationContext(), "Codul nu este corect!", Toast.LENGTH_SHORT).show();
//                    }
                    else if (email.getText().toString().equals(stud.getEmail()) &&
                            parola.getText().toString().equals(stud.getParola()) &&
                            cod.getText().toString().equals(stud.getCodStudent())) {
                        Intent intentConectareStud = new Intent(ConectareStudent.this, ContStudent.class);
                        startActivityForResult(intentConectareStud, 6);
                        trimiteNumeCont();
                    }

                }
            }

        }
    }
}
