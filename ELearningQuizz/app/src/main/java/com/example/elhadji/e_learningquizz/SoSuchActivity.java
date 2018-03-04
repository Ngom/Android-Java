package com.example.elhadji.e_learningquizz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class SoSuchActivity extends AppCompatActivity {

    /**
     * Sentences used below are defined here !
     */
    String soSuch = "What did she tell you?";
    // Declarations of right checkboxes below:
    CheckBox boxSo;
    CheckBox boxSuch;
    TextView lessonRemark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_so_such);

        // Initialization of checkboxes below:
        boxSo = (CheckBox) findViewById(R.id.socheckbox);
        boxSuch = (CheckBox) findViewById(R.id.suchcheckbox);
        lessonRemark = (TextView) findViewById(R.id.lesson_rule);
    }

    /**
     * Test methods are defined below!
     */

    public void testStarSuSuch(View view) {
        makeSentence("You look so/such angry! " + soSuch);
    }

    /**
     * This method gives the lesson conclusion.
     */

    public void lessonRule(){
        String remark = "SO/SUCH";
        remark = remark + "\n SO:";
        remark = remark + " se place devant un adjectif seul.";
        remark = remark + "\n SUCH:";
        remark = remark + " s'utilise avec un groupe nominal.";
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
        if  (boxSo.isChecked()) {
            giveAnswer("Aweasome, right answer !\n" + "You look so angry! " + soSuch);
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

        if (boxSo.isChecked()) {
            boxSo.toggle();
        }
        if (boxSuch.isChecked()) {
            boxSuch.toggle();
        }
        makeSentence(getString(R.string.testbutton));
        giveAnswer(getString(R.string.thanks));
    }


    /*
     Direction to the second activity
     */
    public void goToSecondActivity(View v) {
        // Use Intent to start the second activity
        Intent intencion = new Intent(this, SecondActivity.class);
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

