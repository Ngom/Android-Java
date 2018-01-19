package com.example.elhadji.e_learningquizz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class SecondActivity extends AppCompatActivity {

    // Declarations of right checkboxes below:
    /*
    CheckBox boxFor;
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // Initialization of checkboxes below:
        /*
        boxFor = (CheckBox) findViewById(R.id.forcheckbox);
        */

    }


    /**
     * Back method:
     */
    public void backToWelcome(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
        // take input text and show it as Toast
        String message = getInput();
        Toast.makeText(this, "Thank for the feedback: " + message, Toast.LENGTH_LONG).show();
    }

    /**
     * Give sentence method:
     *
     * @return text as string.
     */
    public String getInput() {
        EditText suggestion = (EditText) findViewById(R.id.input_text);
        String output = suggestion.getText().toString();
        return output;
    }

}

