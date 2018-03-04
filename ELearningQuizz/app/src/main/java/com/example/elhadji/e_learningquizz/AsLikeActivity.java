package com.example.elhadji.e_learningquizz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class AsLikeActivity extends AppCompatActivity {

    /**
     * Sentences used below are defined here !
     */

    String asLike = "your mother before me, I start the violin at the age of 4.";

    // Declarations of right checkboxes below:

    CheckBox boxLike;
    CheckBox boxAs;
    TextView lessonRemark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_as_like);
        // Initialization of checkboxes below:

        boxLike = (CheckBox) findViewById(R.id.likecheckbox);
        boxAs = (CheckBox) findViewById(R.id.ascheckbox);
        lessonRemark = (TextView) findViewById(R.id.lesson_rule);
    }


    /**
     * Test methods are defined below!
     */

    public void testStarAsLike(View view) {
        makeSentence("As/Like " + asLike);
    }

    /**
     * This method gives the lesson conclusion.
     */

    public void lessonRule(){
        String remark = "'Comparaison': AS/LIKE";
        remark = remark + "\n LIKE: comparaison simple avec 'comme'";
        remark = remark + "\n AS: signifie 'en tant que'.";
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
        if (boxLike.isChecked()) {
            giveAnswer("Aweasome, right answer !\n" + "Like " + asLike);
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

        if (boxLike.isChecked()) {
            boxLike.toggle();
        }
        if (boxAs.isChecked()) {
            boxAs.toggle();
        }

        makeSentence(getString(R.string.testbutton));
        giveAnswer(getString(R.string.thanks));
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
