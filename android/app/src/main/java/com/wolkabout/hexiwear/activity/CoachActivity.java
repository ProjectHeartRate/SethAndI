package com.wolkabout.hexiwear.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.FirebaseDatabase;
import com.wolkabout.hexiwear.HexiwearApplication_;
import com.wolkabout.hexiwear.R;


/**
 * This class, currently does nothing but open an empty screen. Eventually it will be show
 * the user interface for the coach.
 * @author Scott Martell, Jenna McNeil
 */
public class CoachActivity extends AppCompatActivity {

    private FirebaseListAdapter<Athlete> firebaseAdapter;
    private ListView athleteList;
    private Button coachBack;
    private Button createAthlete;

    /**
     * This method creates the coach activity user interface.
     * @param savedInstanceState not sure what it does.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach);

        //Get the app wide shared variables
        HexiwearApplication_ appData = (HexiwearApplication_)getApplication();

        //Set-up Firebase
        appData.firebaseDBInstance = FirebaseDatabase.getInstance();
        appData.firebaseReference = appData.firebaseDBInstance.getReference("athletes");

        //Get the reference to the UI contents
        athleteList = (ListView) findViewById(R.id.athleteList);
        coachBack = (Button) findViewById(R.id.coachBack);
        createAthlete = (Button) findViewById(R.id.createAthlete);

        //Set up the List View
        firebaseAdapter = new FirebaseListAdapter<Athlete>(this, Athlete.class, android.R.layout.simple_list_item_1, appData.firebaseReference) {
            /**
             * This method populates the list view with information gathered from firebase.
             * @param v View object.
             * @param model a contact object with all of the contact information.
             * @param position position in the list.
             */
            @Override
            protected void populateView(View v, Athlete model, int position) {
                TextView athleteName = (TextView)v.findViewById(android.R.id.text1);
                athleteName.setText(model.name);
            }
        };
        athleteList.setAdapter(firebaseAdapter);
        athleteList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            /**
             * On click opens CreateAthlete ui.
             * @param view sets the ui.
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Athlete person = (Athlete) firebaseAdapter.getItem(position);
                showAthleteActivity(person);

            }
        });
    }

    /**
     * When a user in the list view is clicked, an interface will open the AthleteActivity ui.
     * @param person Contact object to be displayed.
     */
    private void showAthleteActivity(Athlete person) {
        Intent intent = new Intent(this, AthleteActivity.class);
        intent.putExtra("Athlete", person);
        startActivity(intent);
    }

    /**
     * On click opens CreateAthlete ui.
     * @param view sets the ui.
     */
    public void showCreateAthlete(View view){
        Intent createAthlete = new Intent(this, CreateAthleteActivity.class);
        startActivity(createAthlete);
    }

    /**
     * On click opens MainActivity ui.
     * @param view sets the ui.
     */
    public void showMainActivity(View view){
        Intent main = new Intent(this, StartActivity.class);
        startActivity(main);
    }

}
