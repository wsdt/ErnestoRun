package fhkufstein.ac.at.ernestorun.Classes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import fhkufstein.ac.at.ernestorun.R;


public abstract class Icon extends View {
    protected float sizeFactor;
    private Bitmap character;
    private Matrix m = new Matrix();

    public Icon(Context context, int character) {
        super(context);
        Log.e("WORKED","CH"+character);
        this.character = BitmapFactory.decodeResource(getResources(),character); //getResources().getDrawable(character);
    }

    public Icon(Context context, @Nullable AttributeSet attrs, int character) {
        super(context, attrs);
        this.character = BitmapFactory.decodeResource(getResources(),character);
    }

    public Icon(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int character) {
        super(context, attrs, defStyleAttr);
        this.character = BitmapFactory.decodeResource(getResources(),character);
    }

    public Icon(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes, int character) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.character = BitmapFactory.decodeResource(getResources(),character);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        sizeFactor = MeasureSpec.getSize(widthMeasureSpec) / 4;
        setMeasuredDimension((int) sizeFactor, (int) sizeFactor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //Draw image on canvas
        Log.e("LOG","SZ: "+sizeFactor);
        m.setScale(sizeFactor/this.character.getWidth(),sizeFactor/this.character.getHeight());
        canvas.drawBitmap(this.character,m,new Paint());

        Log.d("DRAW","Drew icon");
    }


}
