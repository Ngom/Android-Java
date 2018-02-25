package com.example.android.basketball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // score variables definition
    int score_a = 0; // for team A
    int score_b = 0; // for Team B

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the three points button is clicked.
     */
    public void addThreeToScoreA(View view) {
        score_a = score_a + 3;
        displayForTeamA(score_a);
    }

    /**
     * This method is called when the two points button is clicked.
     */
    public void addTwoToScoreA(View view) {
        score_a = score_a + 2;
        displayForTeamA(score_a);
    }

    /**
     * This method is called when the one point button is clicked.
     */
    public void addOneToScoreA(View view) {
        score_a = score_a + 1;
        displayForTeamA(score_a);
    }

    /**
     * This method is called when the three points button is clicked.
     */
    public void addThreeToScoreB(View view) {
        score_b = score_b + 3;
        displayForTeamB(score_b);
    }

    /**
     * This method is called when the two points button is clicked.
     */
    public void addTwoToScoreB(View view) {
        score_b = score_b + 2;
        displayForTeamB(score_b);
    }

    /**
     * This method is called when the one point button is clicked.
     */
    public void addOneToScoreB(View view) {
        score_b = score_b + 1;
        displayForTeamB(score_b);
    }

    /**
     * Reset scores to zero for Team A and Team B!
     */
    public void resetScores(View view){
        score_a = 0;
        score_b = 0;
        displayForTeamB(score_b);
        displayForTeamA(score_a);
    }

    /**
     * This method displays the given score for Team A.
     */
    private void displayForTeamA(int score) {
        TextView scoreTextView = (TextView) findViewById(R.id.score_a_view);
        scoreTextView.setText("" + score);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.score_b_view);
        scoreView.setText(String.valueOf(score));
    }
}
