package com.example.wordpuzzle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Medium extends AppCompatActivity {

    private int rightAnswerCount = 0;
    private int quizCount = 1;
    static final private int QUIZ_COUNT = 10;

    TextView tvPuzzle, tvWord;
    EditText etGuess;
    Button btnSubmit, btnNext;
    Random r;

    String currentWord;

    String[] medium = {
            "sweet",
            "sour",
            "salt",
            "spicy",
            "hot",
            "cold",
            "warm",
            "tasty",
            "delicious",
            "fresh"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium);

        tvPuzzle=(TextView) findViewById(R.id.PickLevel);
        tvWord=(TextView) findViewById(R.id.tvWord);
        etGuess=(EditText) findViewById(R.id.etGuess);
        btnSubmit=(Button) findViewById(R.id.btnMedium);
        btnNext=(Button) findViewById(R.id.btnHard);

        r = new Random();

        newGame();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etGuess.getText().toString().equalsIgnoreCase(currentWord)){
                    rightAnswerCount++;

                    AlertDialog.Builder builder = new AlertDialog.Builder(Medium.this);
                    builder.setTitle("Correct Answer !");
                    builder.setMessage("Answer: " + currentWord);
                    builder.setPositiveButton("OK", null);
                    builder.show();

                    btnSubmit.setEnabled(false);
                    btnNext.setEnabled(true);
                }else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(Medium.this);
                    builder.setTitle("Wrong Answer !");
                    builder.setMessage("Answer: " + currentWord);
                    builder.setPositiveButton("OK", null);
                    builder.show();

                    btnNext.setEnabled(true);
                    btnSubmit.setEnabled(false);
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizCount == QUIZ_COUNT) {
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount);
                    startActivity(intent);
                    finish();
                } else {
                    quizCount++;
                    newGame();
                }
            }
        });

    }

    private String shuffleWord(String word){
        List<String> letters = Arrays.asList(word.split(""));
        Collections.shuffle(letters);
        String shuffled = "";
        for(String letter : letters){
            shuffled+=letter;
        }
        return shuffled;
    }

    private void newGame(){
        //get random word from arraylist
        currentWord = medium[r.nextInt(medium.length)];
        //shuffle word
        tvWord.setText(shuffleWord(currentWord));

        etGuess.setText("");
        btnNext.setEnabled(false);
        btnSubmit.setEnabled(true);

    }
}