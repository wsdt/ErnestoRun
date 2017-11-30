package fhkufstein.ac.at.ernestorun.Classes;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;


public class Food extends Icon {
    public int X = 2100;
    public int Y = 725;

    public Food(Context context, int character) {
        super(context, character);
        placeFood(this.X, this.Y); //startposition
    }

    public Food(Context context, @Nullable AttributeSet attrs, int character) {
        super(context, attrs, character);
        placeFood(this.X, this.Y); //startposition
    }

    public Food(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int character) {
        super(context, attrs, defStyleAttr, character);
        placeFood(this.X, this.Y); //startposition
    }

    public Food(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes, int character) {
        super(context, attrs, defStyleAttr, defStyleRes, character);
        placeFood(this.X, this.Y); //startposition
    }


    private void placeFood(int X, int Y) {
        setX(X);
        setY(Y);
        Log.d("placeFood", "Executed: "+getX()+";;"+getY());
        this.X = X;
        this.Y = Y; //so other classes know the position
    }

    private void serveFoodFrame() {
        Log.d("serveFoodFrame","Executed");
        placeFood((int) getX()-10,(int) getY());
    }

    public void serveFood(final int BRAKE) {
        final Food FOOD = this;
        final int X = this.X;

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (getX() > (0-sizeFactor)) {
                    FOOD.post(new Runnable() {
                        @Override
                        public void run() {
                            FOOD.serveFoodFrame();
                        }
                    });
                    try {
                        Thread.sleep(BRAKE);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
