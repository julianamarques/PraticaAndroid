package com.app.miniquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ThirdQuestion extends Question {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_question);
    }

    public void goToNextQuestion(View view) {
        super.goToNextQuestion(R.id.alternative2, "com.app.miniquiz.FourthQuestion");
    }
}
