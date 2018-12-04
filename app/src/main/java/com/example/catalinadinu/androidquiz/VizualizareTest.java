package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class VizualizareTest extends Activity {

    //va fi legat de un item din listview cand acesta va fi populat
    private ImageButton partajareTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vizualizare_test);

        partajareTest = findViewById(R.id.partajareTest);
    }

    public void partajare(View view)
    {
        Intent intentPartajare = new Intent(VizualizareTest.this, PartajareCatre.class);
        startActivityForResult(intentPartajare,16);
    }
}
