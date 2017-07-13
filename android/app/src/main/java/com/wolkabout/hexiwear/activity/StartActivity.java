package com.wolkabout.hexiwear.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wolkabout.hexiwear.R;

import org.androidannotations.annotations.ViewById;

/**
 * This class presents an interface with two buttons, Coach and Athlete, which opens the UI
 * for the coach or the athlete, respectively.
 * @author Scott Martell, Jenna McNeil
 */
public class StartActivity extends AppCompatActivity  {

    private Button coachButton;
    private Button athleteButton;

    /**
     * This method creates the main activity user interface.
     * @param savedInstanceState not sure what it does.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //initializing ui elements
        coachButton = (Button) findViewById(R.id.coach);
        athleteButton = (Button) findViewById(R.id.athlete);
    }

    /**
     * On click opens CoachActivity ui.
     * @param view sets the ui.
     */
    public void showCoachActivity(View view){
        Intent coachScreen = new Intent(this, CoachActivity.class);
        startActivity(coachScreen);
    }

    /**
     * On click opens AthleteActivity ui.
     * @param view sets the ui.
     */
    public void showAthleteActivity(View view){
        Intent athleteScreen = new Intent(this, AthleteActivity.class);
        startActivity(athleteScreen);
    }
}
