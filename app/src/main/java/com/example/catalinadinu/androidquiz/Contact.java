package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Contact extends Activity {
    private ImageButton deschideMaps;
    private ImageButton veziSite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        veziSite = findViewById(R.id.veziSite);

        veziSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent implicitIntent =
                        new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://csie.ase.ro/"));
                startActivity(implicitIntent);
            }
        });
    }


}
