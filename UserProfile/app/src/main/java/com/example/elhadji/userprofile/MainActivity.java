package com.example.elhadji.userprofile;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TextView variables definition below!

        TextView name = (TextView) findViewById(R.id.name);
        name.setText(R.string.name);
        name.setTextSize(14);
        name.setTextColor(Color.BLUE);

        TextView birthday = (TextView) findViewById(R.id.birthday);
        birthday.setText(R.string.birthday);
        birthday.setTextSize(14);
        birthday.setTextColor(Color.CYAN);

        TextView country = (TextView) findViewById(R.id.country);
        country.setText(R.string.country);
        country.setTextSize(16);
        country.setTextColor(Color.GREEN);

        // ImageView variable definition here!

        ImageView profilePicture = (ImageView) findViewById(R.id.profile_picture);
        profilePicture.setImageResource(R.drawable.profil);

    }
}
