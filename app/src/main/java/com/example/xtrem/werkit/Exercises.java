package com.example.xtrem.werkit;

import java.util.ArrayList;

/**
 * Created by YaHeng on 2017-02-17.
 */

public class Exercises {

    private String exerciseName;
    private String typeofExercise;
    private int reps;
    private int sets;
    private int weightPounds;
    private boolean isTimed;
    private boolean isDistance;
    public Exercises (String exerciseName, String typeofExercise, int reps, int sets, int weightPounds,
                      boolean isTimed, boolean isDistance){
        this.exerciseName = exerciseName;
        this.typeofExercise = typeofExercise;
        this.reps = reps;
        this.sets = sets;
        this.weightPounds = weightPounds;
        this.isTimed = isTimed;
        this.isDistance = isDistance;

    }

    public String getExerciseName(){
        return exerciseName;
    }
    public String getTypeofExercise(){
        return typeofExercise;
    }
    public int getReps()
    {
        return reps;
    }
    public int getSets(){
        return sets;
    }
    public int getWeightPounds(){
        return weightPounds;
    }
    public boolean isTimed(){
        return isTimed;
    }
    public boolean isDistance(){
        return isDistance;
    }


    public static ArrayList<Exercises> createExerisesList(int numExercises) {
        ArrayList<Exercises> exercises = new ArrayList<Exercises>();


        for (int i = 1; i <= numExercises; i++) {
            exercises.add(new Exercises("Exercise 1","Arms", 10, 3, 45, false, false));
        }

        return exercises;
    }

}
