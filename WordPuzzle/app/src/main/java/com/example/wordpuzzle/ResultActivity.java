package com.example.wordpuzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView resultLabel = (TextView) findViewById(R.id.resultLabel);
        TextView totalScoreLabel = (TextView) findViewById(R.id.totalScoreLabel);

        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);

        SharedPreferences settings = getSharedPreferences("wordPuzzle", Context.MODE_PRIVATE);
        int totalScore = settings.getInt("totalScore", 0);

        totalScore += score;

        resultLabel.setText((score + " / 10"));
        totalScoreLabel.setText("Total Score: " + totalScore);

        editor = settings.edit();
        editor.putInt("totalScore", totalScore);
        editor.apply();
    }

    public void returnTop(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

    public void clearTotalScore(View view) {
        editor.clear();
        editor.apply();

        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }
}