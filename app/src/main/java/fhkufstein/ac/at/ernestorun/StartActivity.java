package fhkufstein.ac.at.ernestorun;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import fhkufstein.ac.at.ernestorun.Classes.Mediaplayer;

public class StartActivity extends AppCompatActivity implements View.OnClickListener{
    Mediaplayer mediaplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        final ImageButton buttonInfo = findViewById(R.id.infoButton);
        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startInfoActivity();
            }
        });

        getSupportActionBar().hide();

        addCharacters();
        startIntroMusik();

    }

    @Override
    public void onPause() {
        super.onPause();
        mediaplayer.pauseMusik();
    }
    @Override
    public void onResume() {
        super.onResume();
        mediaplayer.resumeMusik();
    }

    public void startIntroMusik() {
        mediaplayer = new Mediaplayer(this,R.raw.intromusik);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, GameActivity.class);
        i.putExtra("character",
                view.getId()==R.id.snail ? R.drawable.snail :
                view.getId()==R.id.raupe ? R.drawable.raupe :
                        view.getId()==R.id.duck ? R.drawable.duck :
                                view.getId()==R.id.turtle ? R.drawable.turtle : R.drawable.chick);
        startActivity(i);
    }

    public void startInfoActivity(){
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }

    public void addCharacters() {
        findViewById(R.id.snail).setOnClickListener(this);
        findViewById(R.id.raupe).setOnClickListener(this);
        findViewById(R.id.duck).setOnClickListener(this);
        findViewById(R.id.turtle).setOnClickListener(this);
        findViewById(R.id.chick).setOnClickListener(this);

        ImageButton snailAnimation = (ImageButton) findViewById(R.id.snail);
        ((AnimationDrawable) snailAnimation.getBackground()).start();

        ImageButton raupeAnimation = (ImageButton) findViewById(R.id.raupe);
        ((AnimationDrawable) raupeAnimation.getBackground()).start();

        ImageButton duckAnimation = (ImageButton) findViewById(R.id.duck);
        ((AnimationDrawable) duckAnimation.getBackground()).start();

        ImageButton turtleAnimation = (ImageButton) findViewById(R.id.turtle);
        ((AnimationDrawable) turtleAnimation.getBackground()).start();

        ImageButton chickAnimation = (ImageButton) findViewById(R.id.chick);
        ((AnimationDrawable) chickAnimation.getBackground()).start();
    }
}
