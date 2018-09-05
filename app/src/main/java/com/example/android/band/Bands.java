package com.example.android.band;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Bands extends Intro {

    // Indexing Band Id in Relation to Button Click
    public static int bandId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bands);

        bandsWithQuiz();
        bandsWithoutQuiz();

    }

    private void bandsWithQuiz() {

        ImageView visitBand1 = findViewById(R.id.link1);
        ImageView activeBand[] = {visitBand1};

        int i;

        for (i = 0; i < activeBand.length; i++) {
            activeBand[i].setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent bandInfo = new Intent(getApplicationContext(), AboutBand.class);
                    startActivity(bandInfo);
                }
            });
        }
    }

    /*
     * Other Bands
     * Of Course they Don't Have a Quiz
     * */
    //TODO :7 Since you are a new Android learner this here might be bad, I can try to show you other ways
    // TODO on how you can implement this here.
    public void bandsWithoutQuiz() {
        ImageView visitBand2 = findViewById(R.id.link2);
        ImageView visitBand3 = findViewById(R.id.link3);
        ImageView visitBand4 = findViewById(R.id.link4);
        ImageView visitBand5 = findViewById(R.id.link5);
        ImageView visitBand6 = findViewById(R.id.link6);
        ImageView visitBand7 = findViewById(R.id.link7);
        ImageView visitBand8 = findViewById(R.id.link8);
        ImageView visitBand9 = findViewById(R.id.link9);
        ImageView visitBand10 = findViewById(R.id.link10);
        ImageView visitBand11 = findViewById(R.id.link11);
        ImageView visitBand12 = findViewById(R.id.link12);
        ImageView visitBand13 = findViewById(R.id.link13);
        ImageView visitBand14 = findViewById(R.id.link14);
        ImageView visitBand15 = findViewById(R.id.link15);
        ImageView visitBand16 = findViewById(R.id.link16);
        ImageView visitBand17 = findViewById(R.id.link17);
        ImageView visitBand18 = findViewById(R.id.link18);
        ImageView visitBand19 = findViewById(R.id.link19);
        ImageView visitBand20 = findViewById(R.id.link20);
        ImageView visitBand21 = findViewById(R.id.link21);
        ImageView visitBand22 = findViewById(R.id.link22);
        ImageView visitBand23 = findViewById(R.id.link23);
        ImageView visitBand24 = findViewById(R.id.link24);
        ImageView visitBand25 = findViewById(R.id.link25);
        ImageView visitBand26 = findViewById(R.id.link26);
        ImageView visitBand27 = findViewById(R.id.link27);
        ImageView visitBand28 = findViewById(R.id.link28);
        ImageView visitBand29 = findViewById(R.id.link29);
        ImageView visitBand30 = findViewById(R.id.link30);
        final ImageView activeBands[] = {visitBand2};
        final ImageView inactiveBands[] = {visitBand3, visitBand4, visitBand5, visitBand6, visitBand7, visitBand8, visitBand9, visitBand10, visitBand11, visitBand12, visitBand13, visitBand14, visitBand15, visitBand16, visitBand17, visitBand18, visitBand19, visitBand20, visitBand21, visitBand22, visitBand23, visitBand24, visitBand25, visitBand26, visitBand27, visitBand28, visitBand29, visitBand30};


        // Other Bands With Content

        for (int x = 0; x < activeBands.length; x++) {
            activeBands[x].setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    // Open a new view
                    Intent bandInfo = new Intent(getApplicationContext(), BandsInfo.class);
                    startActivity(bandInfo);
                }
            });

            // Setting the ID
            if (activeBands[x] == visitBand2) {
                bandId = 1;
            } else if (activeBands[x] == visitBand3) {
                bandId = 2;
            } else if (activeBands[x] == visitBand4) {
                bandId = 3;
            } else if (activeBands[x] == visitBand5) {
                bandId = 4;
            } else if (activeBands[x] == visitBand6) {
                bandId = 5;
            }
        }
        // Bands Without Content

        for (int i = 0; i < inactiveBands.length; i++) {
            inactiveBands[i].setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Context context = getApplicationContext();
                    CharSequence text = "Content Unavailable. Try Another!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            });
        }
    }

}