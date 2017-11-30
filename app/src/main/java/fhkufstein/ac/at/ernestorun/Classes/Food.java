package fhkufstein.ac.at.ernestorun.Classes;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import fhkufstein.ac.at.ernestorun.R;


public class Food extends Icon {
    public int X = 2100;
    public int Y = 725;

    public Food(Context context, int character) {
        super(context, character);
        placeFood(this.X,this.Y); //startposition
    }

    public Food(Context context, @Nullable AttributeSet attrs, int character) {
        super(context, attrs, character);
        placeFood(this.X,this.Y); //startposition
    }

    public Food(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int character) {
        super(context, attrs, defStyleAttr, character);
        placeFood(this.X,this.Y); //startposition
    }

    public Food(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes, int character) {
        super(context, attrs, defStyleAttr, defStyleRes, character);
        placeFood(this.X,this.Y); //startposition
    }


    private void placeFood(int X, int Y) {
        //TODO: Send food from right to left until the end of the left site (if ernesto has eaten it, then HIDE or REMOVE food from display (play a sound) and let a new come.
        setX(X);
        setY(Y);
        this.X = X;this.Y = Y; //so other classes know the position
    }

    public void serveFood(int speed) {
            

    }

    public void playEatSound(Context context, int eatsound) {
        MediaPlayer mediaPlayer = MediaPlayer.create(context, eatsound);
        mediaPlayer.start();


    }
}
