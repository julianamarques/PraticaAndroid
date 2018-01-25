package com.app.miniquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FirstQuestion extends Question {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_question);
    }

    public void goToNextQuestion(View view) {
        super.goToNextQuestion(R.id.alternative1, "com.app.miniquiz.SecondQuestion");
    }
}
