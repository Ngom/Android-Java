package com.example.elhadji.e_learningquizz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class BeUsedToActivity extends AppCompatActivity {
    /**
     * Sentences used below are defined here !
     */

    String useTo = "live in London.";

    // Declarations of right checkboxes below:

    CheckBox boxUseTo;
    CheckBox boxBeUseTo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_be_used_to);
        // Initialization of checkboxes below:

        boxUseTo = (CheckBox) findViewById(R.id.usedtocheckbox);
        boxBeUseTo = (CheckBox) findViewById(R.id.beusedtocheckbox);
    }



    /**
     * Test methods are defined below!
     */

    public void testStartUsedTo(View view) {
        makeSentence("I am used to/used to " + useTo);
    }



    //public void testStarSuSuch(View view) {
    //    makeSentence("You look so/such angry! " + soSuch);
    //}


    /**
     * Submit answers method
     */
    public void submitAnswers(View view) {
        // Go in with control flow statement!
        if (boxUseTo.isChecked()) {
            giveAnswer("You got it, right !\n" + "I used to " + useTo);
        } else {
            Toast.makeText(this, " Ooooopps, you miss the right answer!", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * Reset button method below:
     */
    public void resetBoxes(View view) {
        //Use toggle() attributes to uncheck boxes !

        if (boxUseTo.isChecked()) {
            boxUseTo.toggle();
        }
        if (boxBeUseTo.isChecked()) {
            boxBeUseTo.toggle();
        }


        makeSentence("Click on one test please!");
        giveAnswer("Thank you for trying, let's see the answer!");
    }


    /*
     Direction to the second activity
     */
    public void goToSecondActivity(View v) {
        // Use Intent to start the second activity
        Intent intencion = new Intent(this, StillAlwaysActivity.class);
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
