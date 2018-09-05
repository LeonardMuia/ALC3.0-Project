package com.example.android.band;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Quiz extends AboutBand {
    public static int totalPoints;
    int points;
    int clickCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);

       /*  Getting and Setting Global Variables
         Commented it out because It gave me problems with execution.
         Could you please help me out, please?
         I was trying to use Global Variables that are accessed by multiple classes by getting context*/

       /* final Globals totalPoints = (Globals) getApplicationContext();
        final Globals questionsDone = (Globals) getApplicationContext();
        totalPoints.setTotalPoints(0);
        questionsDone.setQuestionsDone(10);
        */

        /* I have had to hide question to ensure answering is done sequentially.
         That way the variable Points is incremented sequentially. Otherwise the score is ruined.
         In addition, it is another way of ensuring a user attempts all questions
         I had problems when a user only answered another question, without following the sequence of 1 - 10*/

        // Play Popular Song
        playSong();

        // Back Button
        backBtn();

        // Submit
        submitAnswers();

        // Hide Questions
        hideQuestions();

        // Reveal Questions
        revealQuestions();
    }

    // Play Popular Song

    private void playSong() {

        final ImageView play = findViewById(R.id.playSong);
        final MediaPlayer mp3 = MediaPlayer.create(this, R.raw.song1);
        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                clickCount = clickCount + 1;

                // Play Song Upon Clicking Play Button
                try {
                    for (int i = 0; i <= clickCount; i++)
                        if (i > 1 && i % 2 == 1) {
                            ImageView play = findViewById(R.id.playSong);
                            mp3.getCurrentPosition();
                            mp3.start();
                            play.setImageResource(R.drawable.pause);
                        } else if (mp3.isPlaying()) {
                            mp3.pause();
                            mp3.getCurrentPosition();
                            play.setImageResource(R.drawable.play);
                        } else if (i == 1) {
                            mp3.start();
                            play.setImageResource(R.drawable.pause);
                        }
                } catch (
                        Exception e)

                {
                    e.printStackTrace();
                }
            }
        });
    }

    private void backBtn() {
        ImageView backBtn = findViewById(R.id.backButton2);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToBandsInfo = new Intent(getApplicationContext(), AboutBand.class);
                startActivity(backToBandsInfo);
            }
        });
    }

    private void submitAnswers() {
        ImageView submitAnswers = findViewById(R.id.submitQuiz);
        submitAnswers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent scoreStats = new Intent(getApplicationContext(), Score.class);
                startActivity(scoreStats);

                // Calculate Total Score
                totalPoints = calculateTotalPoints();
            }
        });
    }

    public int calculateTotalPoints() {
        // Question 1
        RadioButton correct1 = findViewById(R.id.option1A);
        Boolean isCorrect1 = correct1.isChecked();
        if (isCorrect1) {
            points = 1;
        }

        // Question 2
        RadioButton correct2 = findViewById(R.id.option2D);
        Boolean isCorrect2 = correct2.isChecked();
        if (isCorrect2) {
            points += 1;
        }
        // Question 3
        CheckBox option3A = findViewById(R.id.option3A);
        CheckBox option3B = findViewById(R.id.option3B);
        CheckBox option3C = findViewById(R.id.option3C);
        CheckBox option3D = findViewById(R.id.option3D);
        Boolean isCorrect3A = option3A.isChecked();
        Boolean isCorrect3B = option3B.isChecked();
        Boolean isCorrect3D = option3D.isChecked();
        Boolean isWrong3C = option3C.isChecked();

        if (isWrong3C) {
            points = 0;
        } else if (isCorrect3A && isCorrect3B && isCorrect3D) {
            points += 1;
        }
        // Question 4
        CheckBox option4A = findViewById(R.id.option4A);
        CheckBox option4B = findViewById(R.id.option4B);
        CheckBox option4C = findViewById(R.id.option4C);
        CheckBox option4D = findViewById(R.id.option4D);
        Boolean isCorrect4B = option4B.isChecked();
        Boolean isCorrect4D = option4D.isChecked();
        Boolean isWrong4A = option4A.isChecked();
        Boolean isWrong4C = option4C.isChecked();

        if (isWrong4A) {
            points = 0;
        } else if (isWrong4C) {
            points = 0;
        } else if (isCorrect4B && isCorrect4D) {
            // Increment Points by 1
            points += 1;
        }
        // Question 5
        RadioButton correct5 = findViewById(R.id.option5B);
        Boolean isCorrect5 = correct5.isChecked();
        if (isCorrect5) {
            points += 1;
        }
        // Question 6
        RadioButton correct6 = findViewById(R.id.option6A);
        Boolean isCorrect6 = correct6.isChecked();
        if (isCorrect6) {
            points += 1;
        }
        // Question 7
        RadioButton correct7 = findViewById(R.id.option7B);
        Boolean isCorrect7 = correct7.isChecked();
        if (isCorrect7) {
            points += 1;
        }
        // Question 8
        EditText question8 = findViewById(R.id.question8Answer);
        question8.setSingleLine();
        question8.setImeOptions(EditorInfo.IME_ACTION_DONE);
        String userAnswer = question8.getText().toString().toLowerCase();

        // String answer = "us and the night"; This is the Correct Answer

        String answer = "(kryptonyte)";
        if (userAnswer.matches(answer)) {
            points += 1;
        }
        // Question 9
        RadioButton correct9 = findViewById(R.id.option9C);
        Boolean isCorrect9 = correct9.isChecked();
        if (isCorrect9) {
            points += 1;
        }
        // Question 10
        RadioButton correct10 = findViewById(R.id.option10A);
        Boolean isCorrect10 = correct10.isChecked();
        if (isCorrect10) {
            points += 1;
        }
        return points;
    }

    private void hideQuestions() {
        /*
         * I know I could have set Visibility to Gone directly on the XML
         * But I Enjoy writing this code. Although repetitive, and inefficient.
         * So bear with me
         * */

        // Hide Questions
        TextView question2 = findViewById(R.id.quizQuestion2);
        TextView question3 = findViewById(R.id.quizQuestion3);
        TextView question4 = findViewById(R.id.quizQuestion4);
        TextView question5 = findViewById(R.id.quizQuestion5);
        TextView question6 = findViewById(R.id.quizQuestion6);
        TextView question7 = findViewById(R.id.quizQuestion7);
        TextView question8 = findViewById(R.id.quizQuestion8);
        TextView question9 = findViewById(R.id.quizQuestion9);
        TextView question10 = findViewById(R.id.quizQuestion10);

        TextView allQuestions[] = {question2, question3, question4, question5, question6, question7, question8, question9, question10};
        for (TextView all : allQuestions) {
            all.setVisibility(View.GONE);
        }

        // Hide Choices Question 2
        RadioGroup question2Choices = findViewById(R.id.quizQuestion2Choices);
        int choices = question2Choices.getChildCount();
        for (int i = 0; i < choices; i++) {
            View x = question2Choices.getChildAt(i);
            x.setVisibility(View.GONE);
        }

        // Hide Choices Question 3
        CheckBox threeA = findViewById(R.id.option3A);
        CheckBox threeB = findViewById(R.id.option3B);
        CheckBox threeC = findViewById(R.id.option3C);
        CheckBox threeD = findViewById(R.id.option3D);
        CheckBox choices2[] = {threeA, threeB, threeC, threeD};
        for (CheckBox x : choices2) {
            x.setVisibility(View.GONE);
        }

        // Hide Choices Question 4
        CheckBox fourA = findViewById(R.id.option4A);
        CheckBox fourB = findViewById(R.id.option4B);
        CheckBox fourC = findViewById(R.id.option4C);
        CheckBox fourD = findViewById(R.id.option4D);
        CheckBox choices3[] = {fourA, fourB, fourC, fourD};
        for (CheckBox x : choices3) {
            x.setVisibility(View.GONE);
        }

        /*
         * The rest of the choices are set to Invisible/Gone on the XML
         * */
    }

    private void revealQuestions() {
        // Reveal Questions 2
        RadioGroup question1 = findViewById(R.id.quizQuestion1Choices);
        int choices = question1.getChildCount();
        for (int i = 0; i < choices; i++) {
            View o = question1.getChildAt(i);
            o.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView question2 = findViewById(R.id.quizQuestion2);
                    question2.setVisibility(View.VISIBLE);

                    // Show Choices
                    RadioGroup question2Choices = findViewById(R.id.quizQuestion2Choices);
                    int choices = question2Choices.getChildCount();
                    for (int i = 0; i < choices; i++) {
                        View x = question2Choices.getChildAt(i);
                        x.setVisibility(View.VISIBLE);
                    }
                }
            });
        }

        // Reveal Question 3
        RadioGroup question2Choices = findViewById(R.id.quizQuestion2Choices);
        int choices2 = question2Choices.getChildCount();
        for (int i = 0; i < choices2; i++) {
            View o = question2Choices.getChildAt(i);
            o.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView question3 = findViewById(R.id.quizQuestion3);
                    question3.setVisibility(View.VISIBLE);

                    // Show Choices
                    CheckBox threeA = findViewById(R.id.option3A);
                    CheckBox threeB = findViewById(R.id.option3B);
                    CheckBox threeC = findViewById(R.id.option3C);
                    CheckBox threeD = findViewById(R.id.option3D);
                    CheckBox choices3[] = {threeA, threeB, threeC, threeD};
                    for (CheckBox x : choices3) {
                        x.setVisibility(View.VISIBLE);
                    }
                }
            });
        }

        // Reveal Question 4
        CheckBox threeA = findViewById(R.id.option3A);
        CheckBox threeB = findViewById(R.id.option3B);
        CheckBox threeC = findViewById(R.id.option3C);
        CheckBox threeD = findViewById(R.id.option3D);
        CheckBox choices3[] = {threeA, threeB, threeC, threeD};
        for (CheckBox x : choices3) {
            x.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView question4 = findViewById(R.id.quizQuestion4);
                    question4.setVisibility(View.VISIBLE);

                    CheckBox fourA = findViewById(R.id.option4A);
                    CheckBox fourB = findViewById(R.id.option4B);
                    CheckBox fourC = findViewById(R.id.option4C);
                    CheckBox fourD = findViewById(R.id.option4D);
                    CheckBox choices4[] = {fourA, fourB, fourC, fourD};
                    for (CheckBox x : choices4) {
                        x.setVisibility(View.VISIBLE);
                    }
                }
            });
        }

        // Reveal Question 5
        CheckBox fourA = findViewById(R.id.option4A);
        CheckBox fourB = findViewById(R.id.option4B);
        CheckBox fourC = findViewById(R.id.option4C);
        CheckBox fourD = findViewById(R.id.option4D);
        CheckBox choices4[] = {fourA, fourB, fourC, fourD};
        for (CheckBox x : choices4) {
            x.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView question5 = findViewById(R.id.quizQuestion5);
                    question5.setVisibility(View.VISIBLE);

                    // Show Choices
                    RadioGroup question5Choices = findViewById(R.id.quizQuestion5Choices);
                    int choices = question5Choices.getChildCount();
                    for (int i = 0; i < choices; i++) {
                        View x = question5Choices.getChildAt(i);
                        x.setVisibility(View.VISIBLE);
                    }
                }
            });
        }

        // Reveal Question 6
        RadioGroup question5Choices = findViewById(R.id.quizQuestion5Choices);
        int choices5 = question5Choices.getChildCount();
        for (int i = 0; i < choices5; i++) {
            View o = question5Choices.getChildAt(i);
            o.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView question6 = findViewById(R.id.quizQuestion6);
                    question6.setVisibility(View.VISIBLE);

                    // Show Choices
                    RadioGroup question6Choices = findViewById(R.id.quizQuestion6Choices);
                    int choices = question6Choices.getChildCount();
                    for (int i = 0; i < choices; i++) {
                        View x = question6Choices.getChildAt(i);
                        x.setVisibility(View.VISIBLE);
                    }
                }
            });
        }

        // Reveal Question 7
        RadioGroup question6Choices = findViewById(R.id.quizQuestion6Choices);
        int choices6 = question6Choices.getChildCount();
        for (int i = 0; i < choices6; i++) {
            View o = question6Choices.getChildAt(i);
            o.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView question7 = findViewById(R.id.quizQuestion7);
                    question7.setVisibility(View.VISIBLE);

                    // Show Choices
                    RadioGroup question7Choices = findViewById(R.id.quizQuestion7Choices);
                    int choices = question7Choices.getChildCount();
                    for (int i = 0; i < choices; i++) {
                        View x = question7Choices.getChildAt(i);
                        x.setVisibility(View.VISIBLE);
                    }
                }
            });
        }

        // Reveal Question 8
        RadioGroup question7Choices = findViewById(R.id.quizQuestion7Choices);
        int choices7 = question7Choices.getChildCount();
        for (int i = 0; i < choices7; i++) {
            View o = question7Choices.getChildAt(i);
            o.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView question8 = findViewById(R.id.quizQuestion8);
                    question8.setVisibility(View.VISIBLE);

                    // Show Choices
                    EditText field = findViewById(R.id.question8Answer);
                    field.setVisibility(View.VISIBLE);
                }
            });
        }

        // Reveal Question 9
        final EditText field = findViewById(R.id.question8Answer);
        field.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                TextView question9 = findViewById(R.id.quizQuestion9);
                question9.setVisibility(View.VISIBLE);

                // Show Choices
                RadioGroup question9Choices = findViewById(R.id.quizQuestion9Choices);
                int choices = question9Choices.getChildCount();
                for (int i = 0; i < choices; i++) {
                    View x = question9Choices.getChildAt(i);
                    x.setVisibility(View.VISIBLE);
                }
                return true;
            }
        });

        // Reveal Question 10
        RadioGroup question9Choices = findViewById(R.id.quizQuestion9Choices);
        int choices9 = question9Choices.getChildCount();
        for (int i = 0; i < choices9; i++) {
            View o = question9Choices.getChildAt(i);
            o.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView question10 = findViewById(R.id.quizQuestion10);
                    question10.setVisibility(View.VISIBLE);

                    // Show Choices
                    RadioGroup question10Choices = findViewById(R.id.quizQuestion10Choices);
                    int choices = question10Choices.getChildCount();
                    for (int i = 0; i < choices; i++) {
                        View x = question10Choices.getChildAt(i);
                        x.setVisibility(View.VISIBLE);
                    }

                }
            });
        }

        // Reveal Submit Button
        RadioGroup question10Choices = findViewById(R.id.quizQuestion10Choices);
        int choices10 = question10Choices.getChildCount();
        for (int i = 0; i < choices10; i++) {
            View o = question10Choices.getChildAt(i);
            o.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImageView submit = findViewById(R.id.submitQuiz);
                    submit.setVisibility(View.VISIBLE);
                }
            });
        }
    }
}



