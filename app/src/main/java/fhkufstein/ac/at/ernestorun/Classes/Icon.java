package fhkufstein.ac.at.ernestorun.Classes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


public abstract class Icon extends View {
    protected float sizeFactor;
    private Drawable character;

    public Icon(Context context, int character) {
        super(context);
        this.character = getResources().getDrawable(character);
    }

    public Icon(Context context, @Nullable AttributeSet attrs, int character) {
        super(context, attrs);
        this.character = getResources().getDrawable(character);
    }

    public Icon(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int character) {
        super(context, attrs, defStyleAttr);
        this.character = getResources().getDrawable(character);
    }

    public Icon(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes, int character) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.character = getResources().getDrawable(character);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        sizeFactor = MeasureSpec.getSize(widthMeasureSpec) / 10;
        setMeasuredDimension((int) sizeFactor, (int) sizeFactor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //Draw image on canvas
        character.setBounds( (int) sizeFactor, (int) sizeFactor, (int) sizeFactor, (int) sizeFactor);
        character.draw(canvas);
        Log.d("DRAW","Drew icon");
    }


}
