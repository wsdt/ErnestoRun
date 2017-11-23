package fhkufstein.ac.at.ernestorun.Classes;

import android.content.Context;
import android.graphics.Canvas;
import android.media.Image;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Martin on 23.11.2017.
 */

public class Icon extends View {

    protected float sizeFactor;


    public Icon(Context context) {
        super(context);
    }

    public Icon(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Icon(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Icon(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        sizeFactor = MeasureSpec.getSize(widthMeasureSpec) / 10;
        setMeasuredDimension((int) sizeFactor, (int) sizeFactor);
    }

    protected void onDraw(Canvas canvas) {

    }



}
