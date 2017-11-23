package fhkufstein.ac.at.ernestorun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    public static Random r = new Random();
    //IMPORTANT: To keep everything working you need to set the following to countVars to the Anzahl of available pictures. We start counting at 1
    public static int countBackgroundImages = 1;
    public static int countBackgroundSounds = 0;
    private int difficultyConstant = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Set Character (Ernesto is default)
        setPlayer(getIntent().getIntExtra("character",R.drawable.animals_1));
        setRandomBackground();

        //Change Background after certain values in highscore
    }

    public void setRandomBackground() {
        (findViewById(R.id.gameContent)).setBackgroundResource(getResources().getIdentifier("background_"+r.nextInt((countBackgroundImages-1)+1)+1,"drawable",getPackageName()));
    }

    public void setPlayer(int drawable_id) {
        //auf item player classes
    }


}
