package com.example.android.band;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Get Started Button Intent
        ImageView start = findViewById(R.id.getStarted);
        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intro = new Intent(getApplicationContext(), Intro.class);
                startActivity(intro);
            }
        });
    }
}