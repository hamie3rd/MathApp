package com.example.mathapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Choose_A_Category extends AppCompatActivity {

    public void basicOperators(View view){
        Intent intent = new Intent(getApplicationContext(), BasicOperators.class);
        startActivity(intent);
    }

    public void logout(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose__a__category);

        setTitle("Choose a Category");
    }
}
