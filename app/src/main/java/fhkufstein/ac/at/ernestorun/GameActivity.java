package fhkufstein.ac.at.ernestorun;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

import fhkufstein.ac.at.ernestorun.Classes.BadFood;
import fhkufstein.ac.at.ernestorun.Classes.DieFood;
import fhkufstein.ac.at.ernestorun.Classes.Food;
import fhkufstein.ac.at.ernestorun.Classes.GoodFood;
import fhkufstein.ac.at.ernestorun.Classes.Mediaplayer;


public class GameActivity extends AppCompatActivity {
    public static Random r = new Random();
    public static Mediaplayer mediaPlayer;
    //IMPORTANT: To keep everything working you need to set the following to countVars to the Anzahl of available pictures. We start counting at 1
    public static int countBackgroundImages = 15;
    public static int countBackgroundSounds = 15;
    public static int countGoodMeals = 26;
    public static int countBadMeals = 27;
    public static int countDeadlyMeals = 1;
    public static TextView greyBar;
    private RelativeLayout this_layout;
    public int level = 0;
    private int levelMax;
    private int levelMin;
    public Food currentFood;
    public int score = 0;
    private TextView scoreTextView;
    private final int difficultyValue = 200; //the higher the easier the game


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getSupportActionBar().hide();

        this_layout = findViewById(R.id.gameContent);
        scoreTextView = (TextView) findViewById(R.id.HighscorePoints);


        //Set Character (Ernesto is default)
        startGame();


        //Serve Meals or Eat Meals ----------------------------------------------------------
        serveRandomMeal(r.nextInt(levelMax - levelMin + 1) + 1); //first run essential (Nullpointerexception)
        this_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Wenn Essen sichtbar dann kann nur gegessen werden, ansonsten wird beim Klicken Neues essen serviert
                if (currentFood.getX() <= (0 - currentFood.sizeFactor)) {
                    Log.e("onClickLayout", "X: " + currentFood.getX() + "<=" + (0 - currentFood.sizeFactor));
                    serveRandomMeal(r.nextInt(levelMax - levelMin + 1) + 1);
                } else {
                    if (currentFood.getX() >= findViewById(R.id.underline).getX() - findViewById(R.id.underline).getWidth() && currentFood.getX() <= findViewById(R.id.underline).getX() + findViewById(R.id.underline).getWidth() / 2) {
                        if (currentFood instanceof GoodFood) {
                            updateScore(1);
                            currentFood.removeFood();

                    } else if (currentFood instanceof BadFood) {
                        updateScore(-1);
                        currentFood.removeFood();
                    } else if (currentFood instanceof DieFood) {

                        endGame();
                    }
                }
                playEatSound(getApplicationContext(), R.raw.eatsound);
                //this.currentfood.didHeAteit() in if usw.
            }
        }
    });


    //Change Background after certain values in highscore
    //TODO: CALL METHOD changeLevel() when item gets eaten, so a method in item classes have to call it.
    startAutomaticLevelIncrease();

}

    private void startAutomaticLevelIncrease() {
        new java.util.Timer().scheduleAtFixedRate(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                changeLevel(); //increase Level after period of time
                                Log.d("startAutomaticLvlInc.", "Increased LEVEL automatically.");
                            }
                        });
                    }
                },
                30000 //wait for first time
                , 30000
        );
    }

//    @Override
//    public void onPause() {
//        super.onPause();
//        try {
//            GameActivity.mediaPlayer.pauseMusik();
//        } catch (NullPointerException e) {
//            Log.e("onPause", "NullpointerException - Mediaplayer");
//        }
//    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        try {
//            GameActivity.mediaPlayer.resumeMusik();
//        } catch (NullPointerException e) {
//            Log.e("onResume", "NullpointerException - Mediaplayer");
//        }
//    }


    public void changeLevel() {
        //IMPORTANT: Only images/sounds will be loaded which are below the max nr of the other one (img_1 will be called with sound_1)
        int randomnr = r.nextInt(((countBackgroundImages > countBackgroundSounds ? countBackgroundSounds : countBackgroundImages) - 1) + 1) + 1;
//        setRandomBackground(randomnr);
//        setRandomBackgroundMusik(randomnr);
        this.level++; //increase level
        ((TextView) findViewById(R.id.levelLabel)).setText("Level " + this.level);
        setLevelProperties();
    }

    private void setPlayer(int drawable_id) {
        ImageButton gameCharacter = findViewById(R.id.character);
        gameCharacter.setBackground(getResources().getDrawable(drawable_id));
        ((AnimationDrawable) (findViewById(R.id.character)).getBackground()).start();
    }

