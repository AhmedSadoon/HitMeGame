package com.example.hitmegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BetsActivity extends AppCompatActivity {

    Button btnStart,btnRestartBets;
    EditText etInputBets;
    String DiffLevel;
    int Guess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bets);
        btnStart = findViewById(R.id.btnStart);
        btnRestartBets=findViewById(R.id.btnRestartBets);
        etInputBets = findViewById(R.id.etInputBets);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               //Intent intent2 = getIntent();
               //DiffLevel = intent2.getStringExtra("DiffLevel");
               //Guess = intent2.getIntExtra("Guess", 0);

               ////دزينة المعلومات من هاي الاكتفتي الى الصفحة الرئيسية
               //Intent intent = new Intent(BetsActivity.this, MainActivity.class);

               //int LimitBets=Integer.valueOf( etInputBets.getText().toString());

               //if (DiffLevel.equals("Easy")) {
               //    if (LimitBets > 9) {
               //        Toast.makeText(BetsActivity.this, "You are out of range", Toast.LENGTH_SHORT).show();
               //    } else{

               //        intent.putExtra("Bets", Integer.valueOf(etInputBets.getText().toString()));
               //        intent.putExtra("DiffLevel", DiffLevel);
               //        intent.putExtra("Guess", Guess);
               //        BetsActivity.this.startActivity(intent);
               //    }

               //}else if(DiffLevel.equals("Normal")){

               //    if (LimitBets > 50) {
               //        Toast.makeText(BetsActivity.this, "You are out of range", Toast.LENGTH_SHORT).show();
               //    } else{

               //        intent.putExtra("Bets", Integer.valueOf(etInputBets.getText().toString()));
               //        intent.putExtra("DiffLevel", DiffLevel);
               //        intent.putExtra("Guess", Guess);
               //        BetsActivity.this.startActivity(intent);
               //    }

               //}else if (DiffLevel.equals("Hard")){
               //    if (LimitBets > 100) {
               //        Toast.makeText(BetsActivity.this, "You are out of range", Toast.LENGTH_SHORT).show();
               //    } else{

               //        intent.putExtra("Bets", Integer.valueOf(etInputBets.getText().toString()));
               //        intent.putExtra("DiffLevel", DiffLevel);
               //        intent.putExtra("Guess", Guess);
               //        BetsActivity.this.startActivity(intent);
               //    }
               //}


                String Bets=etInputBets.getText().toString();

               if(Bets.matches("")){
                   Toast.makeText(BetsActivity.this,"Enter the bets",Toast.LENGTH_SHORT).show();
               }else {
                   Intent intent2 = getIntent();
                   DiffLevel = intent2.getStringExtra("DiffLevel");
                   Guess = intent2.getIntExtra("Guess", 0);

                   //دزينة المعلومات من هاي الاكتفتي الى الصفحة الرئيسية
                   Intent intent = new Intent(BetsActivity.this, MainActivity.class);
                   int LimitBets=Integer.valueOf( etInputBets.getText().toString());


                   if (DiffLevel.equals("Easy")) {
                       if (LimitBets > 9) {
                           Toast.makeText(BetsActivity.this, "You are out of range", Toast.LENGTH_SHORT).show();
                       } else{

                           intent.putExtra("Bets", Integer.valueOf(etInputBets.getText().toString()));
                           intent.putExtra("DiffLevel", DiffLevel);
                           intent.putExtra("Guess", Guess);
                           BetsActivity.this.startActivity(intent);
                       }

                   }else if(DiffLevel.equals("Normal")){

                       if (LimitBets > 50) {
                           Toast.makeText(BetsActivity.this, "You are out of range", Toast.LENGTH_SHORT).show();
                       } else{

                           intent.putExtra("Bets", Integer.valueOf(etInputBets.getText().toString()));
                           intent.putExtra("DiffLevel", DiffLevel);
                           intent.putExtra("Guess", Guess);
                           BetsActivity.this.startActivity(intent);
                       }

                   }else if (DiffLevel.equals("Hard")){
                       if (LimitBets > 100) {
                           Toast.makeText(BetsActivity.this, "You are out of range", Toast.LENGTH_SHORT).show();
                       } else{

                           intent.putExtra("Bets", Integer.valueOf(etInputBets.getText().toString()));
                           intent.putExtra("DiffLevel", DiffLevel);
                           intent.putExtra("Guess", Guess);
                           BetsActivity.this.startActivity(intent);
                       }
                   }


               }



            }
        });

        btnRestartBets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent=new Intent(BetsActivity.this,DifficultActivity.class);
                BetsActivity.this.startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(this,DifficultActivity.class);
        this.startActivity(intent);
    }


}
