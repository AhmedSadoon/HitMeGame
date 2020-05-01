package com.example.hitmegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvGuessPoint;
    Button bHitMe,btnRestart;
    EditText etInput;
    int Bets, Hit, Guess;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //هاي اخذنة المعلومات من الاكتفتي الثانية
        final Intent intent = getIntent();

        final String DiffLevel = intent.getStringExtra("DiffLevel");
        Guess = intent.getIntExtra("Guess", 0);
        Bets = intent.getIntExtra("Bets", 0);


        tvGuessPoint = findViewById(R.id.tvGuessPoint);
        bHitMe = findViewById(R.id.bHitMe);
        btnRestart=findViewById(R.id.btn_Restart);
        etInput = findViewById(R.id.etInputHit);
        tvGuessPoint.setText("The Guess is :"+Guess);

        bHitMe.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                String Hits = etInput.getText().toString();
                if (Hits.matches("")) {
                    Toast.makeText(MainActivity.this, "Enter The Hit", Toast.LENGTH_SHORT).show();
                } else {

                    Hit = Integer.valueOf(etInput.getText().toString());

                    if (DiffLevel.equals("Easy")) {
                        if (Guess >= 1) {
                            Guess -= 1;
                            tvGuessPoint.setText("The Guess is :"+Guess);
                            if (Hit <= 9) {
                                if (Bets == Hit) {
                                    Intent intent = new Intent(MainActivity.this, WinnerActivity.class);
                                    MainActivity.this.startActivity(intent);
                                } else {
                                    Toast.makeText(MainActivity.this, "Hit Again", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Guess += 1;
                                tvGuessPoint.setText("The Guess is :"+Guess);
                                Toast.makeText(MainActivity.this, "You are out of range", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Intent intent = new Intent(MainActivity.this, LoserActivity.class);
                            MainActivity.this.startActivity(intent);
                        }


                    } else if (DiffLevel.equals("Normal")) {

                        if (Guess >= 1) {
                            Guess -= 1;
                            tvGuessPoint.setText("The Guess is :"+Guess);
                            if (Hit <= 50) {
                                if (Bets == Hit) {
                                    Intent intent = new Intent(MainActivity.this, WinnerActivity.class);
                                    MainActivity.this.startActivity(intent);
                                } else {
                                    Toast.makeText(MainActivity.this, "Hit Again", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Guess += 1;
                                tvGuessPoint.setText("The Guess is :"+Guess);
                                Toast.makeText(MainActivity.this, "You are out of range", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Intent intent = new Intent(MainActivity.this, LoserActivity.class);
                            MainActivity.this.startActivity(intent);
                        }
                    }

                    //Hard
                    else {

                        if (Guess >= 1) {
                            Guess -= 1;
                            tvGuessPoint.setText("The Guess is :"+Guess);
                            if (Hit <= 100) {
                                if (Bets == Hit) {
                                    Intent intent = new Intent(MainActivity.this, WinnerActivity.class);
                                    MainActivity.this.startActivity(intent);
                                } else {
                                    Toast.makeText(MainActivity.this, "Hit Again", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Guess += 1;
                                tvGuessPoint.setText("The Guess is :"+Guess);
                                Toast.makeText(MainActivity.this, "You are out of range", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Intent intent = new Intent(MainActivity.this, LoserActivity.class);
                            MainActivity.this.startActivity(intent);
                        }

                    }

                }
            }
        });

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent  intent=new Intent(MainActivity.this,DifficultActivity.class);
              MainActivity.this.startActivity(intent);

            }
        });


    }

    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(this, DifficultActivity.class);
        this.startActivity(intent);
    }


}
