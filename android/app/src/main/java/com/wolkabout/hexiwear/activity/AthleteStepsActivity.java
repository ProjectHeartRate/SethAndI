package com.wolkabout.hexiwear.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.wolkabout.hexiwear.R;

/**
 * This class presents a user interface that displays the number of steps the athlete has taken
 * today, as well as a history of their steps from previous days.
 * @author Scott Martell, Jenna McNeil
 */
public class AthleteStepsActivity extends AppCompatActivity {
    int steps = 10000;

    /**
     * This method creates the athlete steps activity ui.
     * @param savedInstanceState not sure what it does.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athlete_steps);

        //initialize ui elements
        final Button stepsBack = (Button) findViewById(R.id.stepsBack);
        final TextView stepsToday = (TextView) findViewById(R.id.stepsToday);
        final ListView stepHistory = (ListView) findViewById(R.id.stepsHistory);

        stepsBack.setOnClickListener(new View.OnClickListener(){
            /**
             * On click opens the Athlete activity ui.
             * @param view sets the ui.
             */
            public void onClick(View view){
                Intent athlete = new Intent(view.getContext(), AthleteActivity.class);
                startActivityForResult(athlete, 0);
            }
        });

        if (steps >= 0){
            stepsToday.setText("Steps: "+steps+".");
        }
        if (steps < 0){
            stepsToday.setText("Steps: Invalid input.");
        }
    }

    /**
     * Getter for the number of steps.
     * @return steps
     */
    public int getSteps(){
        return steps;
    }

    /**
     * Steer for the number of steps.
     * @param steps the number of steps
     */
    public void setSteps(int steps){
        this.steps = steps;
    }
}
