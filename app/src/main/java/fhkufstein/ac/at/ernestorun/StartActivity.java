package fhkufstein.ac.at.ernestorun;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class StartActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        findViewById(R.id.snail).setOnClickListener(this);
        findViewById(R.id.raupe).setOnClickListener(this);
        findViewById(R.id.duck).setOnClickListener(this);
        findViewById(R.id.turtle).setOnClickListener(this);
        findViewById(R.id.chick).setOnClickListener(this);
        getSupportActionBar().hide();

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
}
