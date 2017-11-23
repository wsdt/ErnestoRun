package fhkufstein.ac.at.ernestorun.Classes;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;


public class DieFood extends Food {

    public DieFood(Context context, int character) {
        super(context, character);
    }

    public DieFood(Context context, @Nullable AttributeSet attrs, int character) {
        super(context, attrs, character);
    }

    public DieFood(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int character) {
        super(context, attrs, defStyleAttr, character);
    }

    public DieFood(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes, int character) {
        super(context, attrs, defStyleAttr, defStyleRes, character);
    }
}
