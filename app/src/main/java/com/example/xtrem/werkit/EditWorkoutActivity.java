package com.example.xtrem.werkit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EditWorkoutActivity extends AppCompatActivity {
    public static final String FILENAME_WORKOUTS = "workouts";
    public static final String FILENAME_EXERCISES = "exercises";
    public static final String FILENAME_HISTORY = "history";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_workout);
    }



}
