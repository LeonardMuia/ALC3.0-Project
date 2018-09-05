package com.example.android.band;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class AboutBand extends Bands {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bandinfo);

        // Back Button

        ImageView backBtn = findViewById(R.id.backButton1);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToBands = new Intent(getApplicationContext(), Bands.class);
                startActivity(backToBands);
            }
        });

        // Quiz Button
        goToQuiz();

    }

    // Event Method for the Quiz Button

    private void goToQuiz() {
        ImageView visitBand = findViewById(R.id.quizButton1);

        visitBand.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent takeQuiz = new Intent(getApplicationContext(), Quiz.class);
                startActivity(takeQuiz);

                Context context = getApplicationContext();
                CharSequence text = "Pick an Answer to Advance Next Question";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }

}
