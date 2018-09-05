package com.example.android.band;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Score extends Quiz {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);

        // Back Button

        ImageView backBtn = findViewById(R.id.backButton3);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToBands = new Intent(getApplicationContext(), Bands.class);
                startActivity(backToBands);
            }
        });

        // Update Stats Values
        displayStats();

        // Submit Button
        goToAbout();
    }

    public void displayStats() {

        // Update Correct Answers
        TextView correctAnswers = findViewById(R.id.correctAnswers);
        correctAnswers.setText("" + totalPointsScored());

        // Update Questions Done
        TextView questionsDone = findViewById(R.id.quizTaken);
        questionsDone.setText("" + 10);
        questionsDone.toString();

        // Update Percentage
        TextView percentage = findViewById(R.id.percentage);
        percentage.setText(percent());
    }

    // Getting Globals
    /*final int scoreTotal = Globals.getTotalPoints();
    final int questionsTotal = Globals.getQuestionsDone();*/

    public String totalPointsScored() {
        String scoredPoints = "" + totalPoints;
        return scoredPoints;
    }

    public String percent() {
        int percentage = (100 / 10) * totalPoints;
        String percentageCompute = "" + percentage;
        return percentageCompute;
    }

    private void goToAbout() {
        ImageView submitBtn = findViewById(R.id.toAbout);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toAbout = new Intent(getApplicationContext(), AboutApp.class);
                startActivity(toAbout);
            }
        });
    }

}