//    private void setRandomBackground(int randomnr) {
//        Log.d("BG", "BG: " + randomnr);
//        (findViewById(R.id.gameContent)).setBackgroundResource(getResources().getIdentifier("background_" + randomnr, "drawable", getPackageName()));
//    }

    //Server MEAL ############################################
    public void setLevelProperties() {
        final int level = this.level;
        final GameActivity instance = this;


        Log.e("setLevelProperties", "Current-Level: " + level);
        switch (level) {  //the lower the faster the food icons
            case 1:
                levelMax = 150;
                levelMin = 140;
                break;
            case 2:
                levelMax = 150;
                levelMin = 130;
                break;
            case 3:
                levelMax = 140;
                levelMin = 130;
                break;
            case 4:
                levelMax = 140;
                levelMin = 120;
                break;
            case 5:
                levelMax = 130;
                levelMin = 120;
                break;
            case 6:
                levelMax = 130;
                levelMin = 110;
                break;
            case 7:
                levelMax = 120;
                levelMin = 110;
                break;
            case 8:
                levelMax = 120;
                levelMin = 100;
                break;
            case 9:
                levelMax = 110;
                levelMin = 100;
                break;
            case 10:
                levelMax = 110;
                levelMin = 90;
                break;
            case 11:
                levelMax = 100;
                levelMin = 90;
                break;
            case 12:
                levelMax = 100;
                levelMin = 80;
                break;
            case 13:
                levelMax = 90;
                levelMin = 80;
                break;
            case 14:
                levelMax = 90;
                levelMin = 70;
                break;
            case 15:
                levelMax = 85;
                levelMin = 70;
                break;
            case 16:
                levelMax = 80;
                levelMin = 70;
                break;
            case 17:
                levelMax = 75;
                levelMin = 65;
                break;
            case 18:
                levelMax = 75;
                levelMin = 60;
                break;
            case 19:
                levelMax = 70;
                levelMin = 55;
                break;
            case 20:
                levelMax = 65;
                levelMin = 55;
                break;
            case 21:
                levelMax = 60;
                levelMin = 50;
                break;
            case 22:
                levelMax = 60;
                levelMin = 45;
                break;
            case 23:
                levelMax = 55;
                levelMin = 45;
                break;
            case 24:
                levelMax = 55;
                levelMin = 40;
                break;
            case 25:
                levelMax = 50;
                levelMin = 40;
                break;
            case 26:
                levelMax = 50;
                levelMin = 35;
                break;
            case 27:
                levelMax = 45;
                levelMin = 35;
                break;
            case 28:
                levelMax = 45;
                levelMin = 30;
                break;
            case 29:
                levelMax = 40;
                levelMin = 30;
                break;
            case 30:
                levelMax = 40;
                levelMin = 25;
                break;
            case 31:
                levelMax = 35;
                levelMin = 25;
                break;
            case 32:
                levelMax = 30;
                levelMin = 25;
                break;
            case 33:
                levelMax = 30;
                levelMin = 20;
                break;
            case 34:
                levelMax = 25;
                levelMin = 20;
                break;
            case 35:
                levelMax = 20;
                levelMin = 15; //do not go below 15 (i think otherwise we could get exceptions)
                break;
            default:
                Log.e("LEVEL", "Level does not exist!");
        }
        this.levelMin += this.difficultyValue;
        this.levelMax += this.difficultyValue;
    }


    public void serveRandomMeal(int brake) { //current saved Food will be served (IMPORTANT: Call determineNextFood() before)
        this.determineNextFood();
        this.this_layout.addView(this.currentFood);
        this.currentFood.setHighscore((LinearLayout) findViewById(R.id.Highscore));
        this.currentFood.setGameActivity(this);
        this.currentFood.serveFood(brake);

        //this.currentFood.threadServeFood.start();
    }

    public Food determineNextFood() { //which Food is going to be next
        int mealKind = r.nextInt(3 - 1 + 1) + 1;
        int mealNr = 1; //default value

        switch (mealKind) {
            case 1:
                mealNr = r.nextInt(countGoodMeals - 1 + 1) + 1;
                Log.e("mealkind", "GOOD: " + mealNr);
                this.currentFood = new GoodFood(this, getResources().getIdentifier("good_" + mealNr, "drawable", getPackageName()));
                break;
            case 2:
                mealNr = r.nextInt(countBadMeals - 1 + 1) + 1;
                Log.e("mealkind", "BAD: " + mealNr);
                this.currentFood = new BadFood(this, getResources().getIdentifier("bad_" + mealNr, "drawable", getPackageName()));
                break;
            case 3:
                mealNr = r.nextInt(countDeadlyMeals - 1 + 1) + 1;
                Log.e("mealkind", "DEADLY: " + mealNr);
                this.currentFood = new DieFood(this, getResources().getIdentifier("dead_" + mealNr, "drawable", getPackageName()));
                break;
            default:
                this.currentFood = new DieFood(this, R.drawable.dead_1);
                Log.e("serveRandomMeal", "MealKind not found!");
        }
        return this.currentFood;
    }


    //MUSIK ##################################################
//    private void setRandomBackgroundMusik(final int randomnr) {
//        final GameActivity instance = this;
//
//        Log.d("MU", "MU: " + randomnr);
//        if (GameActivity.mediaPlayer != null) {
//            GameActivity.mediaPlayer.stopMusik();
//        }
//        GameActivity.mediaPlayer = new Mediaplayer(instance, getResources().getIdentifier("bgmusik_" + randomnr, "raw", getPackageName()));
//        GameActivity.mediaPlayer.startMusik();
//
//    }

    public void playEatSound(final Context context, final int eatsound) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                MediaPlayer mediaPlayer = MediaPlayer.create(context, eatsound);
                mediaPlayer.start();
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mediaPlayer.release(); //essential to provide reliable eat sound
            }
        }).start();


    }


    private void startGame() {
        //Create Mediaplayer before changing level
        setPlayer(getIntent().getIntExtra("character", R.drawable.animals_1));
        changeLevel();

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

        //Set reachable eat area
        TextView underline = findViewById(R.id.underline);
        underline.setBackgroundColor(Color.YELLOW);
    }

    private void updateScore(int points) {

        score = score + points;
        updateScoreTextView(score);
        checkScore(score);

    }


    private void updateScoreTextView(int score) {

        scoreTextView.setText(score + "");


    }

    private void endGame() {
        Intent intent = new Intent(this, EndActivity.class);
        intent.putExtra("score", score);
        finish();
        startActivity(intent);
    }

    private void checkScore(int score) {

        if (score < -5) {
            endGame();
        } else {
            Log.i("info", "Unter fünf Punkte");
        }

    }
}
