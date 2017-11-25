package fhkufstein.ac.at.ernestorun;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import fhkufstein.ac.at.ernestorun.Classes.ImageAdapter;
import fhkufstein.ac.at.ernestorun.Classes.ImageAdapterBad;
import fhkufstein.ac.at.ernestorun.Classes.ImageAdapterEnd;
import fhkufstein.ac.at.ernestorun.Classes.ImageAdapterGood;

public class IconsActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icons);

        getSupportActionBar().hide();

        TextView textView = (TextView)findViewById(R.id.textviewicon);

        GridView gridview = (GridView) findViewById(R.id.gridview);

        Intent intent = getIntent();
        String message = intent.getStringExtra(InfoActivity.EXTRA_MESSAGE);

        if (message.equals("good")) {

            gridview.setAdapter(new ImageAdapterGood(this));
            textView.setText("Was Ernesto mag!");

        } else if (message.equals("bad")){

            gridview.setAdapter(new ImageAdapterBad(this));
            textView.setText("Was Ernesto nicht mag!");

        } else if (message.equals("end")){

            gridview.setAdapter(new ImageAdapterEnd(this));
            textView.setText("Game Over!");

        } else {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }

        textView.setTextColor(Color.BLACK);







            }

            public void chooseAdapter(String message){

            if (message == "good"){

            }

            }

        };







