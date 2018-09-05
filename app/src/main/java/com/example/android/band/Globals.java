package com.example.android.band;

import android.app.Application;

public class Globals extends Application {
    public static int totalPoints;
    public static int questionsDone;

    public static int getTotalPoints() {
        return totalPoints;
    }

    public static int getQuestionsDone() {
        return questionsDone;
    }

    public void setTotalPoints(int totalPointsScored) {
        totalPoints = totalPointsScored;
    }

    public void setQuestionsDone(int totalQuestionsDone) {
        questionsDone = totalQuestionsDone;
    }
}
