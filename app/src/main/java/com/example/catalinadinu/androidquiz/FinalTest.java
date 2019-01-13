package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Toast;

public class FinalTest extends Activity {

    private RatingBar rating;
    private ImageButton rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_test);

        rating = findViewById(R.id.ratingBarDificultate);
        rate =  findViewById(R.id.butonSubmitFinalizareTest);


    }

    public void rateMe(View view){

        Toast.makeText(FinalTest.this,
                String.valueOf(rating.getRating()), Toast.LENGTH_LONG).show();

        Intent intent = new Intent(FinalTest.this, ContStudent.class);
        startActivityForResult(intent, 6);
    }


}
