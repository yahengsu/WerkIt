package com.example.xtrem.werkit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class StartMenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startmenu);

        Button SignupButton = (Button) findViewById(R.id.SignupButtonStartActivity);
        SignupButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(view.getContext(),SignupActivity.class);
                startActivity(i);
            }
        });


        Button loginButton = (Button) findViewById(R.id.LoginButtonStartActivity);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(),LoginActivity.class);
                startActivity(i);
            }
        });



    }
}
