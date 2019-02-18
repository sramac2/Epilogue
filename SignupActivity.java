package com.example.android.epilogue;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    EditText fName;
    EditText lName;
    EditText dob;
    Spinner numerSpinner;
    Spinner termSpinner;
    Button submit;
    ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        numerSpinner = findViewById(R.id.number_spinner);
        termSpinner = findViewById(R.id.term_spinner);
        dob = findViewById(R.id.dob);
        lName = findViewById(R.id.last_name);
        fName = findViewById(R.id.first_name);
        submit = findViewById(R.id.submit);
        progressDialog = new ProgressDialog(this);




        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(dob.getText().toString(),0,"months",
                        (fName.getText().toString()+lName.getText().toString()));
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Users");
                myRef.setValue(user);
                progressDialog.setMessage("Loading...");
                progressDialog.show();
                Intent intent = new Intent(SignupActivity.this,StatsActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
