package com.example.elhadji.e_learningquizz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class ThisThatActivity extends AppCompatActivity {

    /**
     * Sentences used below are defined here !
     */

    String thisThat = "picture is too blurry to be worth printing.";


    // Declarations of right checkboxes below:

    CheckBox boxThat;
    CheckBox boxThis;
    TextView lessonRemark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_this_that);
        // Initialization of checkboxes below:

        boxThat = (CheckBox) findViewById(R.id.thatcheckbox);
        boxThis = (CheckBox) findViewById(R.id.thischeckbox);
        lessonRemark = (TextView) findViewById(R.id.lesson_rule);
    }


    /**
     * Test methods are defined below!
     */

    public void testStartThis(View view) {
        makeSentence("This/That " + thisThat);
    }

    /**
     * This method gives the lesson conclusion.
     */
    public void lessonRule(){
        String remark = "'Ce/Cette': THIS/THAT";
        remark = remark + "\n THIS et THAT sont suivis du singulier.";
        remark = remark + "\n THESE et THOSE leurs pluriels, sont suivis d'un pluriel.";
        lessonRemark.setText(remark);
        lessonRemark.setAllCaps(false);
        lessonRemark.setTextColor(Color.BLUE);
        lessonRemark.setTextSize(14);
    }




    //public void testStarSuSuch(View view) {
    //    makeSentence("You look so/such angry! " + soSuch);
    //}


    /**
     * Submit answers method
     */
    public void submitAnswers(View view) {
        // Go in with control flow statement!
        if (boxThat.isChecked()) {
            giveAnswer("You got it, right !\n" + "That " + thisThat);
            lessonRule();
        } else {
            Toast.makeText(this, " Ooooopps, you miss the right answer!", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * Reset button method below:
     */
    public void resetBoxes(View view) {
        //Use toggle() attributes to uncheck boxes !

        if (boxThat.isChecked()) {
            boxThat.toggle();
        }
        if (boxThis.isChecked()) {
            boxThis.toggle();
        }



        makeSentence("Click on one test please!");
        giveAnswer("Thank you for trying, let's see the answer!");
    }


    /*
     Direction to the second activity
     */
    public void goToSecondActivity(View v) {
        // Use Intent to start the second activity
        Intent intencion = new Intent(this, BeUsedToActivity.class);
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
