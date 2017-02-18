package com.example.xtrem.werkit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * Created by YaHeng on 2017-02-16.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {

    private ArrayList<Exercises> mDataset;
    private Context context;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtHeader;
        public Button exerciseButton;

        public ViewHolder(View v) {
            super(v);
            txtHeader = (TextView) v.findViewById(R.id.exercise_name);
            exerciseButton = (Button) v.findViewById(R.id.view_exercise_button);


        }


    }

    public RecycleAdapter(Context context, ArrayList<Exercises> myDataset) {
        mDataset = myDataset;
        this.context = context;
    }

    private Context getContext() {
        return context;
    }

    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // create a new view
        View v = inflater.inflate(R.layout.exercise_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Exercises exercises = mDataset.get(position);

        TextView textView = holder.txtHeader;
        textView.setText(exercises.getExerciseName());

        // Return the size of your dataset (invoked by the layout manager)


    }

    @Override
    public int getItemCount () {
        return mDataset.size();
    }
}
