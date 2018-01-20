package com.example.elhadji.e_learningquizz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;


public class StillAlwaysActivity extends AppCompatActivity {

    /**
     * Sentences used below are defined here !
     */

    String stillAlways = "complaining about school.";

    // Declarations of right checkboxes below:

    CheckBox boxAlways;
    CheckBox boxStill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_still_always);
        // Initialization of checkboxes below:

        boxAlways = (CheckBox) findViewById(R.id.alwayscheckbox);
        boxStill = (CheckBox) findViewById(R.id.stillcheckbox);
    }


    /**
     * Test methods are defined below!
     */


    public void testStarStill(View view) {
        makeSentence("He's always/still " + stillAlways);
    }


    //public void testStarSuSuch(View view) {
    //    makeSentence("You look so/such angry! " + soSuch);
    //}


    /**
     * Submit answers method
     */
    public void submitAnswers(View view) {
        // Go in with control flow statement!
        if (boxAlways.isChecked()) {
            giveAnswer("You got it, right !\n" + "He's always " + stillAlways);
        } else {
            Toast.makeText(this, " Ooooopps, you miss the right answer!", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * Reset button method below:
     */
    public void resetBoxes(View view) {
        //Use toggle() attributes to uncheck boxes !

        if (boxAlways.isChecked()) {
            boxAlways.toggle();
        }
        if (boxStill.isChecked()) {
            boxStill.toggle();
        }

        makeSentence("Click on one test please!");
        giveAnswer("Thank you for trying, let's see the answer!");
    }


    /*
     Direction to the second activity
     */
    public void goToSecondActivity(View v) {
        // Use Intent to start the second activity
        Intent intencion = new Intent(this, AsLikeActivity.class);
        startActivity(intencion);
        finish();
    }


    /**
     * Display sentence method:
     */
    public void makeSentence(String sentence) {
        TextView phase = (TextView) findViewById(R.id.sentence_text);
        phase.setText(sentence);
    }

    /**
     * Give sentence method:
     */
    public void giveAnswer(String ansmer) {
        TextView phase = (TextView) findViewById(R.id.result_text_view);
        phase.setText(ansmer);
    }

}
