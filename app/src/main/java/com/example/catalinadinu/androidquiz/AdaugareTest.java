package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdaugareTest extends Activity {

    private Button adTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adaugare_test);

        adTest = findViewById(R.id.adTestButton);
    }

    public void adaugaTest(View view)
    {
        Intent intentAd = new Intent(AdaugareTest.this, ContProfesor.class);
        startActivityForResult(intentAd, 5);
    }
}
