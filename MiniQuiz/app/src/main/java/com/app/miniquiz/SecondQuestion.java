package com.app.miniquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SecondQuestion extends Question {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_question);
    }

    public void goToNextQuestion(View view) {
        super.goToNextQuestion(R.id.alternative3, "com.app.miniquiz.ThirdQuestion");
    }
}
