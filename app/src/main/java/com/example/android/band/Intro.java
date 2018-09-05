package com.example.android.band;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Intro extends Welcome {

    // Globals String Variables
    public static String favSong;
    public static String favBand;

    @BindView(R.id.favSong)
    EditText favoriteSong;
    @BindView(R.id.favBand)
    EditText favoriteBand;
    @BindView(R.id.bands)
    ImageView bands;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);
        ButterKnife.bind(this);

        // Record and Save Favorite Band & Favorite Song User Input


        favSong = favoriteSong.getText().toString().toLowerCase();
        favBand = favoriteBand.getText().toString().toLowerCase();

        // go to bands intent

        bands.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent bandsList = new Intent(getApplicationContext(), Bands.class);
                startActivity(bandsList);
            }
        });
    }
}
