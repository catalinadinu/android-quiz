package com.example.catalinadinu.androidquiz;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

public class Contact extends FragmentActivity implements OnMapReadyCallback {

    private ImageButton veziSite;
    private GoogleMap mMap;
    private static final String TAG = Contact.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

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

    @Override
    public void onMapReady(GoogleMap googleMap) {

        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.style_json));

            if (!success) {
                Log.e(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Can't find style. Error: ", e);
        }

        mMap = googleMap;

        LatLng csie = new LatLng(44.447867, 26.0991195);
        mMap.addMarker(new MarkerOptions().position(csie).title("CSIE"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(csie));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(18.0f));
    }

}
