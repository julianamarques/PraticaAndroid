package com.app.miniquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FourthQuestion extends Question {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_question);
    }

    public void goToNextQuestion(View view) {
        super.goToNextQuestion(R.id.alternative4, "com.app.miniquiz.FifthQuestion");
    }
}
