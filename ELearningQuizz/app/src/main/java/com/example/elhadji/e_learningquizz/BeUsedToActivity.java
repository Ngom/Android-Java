package com.example.elhadji.e_learningquizz;

import android.content.Intent;
import android.graphics.Color;
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
    TextView lessonRemark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_be_used_to);
        // Initialization of checkboxes below:

        boxUseTo = (CheckBox) findViewById(R.id.usedtocheckbox);
        boxBeUseTo = (CheckBox) findViewById(R.id.beusedtocheckbox);
        lessonRemark = (TextView) findViewById(R.id.lesson_rule);
    }



    /**
     * Test methods are defined below!
     */

    public void testStartUsedTo(View view) {
        makeSentence("I am used to/used to " + useTo);
    }



    /**
     * This method gives the lesson conclusion.
     */

    public void lessonRule(){
        String remark = "'Depuis': USED TO/BE USED TO";
        remark = remark + "\n USED TO + V:";
        remark = remark + " s'utilise pour un événement totalement révolu.";
        remark = remark + " Sa forme ne change jamais.";
        remark = remark + "\n BE USED TO + V -ING:";
        remark = remark + " s'utilise pour exprimer une habitude.";
        lessonRemark.setText(remark);
        lessonRemark.setAllCaps(false);
        lessonRemark.setTextColor(Color.BLUE);
        lessonRemark.setTextSize(14);
    }


    /**
     * Submit answers method
     */
    public void submitAnswers(View view) {
        // Go in with control flow statement!
        if (boxUseTo.isChecked()) {
            giveAnswer("You got it, right !\n" + "I used to " + useTo);
            lessonRule();
        } else {
            Toast.makeText(this, R.string.toastMessage, Toast.LENGTH_SHORT).show();
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


        makeSentence(getString(R.string.testbutton));
        giveAnswer(getString(R.string.thanks));
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
