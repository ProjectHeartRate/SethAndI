package com.wolkabout.hexiwear.activity;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * This class creates an object that represents an athlete.
 * @author Scott Martell, Jenna McNeil.
 */
public class Athlete implements Serializable {

    public String name;
    public String uid;
    /* To be used later
    public String steps;
    public String heartRate;
    public String stepHigh;
    public String stepLow;
    public String hrHigh;
    public String hrLow;*/

    /**
     * Default constructor required for calls to DataSnapshot.getValue.
     */
    public Athlete() {
        //Default constructor.
    }

    /**
     * Constructor of Athlete object.
     * @param name name of athlete.
     */
    public Athlete(String uid,String name){
        this.uid = uid;
        this.name = name;
    }

    /**
     * Hashmap of stored data for the Athlete object.
     * @return result.
     */
    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("name", name);

        return result;
    }
}
