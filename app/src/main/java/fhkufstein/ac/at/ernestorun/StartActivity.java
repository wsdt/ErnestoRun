package fhkufstein.ac.at.ernestorun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class StartActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        findViewById(R.id.snail).setOnClickListener(this);
        findViewById(R.id.raupe).setOnClickListener(this);
        findViewById(R.id.turtle).setOnClickListener(this);
        getSupportActionBar().hide();

    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, GameActivity.class);
        i.putExtra("character", R.id.snail == view.getId() ? R.drawable.animals_1 : R.id.raupe == view.getId() ? R.drawable.animals_2 : R.drawable.animals_4);
        startActivity(i);
    }
}
