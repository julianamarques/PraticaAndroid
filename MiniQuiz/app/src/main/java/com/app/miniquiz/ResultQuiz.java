package com.app.miniquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultQuiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_quiz);
        showScore();
    }

    public void backToStart(View view) {
        Intent intent = new Intent("com.app.miniquiz.MainActivity");
        startActivity(intent);
    }

    public void showScore() {
        TextView score = (TextView) findViewById(R.id.score);
        score.setText("" + MainActivity.getScore());
        MainActivity.setScore();
    }
}
