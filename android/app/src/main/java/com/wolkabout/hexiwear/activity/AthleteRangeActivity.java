package com.wolkabout.hexiwear.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.wolkabout.hexiwear.R;

/**
 * This class presents a user interface with four edit text fields, two for setting high and low
 * desired ranges for steps, and two for doing the same with heart rate. There is an enter
 * button for setting the ranges for each, and a textview for displaying the ranges for each.
 * @author Scott Martell, Jenna McNeil
 */
public class AthleteRangeActivity extends AppCompatActivity{
    int stepRangeLow = 2000;
    int stepRangeHigh = 10000;
    int hrRangeLow = 80;
    int hrRangeHigh = 120;

    /**
     * This method creates the athlete range activity ui.
     * @param savedInstanceState not sure what it does.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athlete_range);

        //initializing ui elements
        final EditText stepLow = (EditText) findViewById(R.id.stepLow);
        final EditText stepHigh = (EditText) findViewById(R.id.stepHigh);
        final EditText hrLow = (EditText) findViewById(R.id.hrLow);
        final EditText hrHigh = (EditText) findViewById(R.id.hrHigh);
        final Button stepEnter = (Button) findViewById(R.id.stepEnter);
        final Button hrEnter = (Button) findViewById(R.id.hrEnter);
        final Button rangeBack = (Button) findViewById(R.id.rangeBack);
        final TextView hrSetRange = (TextView) findViewById(R.id.hrSetRange);
        final TextView stepSetRange = (TextView) findViewById(R.id.stepSetRange);

        stepEnter.setOnClickListener(new View.OnClickListener(){
            /**
             * On click sets the step ranges or lets the user know the range is invalid.
             * @param view sets the ui.
             */
            public void onClick(View view){
                stepRangeLow = Integer.parseInt(stepLow.getText().toString());
                stepRangeHigh = Integer.parseInt(stepHigh.getText().toString());
                if(stepRangeLow > stepRangeHigh){
                    stepSetRange.setText("Steps: Invalid range.");
                }
                else if(stepRangeLow == 0 && stepRangeHigh == 0){
                    stepSetRange.setText("Steps: No range set.");
                }
                else{
                    stepSetRange.setText("Steps: "+stepRangeLow+" to "+stepRangeHigh+".");
                }
            }
        });
        hrEnter.setOnClickListener(new View.OnClickListener(){
            /**
             * On click sets the heart rate ranges or lets the user know the range is invalid.
             * @param view sets the ui.
             */
            public void onClick(View view){
                hrRangeLow = Integer.parseInt(hrLow.getText().toString());
                hrRangeHigh = Integer.parseInt(hrHigh.getText().toString());
                if(hrRangeLow > hrRangeHigh){
                    hrSetRange.setText("Heart Rate: Invalid range.");
                }
                else if(hrRangeLow == 0 && hrRangeHigh == 0){
                    hrSetRange.setText("Heart Rate: No range set.");
                }
                else{
                    hrSetRange.setText("Heart Rate: "+hrRangeLow+" to "+hrRangeHigh+".");
                }
            }
        });
        rangeBack.setOnClickListener(new View.OnClickListener(){
            /**
             * On click opens the Athlete activity ui.
             * @param view sets the ui.
             */
            public void onClick(View view){
                Intent athlete = new Intent(view.getContext(), AthleteActivity.class);
                startActivityForResult(athlete, 0);
            }
        });

        //checks the initial values for stepRangeLow and stepRangeHigh
        if(stepRangeLow > stepRangeHigh){
            stepSetRange.setText("Steps: Invalid range.");
        }
        else if(stepRangeLow == 0 && stepRangeHigh == 0){
            stepSetRange.setText("Steps: No range set.");
        }
        else{
            stepSetRange.setText("Steps: "+stepRangeLow+" to "+stepRangeHigh+".");
        }

        //checks the initial values for hrRangeLow and hrRangeHigh
        if(hrRangeLow > hrRangeHigh){
            hrSetRange.setText("Heart Rate: Invalid range.");
        }
        else if(hrRangeLow == 0 && hrRangeHigh == 0){
            hrSetRange.setText("Heart Rate: No range set.");
        }
        else{
            hrSetRange.setText("Heart Rate: "+hrRangeLow+" to "+hrRangeHigh+".");
        }
    }

    /**
     * Setter for stepRangeLow.
     * @param stepRangeLow low end of range for steps
     */
    public void setStepRangeLow(int stepRangeLow){this.stepRangeLow = stepRangeLow;}

    /**
     * Setter for stepRangeHigh.
     * @param stepRangeHigh high end of range for steps
     */
    public void setStepRangeHigh(int stepRangeHigh){this.stepRangeHigh = stepRangeHigh;}

    /**
     * Setter for hrRangeLow.
     * @param hrRangeLow low end of range for heart rate
     */
    public void setHrRangeLow(int hrRangeLow){this.hrRangeLow = hrRangeLow;}

    /**
     * Setter for hrRangeHigh.
     * @param hrRangeHigh high end of range for heart rate
     */
    public void setHrRangeHigh(int hrRangeHigh){this.hrRangeHigh = hrRangeHigh;}

    /**
     * getter for stepRangeLow.
     * @return stepRangeLow
     */
    public int getStepLow(){
        return stepRangeLow;
    }

    /**
     * getter for stepRangeHigh.
     * @return stepRangeHigh
     */
    public int getStepHigh(){
        return stepRangeHigh;
    }

    /**
     * getter for hrRangeLow.
     * @return hrRangeLow
     */
    public int getHrLow(){
        return hrRangeLow;
    }

    /**
     * getter for hrRangeHigh.
     * @return hrRangeHigh
     */
    public int getHrHigh(){
        return hrRangeHigh;
    }
}
