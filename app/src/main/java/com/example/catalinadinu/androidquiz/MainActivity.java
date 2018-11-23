package com.example.catalinadinu.androidquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button inregistrare = findViewById(R.id.id_inregistrare);
        Button conectare = findViewById(R.id.id_conectare);

        inregistrare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentInregristrare = new Intent(MainActivity.this, Inregistrare.class);
                startActivityForResult(intentInregristrare, 1);
            }
        });

        conectare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentConectare = new Intent(MainActivity.this, Conectare.class);
                startActivityForResult(intentConectare, 2);
            }
        });


    }
}
