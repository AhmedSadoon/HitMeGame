package com.example.hitmegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoserActivity extends AppCompatActivity {

    Button btnRestartLoser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loser);

        btnRestartLoser=findViewById(R.id.btnRestartLoser);

        btnRestartLoser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoserActivity.this,DifficultActivity.class);
                    LoserActivity.this.startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(this,DifficultActivity.class);
        startActivity(intent);
    }


}
