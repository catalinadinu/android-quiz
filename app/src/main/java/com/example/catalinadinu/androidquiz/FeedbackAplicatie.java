package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Toast;

public class FeedbackAplicatie extends Activity {

    private ImageButton butonBackfeedbackAplicatie;
    private RatingBar ratingBarFDBAplicatie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_aplicatie);

        butonBackfeedbackAplicatie = findViewById(R.id.feedbackBackButton);
        ratingBarFDBAplicatie = findViewById(R.id.ratingBarFDBAplicatie);


        butonBackfeedbackAplicatie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FeedbackAplicatie.this,
                String.valueOf("Scorul oferit aplicației: "+ratingBarFDBAplicatie.getRating()), Toast.LENGTH_LONG).show();

        Intent intent = new Intent(FeedbackAplicatie.this, MainActivity.class);
        startActivityForResult(intent, 0);
            }
        });
    }

//    public void backToMain(View view){
//
//        Toast.makeText(FeedbackAplicatie.this,
//                String.valueOf("Scorul oferit aplicației: "+ratingBarFDBAplicatie.getRating()), Toast.LENGTH_LONG).show();
//
//        Intent intent = new Intent(FeedbackAplicatie.this, MainActivity.class);
//        startActivityForResult(intent, 0);
//    }
}
