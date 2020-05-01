package com.example.hitmegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class WinnerActivity extends AppCompatActivity {

    Button btnRestartWin;
    ImageView ivFierWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        btnRestartWin=findViewById(R.id.btnRestartWin);
        ivFierWork=findViewById(R.id.ivFierWork);

        btnRestartWin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(WinnerActivity.this,DifficultActivity.class);
                WinnerActivity.this.startActivity(intent);
            }
        });

        ivFierWork.setImageResource(R.drawable.anim);
        AnimationDrawable animationDrawable=(AnimationDrawable) ivFierWork.getDrawable();
        animationDrawable.start();



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent=new Intent(this,DifficultActivity.class);
        startActivity(intent);
    }


}
