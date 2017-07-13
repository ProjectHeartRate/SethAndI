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
 * This class presents a user interface that displays the heartrate the athlete, as well as a
 * history of their heartrate from previous days.
 * @author Scott Martell, Jenna McNeil
 */
public class AthleteHeartRateActivity extends AppCompatActivity {
    int heartRate = 90;

    /**
     * This method creates the athlete heartrate activity ui.
     * @param savedInstanceState not sure what it does.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athlete_heartrate);

        //initialize ui elements
        final Button heartrateBack = (Button) findViewById(R.id.heartrateBack);
        final TextView heartrateCurrent = (TextView) findViewById(R.id.heartrateCurrent);
        final ListView heartrateHistory = (ListView) findViewById(R.id.heartRateHistory);


        heartrateBack.setOnClickListener(new View.OnClickListener(){
            /**
             * On click opens the Athlete activity ui.
             * @param view sets the ui.
             */
            public void onClick(View view){
                Intent athlete = new Intent(view.getContext(), AthleteActivity.class);
                startActivityForResult(athlete, 0);
            }
        });

        if (heartRate >= 0){
            heartrateCurrent.setText("Heart Rate: "+heartRate+".");
        }
        if (heartRate < 0){
            heartrateCurrent.setText("Heart Rate: Invalid input.");
        }
    }

    /**
     * Getter for heartrate.
     * @return heartRate.
     */
    public int getHeartRate(){
        return heartRate;
    }

    /**
     * Setter for heartrate
     * @param heartRate value for current heartrate.
     */
    public void setHeartRate(int heartRate){
        this.heartRate = heartRate;
    }
}
