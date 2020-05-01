package com.example.hitmegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Closeable;


public class DifficultActivity extends AppCompatActivity {


    TextView tvGuess, tvBets;
    RadioGroup RGDifficultyLevel;
    Button btnSelectDifficulty;
    int Guess;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficult);

        RGDifficultyLevel = findViewById(R.id.RGDifficultyLevel);
        btnSelectDifficulty = findViewById(R.id.btnSelectDifficulty);
        tvGuess = findViewById(R.id.tvGuess);
        tvBets = findViewById(R.id.tvBets);
        btnSelectDifficulty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int select = RGDifficultyLevel.getCheckedRadioButtonId();
                RadioButton rbDiff = findViewById(select);

                //دزينة المعلومات من هاي الاكتفتي الى الصفحة الرئيسية


                if (select == -1) {
                    Toast.makeText(DifficultActivity.this, "Should be select one", Toast.LENGTH_SHORT).show();

                } else {


                    Intent intent = new Intent(DifficultActivity.this, BetsActivity.class);
                    intent.putExtra("DiffLevel", rbDiff.getText().toString());

                    String Diff = intent.getStringExtra("DiffLevel");

                    if (Diff.equals("Easy")) {
                        Guess = 5;


                    } else if (Diff.equals("Normal")) {
                        Guess = 3;


                    } else {
                        Guess = 2;


                    }

                    intent.putExtra("Guess", Guess);


                    DifficultActivity.this.startActivity(intent);
                }


            }
        });


    }

    public void SelectDifficulty(View view) {

        int select = RGDifficultyLevel.getCheckedRadioButtonId();
        RadioButton rbDiff = findViewById(select);

        //Toast.makeText(this,rbDiff.getText().toString(),Toast.LENGTH_SHORT).show();

        //دزينة المعلومات من هاي الاكتفتي الى الصفحة الرئيسية
        Intent intent = new Intent(DifficultActivity.this, BetsActivity.class);
        intent.putExtra("DiffLevel", rbDiff.getText().toString());

        String Diff = intent.getStringExtra("DiffLevel");
        if (Diff.equals("Easy")) {
            Guess = 5;
            tvGuess.setText("The Guess is: " + Guess);
            tvBets.setText("The Bets is 0-9");

        } else if (Diff.equals("Normal")) {
            Guess = 3;
            tvGuess.setText("The Guess is: " + Guess);
            tvBets.setText("The Bets is 0-50");

        } else {
            Guess = 2;
            tvGuess.setText("The Guess is: " + Guess);
            tvBets.setText("The Bets is 0-100");

        }

    }


}
