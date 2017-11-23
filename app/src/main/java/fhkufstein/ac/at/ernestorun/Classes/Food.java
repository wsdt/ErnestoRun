package fhkufstein.ac.at.ernestorun.Classes;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;


public class Food extends Icon {

    public Food(Context context, int character) {
        super(context, character);
    }

    public Food(Context context, @Nullable AttributeSet attrs, int character) {
        super(context, attrs, character);
    }

    public Food(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int character) {
        super(context, attrs, defStyleAttr, character);
    }

    public Food(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes, int character) {
        super(context, attrs, defStyleAttr, defStyleRes, character);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //von rechts kommend
        b = 5;
        r = -((int) sizeFactor); //so weit rechts, dass um einen Pixel genau nicht sichtbar
        this.layout(l,t,r,b);
    }

    private void serveFood() {
        //TODO: Send food from right to left until the end of the left site (if ernesto has eaten it, then HIDE or REMOVE food from display (play a sound) and let a new come.

    }
}
