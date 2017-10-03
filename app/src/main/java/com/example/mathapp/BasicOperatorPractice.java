package com.example.mathapp;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class BasicOperatorPractice extends AppCompatActivity {

    Button buttonGo;
    Button buttonTL;
    Button buttonTR;
    Button buttonBL;
    Button buttonBR;
    Button buttonPlayAgain;
    Button buttonBack;
    TextView textViewTotal;
    TextView textViewTimer;
    TextView textViewQuestion;
    TextView textViewAnswer;
    Boolean isPlaying;
    int answerToProblem;
    int correctAmount;
    int questionsAnswered;

    public void back(View view){
        Intent intent = new Intent(getApplicationContext(), BasicOperators.class);
        startActivity(intent);
    }

    public void go(View view){
        buttonGo.setVisibility(View.INVISIBLE);
        buttonPlayAgain.setVisibility(View.INVISIBLE);
        buttonBack.setVisibility(View.INVISIBLE);
        buttonTL.setVisibility(View.VISIBLE);
        buttonTR.setVisibility(View.VISIBLE);
        buttonBL.setVisibility(View.VISIBLE);
        buttonBR.setVisibility(View.VISIBLE);
        textViewTotal.setVisibility(View.VISIBLE);
        textViewTimer.setVisibility(View.VISIBLE);
        textViewQuestion.setVisibility(View.VISIBLE);
        isPlaying = true;
        correctAmount = 0;
        questionsAnswered = 0;
        textViewTotal.setText(correctAmount + "/" + questionsAnswered);

        setQuestion();


        CountDownTimer countDownTimer = new CountDownTimer(30999,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textViewTimer.setText(String.valueOf(millisUntilFinished/1000) + "s");
            }

            @Override
            public void onFinish() {
                textViewTimer.setText("0s");
                buttonPlayAgain.setVisibility(View.VISIBLE);
                buttonBack.setVisibility(View.VISIBLE);
                isPlaying = false;

                textViewAnswer.setVisibility(View.VISIBLE);
                textViewAnswer.setText("You got " + correctAmount + " out of " + questionsAnswered + " right!");
            }
        }.start();
    }

    public void setQuestion(){
        Random x = new Random();
        int firstNumber = (x.nextInt(20 - 1) + 1);
        int secondNumber = (x.nextInt(20 - 1) + 1);
        //need to make this compatable with all operators//
        textViewQuestion.setText(firstNumber + " + " + secondNumber);
        answerToProblem = firstNumber + secondNumber;
        //to here//
        //only adjust the ones below to make them look believable//
        int[] choices = new int[4];
        int randomize = (x.nextInt(4));
        for (int i = 0; i < 4; i++){
            if (i == randomize){
                choices[i] = answerToProblem;
            } else {
                choices[i] = (x.nextInt(40 - 1) + 1);
                if (i > 0) {
                    for (int z = 0; z < i; z++) {
                        if (choices[i] == choices[z]) {
                            choices[i] += 1;
                        }
                    }
                }
            }
        }

        buttonTL.setText(String.valueOf(choices[0]));
        buttonTR.setText(String.valueOf(choices[1]));
        buttonBL.setText(String.valueOf(choices[2]));
        buttonBR.setText(String.valueOf(choices[3]));
    }

    public void answerQuestion(View view){
        if (isPlaying) {
            textViewAnswer.setVisibility(View.VISIBLE);
            String y = ((Button)view).getText().toString();
            int x = Integer.parseInt(y);
            if (answerToProblem == x) {
                textViewAnswer.setText("Correct!");
                correctAmount += 1;
            } else {
                textViewAnswer.setText("Incorrect");
            }
            questionsAnswered += 1;
            textViewTotal.setText(correctAmount + "/" + questionsAnswered);
            setQuestion();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_operator_practice);

        Intent intent = getIntent();
        // VARIABLES//
        buttonGo = (Button)findViewById(R.id.buttonGo);
        buttonTL = (Button)findViewById(R.id.buttonTL);
        buttonTR = (Button)findViewById(R.id.buttonTR);
        buttonBL = (Button)findViewById(R.id.buttonBL);
        buttonBR = (Button)findViewById(R.id.buttonBR);
        buttonPlayAgain = (Button)findViewById(R.id.buttonPlayAgain);
        buttonBack = (Button)findViewById(R.id.buttonBack);
        textViewTotal = (TextView)findViewById(R.id.textViewTotal);
        textViewTimer = (TextView)findViewById(R.id.textViewTimer);
        textViewQuestion = (TextView)findViewById(R.id.textViewQuestion);
        textViewAnswer = (TextView)findViewById(R.id.textViewAnswer);
        isPlaying = false;


    }
}