package com.example.myfirstapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class RabbitView extends View {

    public float x;
    public float y;


    public RabbitView(Context context) {
        super(context);
        x = 750;
        y = 500;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.gymnasium);
        canvas.drawBitmap(bitmap, x, y, paint);
        if (bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }
}
