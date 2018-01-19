package com.example.elhadji.e_learningquizz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * Sentences used below are defined here !
     */
    String forSince = "I've been trying to convince her";
    String thisThat = "picture is too blurry to be worth printing.";
    String useTo = "live in London.";
    String stillAlways = "complaining about school.";
    String asLike = "your mother before me, I start the violin at the age of 4.";

    // Declarations of right checkboxes below:
    CheckBox boxFor;
    CheckBox boxSince;
    CheckBox boxThat;
    CheckBox boxThis;
    CheckBox boxUseTo;
    CheckBox boxBeUseTo;
    CheckBox boxAlways;
    CheckBox boxStill;
    CheckBox boxLike;
    CheckBox boxAs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialization of checkboxes below:
        boxFor = (CheckBox) findViewById(R.id.forcheckbox);
        boxSince = (CheckBox) findViewById(R.id.sincecheckbox);
        boxThat = (CheckBox) findViewById(R.id.thatcheckbox);
        boxThis = (CheckBox) findViewById(R.id.thischeckbox);
        boxUseTo = (CheckBox) findViewById(R.id.usedtocheckbox);
        boxBeUseTo = (CheckBox) findViewById(R.id.beusedtocheckbox);
        boxAlways = (CheckBox) findViewById(R.id.alwayscheckbox);
        boxStill = (CheckBox) findViewById(R.id.stillcheckbox);
        boxLike = (CheckBox) findViewById(R.id.likecheckbox);
        boxAs = (CheckBox) findViewById(R.id.ascheckbox);
    }

    /**
     * Test methods are defined below!
     */
    public void testStartFor(View view) {
        makeSentence(forSince + "  since/for 20 minutes.");
    }

    public void testStartThis(View view) {
        makeSentence("This/That " + thisThat);
    }

    public void testStartUsedTo(View view) {
        makeSentence("I am used to/used to " + useTo);
    }

    public void testStarStill(View view) {
        makeSentence("He's always/still " + stillAlways);
    }

    public void testStarAsLike(View view) {
        makeSentence("As/Like " + asLike);
    }

    //public void testStarSuSuch(View view) {
    //    makeSentence("You look so/such angry! " + soSuch);
    //}


    /**
     * Submit answers method
     */
    public void submitAnswers(View view) {
        // Go in with control flow statement!
        if (boxFor.isChecked()) {
            giveAnswer("You got it, right !\n" + forSince + " for 20 minutes.");
        } else if (boxThat.isChecked()) {
            giveAnswer("You got it, right !\n" + "That " + thisThat);
        } else if (boxUseTo.isChecked()) {
            giveAnswer("You got it, right !\n" + "I used to " + useTo);
        } else if (boxAlways.isChecked()) {
            giveAnswer("You got it, right !\n" + "He's always " + stillAlways);
        } else if (boxLike.isChecked()) {
            giveAnswer("Aweasome, right answer !\n" + "Like " + asLike);
        } else {
            Toast.makeText(this, " Ooooopps, you miss the right answer!", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * Reset button method below:
     */
    public void resetBoxes(View view) {
        //Use toggle() attributes to uncheck boxes !

        if (boxFor.isChecked()) {
            boxFor.toggle();
        }
        if (boxSince.isChecked()) {
            boxSince.toggle();
        }

        if (boxThat.isChecked()) {
            boxThat.toggle();
        }
        if (boxThis.isChecked()) {
            boxThis.toggle();
        }

        if (boxUseTo.isChecked()) {
            boxUseTo.toggle();
        }
        if (boxBeUseTo.isChecked()) {
            boxBeUseTo.toggle();
        }

        if (boxAlways.isChecked()) {
            boxAlways.toggle();
        }
        if (boxStill.isChecked()) {
            boxStill.toggle();
        }

        if (boxLike.isChecked()) {
            boxLike.toggle();
        }
        if (boxAs.isChecked()) {
            boxAs.toggle();
        }

        makeSentence("Click on one test please!");
        giveAnswer("Thank you for trying, let's see the answer!");
    }


    /*
     Direction to the second activity
     */
    public void goToSecondActivity(View v) {
        // Use Intent to start the second activity
        Intent intencion = new Intent(this, SoSuchActivity.class);
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

