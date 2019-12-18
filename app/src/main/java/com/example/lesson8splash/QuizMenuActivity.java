package com.example.lesson8splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class QuizMenuActivity extends QuizActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_menu);
    }

    public void seleccionarActividad(View view){
        switch (view.getId()){
            case R.id.botonJugar:
                abrirActividad(QuizGameActivity.class);
                break;
            case R.id.botonPuntuaciones:
                abrirActividad((QuizScoresActivity.class));
                break;
            case R.id.botonOpciones:
                abrirActividad((QuizSettingsActivity.class));
                break;
            case R.id.botonAyuda:
                abrirActividad((QuizHelpActivity.class));
                break;
        }
    }


    public void abrirActividad(Class c){
        Intent intent = new Intent(this,c);
        startActivity(intent);
    }


}
