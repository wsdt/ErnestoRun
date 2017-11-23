package fhkufstein.ac.at.ernestorun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.NumberPicker;
import android.widget.TextView;

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
        getSupportActionBar().hide();

        //Set Character (Ernesto is default)
        setPlayer(getIntent().getIntExtra("character",R.drawable.animals_1));
        changeLevel();

        //Change Background after certain values in highscore
        //TODO: CALL METHOD changeLevel() when item gets eaten, so a method in item classes have to call it.
    }


    public void changeLevel() {
        //IMPORTANT: We need also the same amount of background images and background sounds (img_1 will be called with sound_1)
        int randomnr = r.nextInt((countBackgroundImages-1)+1)+1
        setRandomBackground(randomnr);
        setRandomBackgroundMusik(randomnr);
    }

    private void setPlayer(int drawable_id) {
        //auf item player classes
        Log.e("PLAYER","Drawable: "+drawable_id);
    }

    private void setRandomBackground(int randomnr) {
        Log.e("BG","RES: "+r.nextInt((countBackgroundImages-1)+1)+1);
        (findViewById(R.id.gameContent)).setBackgroundResource(getResources().getIdentifier("background_"+randomnr,"drawable",getPackageName()));
    }

    private void setRandomBackgroundMusik(int randomnr) {

    }

}
