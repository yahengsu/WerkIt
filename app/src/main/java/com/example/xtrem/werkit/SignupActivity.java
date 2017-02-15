package com.example.xtrem.werkit;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.R.attr.password;

public class SignupActivity extends AppCompatActivity {

    private EditText FirstName;
    private EditText LastName;
    private EditText Email;
    private EditText Password;
    private Button SignupButton;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final String TAG = "FirebaseAuth";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        FirstName = (EditText) findViewById(R.id.EditTextFirstNameSignupActivity);
        LastName = (EditText) findViewById(R.id.EditTextLastNameSignupActivity);
        Email = (EditText) findViewById(R.id.EditTextEmailSignupActivity);
        Password = (EditText) findViewById(R.id.EditTextPasswordSignupActivity);
        SignupButton = (Button) findViewById(R.id.SignupButtonSignupActivity);

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };

        final String email = Email.getText().toString();
        final String password = Password.getText().toString();

        SignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAccount(email,password);
                Intent i = new Intent(view.getContext(),LoginActivity.class);
                startActivity(i);
            }
        });

    }


    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    private void createAccount(String email, String password) {
        Log.d(TAG, "createAccount:" + email);
        if (!validateForm()) {
            return;
        }


        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(SignupActivity.this, "Auth Failed",
                                    Toast.LENGTH_SHORT).show();
                        }



                    }
                });

        // [END create_user_with_email]
    }

    private boolean validateForm() {
        boolean valid = true;

        String email = Email.getText().toString();
        if (TextUtils.isEmpty(email)) {
            Email.setError("Required.");
            valid = false;
        } else {
            Email.setError(null);
        }

        String password = Password.getText().toString();
        if (TextUtils.isEmpty(password)) {
            Password.setError("Required.");
            valid = false;
        } else {
            Password.setError(null);
        }

        return valid;
    }




}

