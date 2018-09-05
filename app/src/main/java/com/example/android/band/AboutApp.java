package com.example.android.band;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutApp extends Score {

    //TODO : 4 this makes it easier instead of having many casts
    @BindView(R.id.backButton6)
    ImageView backBtn;

    @BindView(R.id.shareButton)
    ImageView shareBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutapp);

        //TODO : 3 hook the butterknife library to the view
        ButterKnife.bind(this);
        // Back to Bands List

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToBands = new Intent(getApplicationContext(), Bands.class);
                startActivity(backToBands);
            }
        });

        // Share Button
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = "Alas! Nothing Happened";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

    }
}
