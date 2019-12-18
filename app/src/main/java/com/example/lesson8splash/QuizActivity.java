package com.example.lesson8splash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class QuizActivity extends android.app.Activity {
    public static final String LAST_LAUNCH ="pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }
}
