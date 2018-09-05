package com.example.android.band;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BandsInfo extends Bands {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otherbands);

        // Back Button

        ImageView backBtn = findViewById(R.id.backButton5);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToBands = new Intent(getApplicationContext(), Bands.class);
                startActivity(backToBands);
            }
        });

        // Remove Quiz Button
        ImageView quizButton = findViewById(R.id.quizButton2);
        quizButton.setVisibility(View.GONE);

        whichBand();
    }

    // Changing Band Content

    private void whichBand() {
        // Change Content Depending on the Click Count. Which refers to the Band Id as declared


        Context context = getApplicationContext();
        CharSequence text = "For the Quiz, visit 3 Doors Down";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        ImageView bandImage = findViewById(R.id.headerBandImage);
        bandImage.setImageResource(R.drawable.fivesecondsofsummer);

        TextView bandName = findViewById(R.id.titleA);
        bandName.setText(R.string.bandName1);

        TextView bandInfo = findViewById(R.id.description);
        bandInfo.setText(R.string.bandInfo1);

        TextView bandMember1 = findViewById(R.id.member1);
        TextView bandMember2 = findViewById(R.id.member2);
        TextView bandMember3 = findViewById(R.id.member3);
        TextView bandMember7 = findViewById(R.id.member7);
        TextView bandMember5 = findViewById(R.id.member5);
        TextView bandMember6 = findViewById(R.id.member6);
        TextView bandMember4 = findViewById(R.id.member4);
        TextView bandMember8 = findViewById(R.id.member8);
        bandMember1.setText(R.string.bandMember1);
        bandMember2.setText(R.string.bandMember2);
        bandMember3.setText(R.string.bandMember3);
        bandMember7.setText(R.string.bandMember4);

        TextView remove[] = {bandMember5, bandMember6, bandMember4, bandMember8};
        for (int i = 0; i < remove.length; i++) {
            remove[i].setVisibility(View.GONE);
        }

        TextView success = findViewById(R.id.successStory);
        success.setText(R.string.band1Success);

        TextView album1 = findViewById(R.id.album1);
        TextView album2 = findViewById(R.id.album2);
        TextView album3 = findViewById(R.id.album3);
        TextView album4 = findViewById(R.id.album4);
        TextView album5 = findViewById(R.id.album5);
        TextView album6 = findViewById(R.id.album6);

        album1.setText(R.string.bandAlbum1);
        album2.setText(R.string.bandAlbum2);
        album3.setText(R.string.bandAlbum3);

        TextView removeItems[] = {album4, album5, album6};
        for (int i = 0; i < removeItems.length; i++) {
            removeItems[i].setVisibility(View.GONE);
        }

        /*if(bandId == 2) {
            Context context = getApplicationContext();
            CharSequence text = "For the Quiz, visit 3 Doors Down";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            ImageView bandImage = findViewById(R.id.headerBandImage);
            bandImage.setImageResource(R.drawable.acdc);

            TextView bandName = findViewById(R.id.titleA);
            bandName.setText(R.string.bandName2);

            TextView bandInfo = findViewById(R.id.description);
            bandInfo.setText(R.string.bandInfo2);

            TextView bandMember1 = findViewById(R.id.member1);
            TextView bandMember2 = findViewById(R.id.member2);
            TextView bandMember3 = findViewById(R.id.member3);
            TextView bandMember7 = findViewById(R.id.member7);
            TextView bandMember5 = findViewById(R.id.member5);
            TextView bandMember6 = findViewById(R.id.member6);
            TextView bandMember4 = findViewById(R.id.member4);
            TextView bandMember8 = findViewById(R.id.member8);
            bandMember1.setText(R.string.bandMember5);
            bandMember2.setText(R.string.bandMember6);
            bandMember3.setText(R.string.bandMember7);
            bandMember7.setText(R.string.bandMember8);
            bandMember4.setText(R.string.bandMember9);
            bandMember5.setText(R.string.bandMember10);
            bandMember6.setText(R.string.bandMember11);
            bandMember8.setText(R.string.bandMember12);

            TextView success = findViewById(R.id.successStory);
            success.setText(R.string.band1Success);

            TextView album1 = findViewById(R.id.album1);
            TextView album2 = findViewById(R.id.album2);
            TextView album3 = findViewById(R.id.album3);
            TextView album4 = findViewById(R.id.album4);
            TextView album5 = findViewById(R.id.album5);
            TextView album6 = findViewById(R.id.album6);

            album1.setText(R.string.bandAlbum1);
            album2.setText(R.string.bandAlbum2);
            album3.setText(R.string.bandAlbum3);

            TextView removeItems[] = {album4, album5, album6};
            for (int i = 0; i < removeItems.length; i++) {
                removeItems[i].setVisibility(View.GONE);
            }
        }*/
    }
}

