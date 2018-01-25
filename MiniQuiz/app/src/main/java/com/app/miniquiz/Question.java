package com.app.miniquiz;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.TextView;

public abstract class Question extends AppCompatActivity {

    public void goToNextQuestion(int correctAlternative, String activity) {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.alternatives);
        TextView msg = (TextView) findViewById(R.id.msg);

        int id = radioGroup.getCheckedRadioButtonId();
        Intent intent = new Intent(activity);

        if (id == correctAlternative) {
            msg.setTextColor(Color.parseColor("#43e856"));
            msg.setText("Acertou!");
            MainActivity.increaseScore();
            startActivity(intent);
        }

        else if (id == -1) {
            msg.setTextColor(Color.parseColor("#ff0000"));
            msg.setText("Nenhuma alternativa selecionada!");
        }

        else {
            msg.setTextColor(Color.parseColor("#ff0000"));
            msg.setText("Errou!");
            startActivity(intent);
        }
    }
}
