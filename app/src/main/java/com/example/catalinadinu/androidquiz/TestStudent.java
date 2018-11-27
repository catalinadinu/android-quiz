package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TestStudent extends Activity {

    private Button butonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_student);

        butonSubmit = findViewById(R.id.butonSubmit);
    }

    public void butonSubmit(View view){
        Intent intentSubmit = new Intent(TestStudent.this, FinalTest.class);
        startActivityForResult(intentSubmit, 12);
    }
            //6750
}
