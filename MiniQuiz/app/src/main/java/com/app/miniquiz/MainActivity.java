package com.app.miniquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    static int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startQuiz(View view) {
        Intent intent = new Intent("com.app.miniquiz.FirstQuestion");
        startActivity(intent);
    }

    public static void increaseScore() {
        score++;
    }

    public static int getScore() {
        return score;
    }

    public static void setScore() {
        score = 0;
    }

}
