 package com.example.wordpuzzle;

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

 public class MainActivity extends AppCompatActivity {

    Button btnEasy, btnMedium, btnHard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEasy=(Button) findViewById(R.id.btnEasy);
        btnMedium=(Button) findViewById(R.id.btnMedium);
        btnHard=(Button) findViewById(R.id.btnHard);

        btnEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toEasy();
            }
        });

        btnMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMedium();
            }
        });

        btnHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toHard();
            }
        });


    }

    public void toEasy(){
        Intent intent = new Intent(this, Easy.class);
        startActivity(intent);
        finish();
    }

     public void toMedium(){
         Intent intent = new Intent(this, Medium.class);
         startActivity(intent);
         finish();
     }

     public void toHard(){
         Intent intent = new Intent(this, Hard.class);
         startActivity(intent);
         finish();
     }

}