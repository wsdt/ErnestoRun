package fhkufstein.ac.at.ernestorun;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import java.util.Random;

import fhkufstein.ac.at.ernestorun.Classes.Food;
import fhkufstein.ac.at.ernestorun.Classes.Mediaplayer;


public class GameActivity extends AppCompatActivity {
    public static Random r = new Random();
    public static Mediaplayer mediaPlayer;
    //IMPORTANT: To keep everything working you need to set the following to countVars to the Anzahl of available pictures. We start counting at 1
    public static int countBackgroundImages = 15;
    public static int countBackgroundSounds = 15;
    public static TextView greyBar;
    private int difficultyConstant = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getSupportActionBar().hide();

        RelativeLayout rl = findViewById(R.id.gameContent);

        TextView underline = findViewById(R.id.underline);

        underline.setBackgroundColor(Color.RED);



        /*rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            ImageButton button1 = findViewById(R.id.character);
            button1.setBackgroundResource(R.drawable.snail1);



            }
        });*/

        //Set Character (Ernesto is default)
         startGame();

         //Grey Bar Listener
        ((Switch) findViewById(R.id.switchGreyBar)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                greyBar = findViewById(R.id.greyBar);
                if (!isChecked) {
                    greyBar.setBackgroundColor(Color.TRANSPARENT);
                } else {
                    greyBar.setBackgroundColor(Color.parseColor("#55cccccc"));
                }
            }
        });

        final Food essen = new Food(this,R.drawable.bad_10);
        RelativeLayout ll = ((RelativeLayout) findViewById(R.id.gameContent));
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //if anweisung die überprüft, ob sich das item an der richtigen position befindet
                essen.playEatSound(getApplicationContext(), R.raw.eatsound);

            }
        });

        ll.addView(essen);


        //Change Background after certain values in highscore
        //TODO: CALL METHOD changeLevel() when item gets eaten, so a method in item classes have to call it.
    }

    @Override
    public void onPause() {
        super.onPause();
        mediaPlayer.pauseMusik();
    }
    @Override
    public void onResume() {
        super.onResume();
        mediaPlayer.resumeMusik();
    }


    public void changeLevel() {
        //IMPORTANT: Only images/sounds will be loaded which are below the max nr of the other one (img_1 will be called with sound_1)
        int randomnr = r.nextInt(((countBackgroundImages > countBackgroundSounds ? countBackgroundSounds : countBackgroundImages)-1)+1)+1;
        setRandomBackground(randomnr);
        setRandomBackgroundMusik(randomnr);
    }

    private void setPlayer(int drawable_id) {
        ImageButton gameCharacter = findViewById(R.id.character);
        gameCharacter.setBackground(getResources().getDrawable(drawable_id));
        ((AnimationDrawable) (findViewById(R.id.character)).getBackground()).start();
    }

    private void setRandomBackground(int randomnr) {
        Log.d("BG","BG: "+randomnr);
        (findViewById(R.id.gameContent)).setBackgroundResource(getResources().getIdentifier("background_"+randomnr,"drawable",getPackageName()));
    }


    //MUSIK ##################################################
    private void setRandomBackgroundMusik(int randomnr) {
        Log.d("MU","MU: "+randomnr);
        mediaPlayer = new Mediaplayer(this,getResources().getIdentifier("bgmusik_"+randomnr,"raw",getPackageName()));
        mediaPlayer.startMusik();

    }


    private void startGame() {
        //Create Mediaplayer before changing level
        setPlayer(getIntent().getIntExtra("character",R.drawable.animals_1));
        changeLevel();
    }

}
