package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConectareStudent extends Activity {

    private Button conectareStud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conectare_student);


        conectareStud = findViewById(R.id.id_butonConectareStud);

    }

    public void conectareStudent(View view){
        conectareStud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentConectareStud = new Intent(ConectareStudent.this, ContStudent.class);
                startActivityForResult(intentConectareStud, 5);
            }
        });
    }


}
