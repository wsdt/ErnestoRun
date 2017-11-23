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
        findViewById(R.id.turtle).setOnClickListener(this);
        getSupportActionBar().hide();

        ImageButton snailAnimation = (ImageButton) findViewById(R.id.snail);
        ((AnimationDrawable) snailAnimation.getBackground()).start();

        ImageButton raupeAnimation = (ImageButton) findViewById(R.id.raupe);
        ((AnimationDrawable) raupeAnimation.getBackground()).start();

        ImageButton turtleAnimation = (ImageButton) findViewById(R.id.turtle);
        ((AnimationDrawable) turtleAnimation.getBackground()).start();

    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, GameActivity.class);
        i.putExtra("character", R.id.snail == view.getId() ? R.drawable.snail : (R.id.raupe == view.getId() ? R.drawable.raupe : R.drawable.turtle));
        startActivity(i);
    }
}
