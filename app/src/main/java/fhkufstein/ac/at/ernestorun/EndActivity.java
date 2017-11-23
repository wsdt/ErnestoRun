package fhkufstein.ac.at.ernestorun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        getSupportActionBar().hide();

        TextView pointView = (TextView) findViewById(R.id.textViewPoints);

        if(getIntent().hasExtra("score") == true){

            long score = getIntent().getExtras().getLong("score");

            String textübergabe = "Du hast " + score + " Punkte erreicht.";

            pointView.setText(textübergabe);

        }

    }
}
