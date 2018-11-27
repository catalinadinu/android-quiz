package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class FeedbackAplicatie extends Activity {

    private ImageButton butonBackfeedbackAplicatie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_aplicatie);

        butonBackfeedbackAplicatie = findViewById(R.id.feedbackBackButton);
    }

    public void backToMain(View view){
        Intent intent = new Intent(FeedbackAplicatie.this, MainActivity.class);
        startActivityForResult(intent, 0);
    }
}
