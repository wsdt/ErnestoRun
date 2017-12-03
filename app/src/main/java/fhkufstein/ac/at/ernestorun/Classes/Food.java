package fhkufstein.ac.at.ernestorun.Classes;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

import fhkufstein.ac.at.ernestorun.GameActivity;


public class Food extends Icon {
    public int X = 2100;
    public int Y = 725;
    private GameActivity gameActivity;
    private LinearLayout highscore;

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
        setX((int) getX()-10); //reducing this number makes the food faster. Pease ONLY adapt the speed of food with the Thread.sleep property in serveFood()
    }

    public void serveFood(final int BRAKE) {
        final Food FOOD = getGameActivity().determineNextFood();

        new Thread(new Runnable() {
            Food FOODi = FOOD;

            @Override
            public void run() {
                while (FOOD.getX() > (0-sizeFactor)) {
                    Log.e("serveFood","While started: "+FOOD.getX()+">"+(0-sizeFactor));
                    FOOD.post(new Runnable() {
                        @Override
                        public void run() {
                            Log.e("serveFood","run() started");
                            FOOD.serveFoodFrame();
                            if (FOOD.getX() <= (0-sizeFactor)) {
                                Log.e("serveFood","performClick started: "+FOOD.getX()+";"+(0-sizeFactor));
                                //getHighscore().performClick();
                                serveFood(BRAKE);
                            }
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

    public void serveFoods(final int BRAKE, final int WAITUNTILNEXTFOOD) {
        final Food FOOD = getGameActivity().currentFood;

        new Thread(new Runnable() {
            @Override
            public void run() {
                boolean isHungry = true;
                while (isHungry) {
                    Log.e("FOOD","Entered outer loop");
                    getGameActivity().setLevelProperties();
                    getGameActivity().determineNextFood(); //just set new currentFood (reference already set on top)
                    Log.e("FOOD","Created new food");
                    Log.e("FOOD","X:"+FOOD.getX()+">"+ (0 - sizeFactor));
                    while (FOOD.getX() > (0 - sizeFactor)) {
                        Log.d("serveFoods","Entered inner loop");

                        FOOD.post(new Runnable() {
                            @Override
                            public void run() {
                                Log.e("FOOD","Starting serveFoodFrame (before method call)");
                                FOOD.serveFoodFrame();
                            }
                        });
                        //Wait until position changes
                        try {
                            Log.d("serveFoods","Waiting to change position.");
                            Thread.sleep(BRAKE);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //Wait until next food gets served
                    try {
                        Log.e("FOOD","Waiting to serve new food");
                        Thread.sleep(WAITUNTILNEXTFOOD);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public GameActivity getGameActivity() {
        return gameActivity;
    }

    public void setGameActivity(GameActivity gameActivity) {
        this.gameActivity = gameActivity;
    }

    public LinearLayout getHighscore() {
        return highscore;
    }

    public void setHighscore(LinearLayout highscore) {
        this.highscore = highscore;
    }
}
