package com.example.lesson8splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuizSplashActivity extends QuizActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_splash);

        SharedPreferences lastTime = getSharedPreferences(LAST_LAUNCH, MODE_PRIVATE);
        Date now = new Date();
        /**
         * SimpleDateFormat has short text date, a space, short text month, a space, 2-digit
         * date, a space, hour(0-23), minute, second, a space, short timezone, a final space
         * and a long year
         */
        SimpleDateFormat format =
                new SimpleDateFormat ("EEE MMM dd HH:mm:ss zzz yyyy");
        Log.i("dateTime", "In QuizSplashActivity");
        if (lastTime.contains("dateTime") == true) {
            //We have recorded the last time we used the game
            String dateTime = lastTime.getString("dateTime", "Default");
            Log.i("dateTime", "In QuizSplashActivity: " + dateTime);
        }
        SharedPreferences.Editor dateEditor = lastTime.edit();
        //dateEditor.putString("dateTime",
        // DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT).format(now));
        //Using SimpleDateFormat: substitute the above second arg to ->>> format.format(now)
        dateEditor.putString("dateTime",format.format(now));
        dateEditor.commit();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_splash);

        ImageView logo1 = (ImageView) findViewById(R.id.image1);
        Animation fade1 = AnimationUtils.loadAnimation(this, R.anim.image1);
        logo1.startAnimation(fade1);

        ImageView logo2 = (ImageView) findViewById(R.id.image2);
        Animation fade2 = AnimationUtils.loadAnimation(this, R.anim.image2);
        logo2.startAnimation(fade2);

        fade1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                abrirMenuPrincipal(QuizMenuActivity.class);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });



    }

    protected void onPause(){
        super.onPause();
        ImageView logo1 = (ImageView) findViewById(R.id.image1);
        logo1.clearAnimation();
        ImageView logo2 = (ImageView) findViewById(R.id.image2);
        logo2.clearAnimation();

    }

    public void abrirMenuPrincipal(Class c){
        Intent intent = new Intent(this,c);
        startActivity(intent);
    }




}
