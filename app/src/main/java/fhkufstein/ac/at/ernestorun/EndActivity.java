package fhkufstein.ac.at.ernestorun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        getSupportActionBar().hide();

        TextView pointView = (TextView) findViewById(R.id.textViewPoints);
        Button buttonBack = (Button)findViewById(R.id.btnBackToStart);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goBack();

            }
        });

        if(getIntent().hasExtra("score") == true){

            int score = getIntent().getExtras().getInt("score");

            String textübergabe = "Du hast " + score + " Punkte erreicht.";

            pointView.setText(textübergabe);

        }

    }

    public void goBack(){
        Intent intent = new Intent(EndActivity.this, StartActivity.class);
        startActivity(intent);
    }

}
