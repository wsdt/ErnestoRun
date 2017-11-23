package fhkufstein.ac.at.ernestorun;

import android.media.MediaPlayer;
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
         startGame();

        //Change Background after certain values in highscore
        //TODO: CALL METHOD changeLevel() when item gets eaten, so a method in item classes have to call it.
    }


    public void changeLevel() {
        //IMPORTANT: Only images/sounds will be loaded which are below the max nr of the other one (img_1 will be called with sound_1)
        int randomnr = r.nextInt(( (countBackgroundImages > countBackgroundSounds ? countBackgroundSounds : countBackgroundImages) -1)+1)+1;
        setRandomBackground(randomnr);
        setRandomBackgroundMusik(randomnr);
    }

    private void setPlayer(int drawable_id) {
        //auf item player classes
        Log.e("PLAYER","Drawable: "+drawable_id);
    }

    private void setRandomBackground(int randomnr) {
        (findViewById(R.id.gameContent)).setBackgroundResource(getResources().getIdentifier("background_"+randomnr,"drawable",getPackageName()));
    }

    private void setRandomBackgroundMusik(int randomnr) {
        MediaPlayer mediaPlayer = MediaPlayer.create(this,getResources().getIdentifier("bgmusik_"+randomnr,"raw",getPackageName()));
        mediaPlayer.start();
    }

    private void startGame() {
        //Create Mediaplayer before changing level
        setPlayer(getIntent().getIntExtra("character",R.drawable.animals_1));
        changeLevel();
    }

}
