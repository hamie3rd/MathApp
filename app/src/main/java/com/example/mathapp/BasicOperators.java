package com.example.mathapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BasicOperators extends AppCompatActivity {

    public void choosingBasicOperator(View view){
        Intent intent = new Intent(getApplicationContext(), BasicOperatorPractice.class);
        intent.putExtra("operator", view.getTag().toString());
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_operators);

        setTitle("Basic Operators");
    }
}
