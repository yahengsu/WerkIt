package com.example.xtrem.werkit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


public class EditExercisesActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static final String FILENAME_WORKOUTS = "workouts";
    public static final String FILENAME_EXERCISES = "exercises";
    public static final String FILENAME_HISTORY = "history";

    private EditText ExerciseNameEditText;
    private EditText ExerciseWeightEditText;
    private EditText ExerciseRepsEditText;
    private EditText ExerciseSetsEditText;
    private EditText ExerciseTimeEditText;

    private String exerciseName;
    private String typeofExercise;

    private int reps;
    private int sets;
    private int weightPounds;

    private boolean isTimed;
    private boolean isDistance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_exercises);
        Spinner spinner = (Spinner) findViewById(R.id.ExerciseTypeSpinner);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.exercisetype_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ExerciseNameEditText = (EditText) findViewById(R.id.ExerciseNameEditText);
        ExerciseWeightEditText = (EditText) findViewById(R.id.ExerciseWeightEditText);
        ExerciseRepsEditText = (EditText) findViewById(R.id.ExerciseRepsEditText);
        ExerciseSetsEditText = (EditText) findViewById(R.id.ExerciseSetsEditText);
        ExerciseTimeEditText = (EditText) findViewById(R.id.ExerciseTimeEditText);
        exerciseName = ExerciseNameEditText.getText().toString();

    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
       String item = parent.getItemAtPosition(pos).toString();

        typeofExercise = item;

    }

    public void onNothingSelected(AdapterView<?> parent) {

    }
}
