package com.example.android.band;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class Intro extends Welcome {

    // Globals String Variables
    public static String favSong;
    public static String favBand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);

        // Record and Save Favorite Band & Favorite Song User Input

        EditText favoriteSong = findViewById(R.id.favSong);
        EditText favoriteBand = findViewById(R.id.favBand);

        favSong = favoriteSong.getText().toString().toLowerCase();
        favBand = favoriteBand.getText().toString().toLowerCase();

        // go to bands intent
        ImageView bands = findViewById(R.id.bands);
        bands.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent bandsList = new Intent(getApplicationContext(), Bands.class);
                startActivity(bandsList);
            }
        });
    }
}
