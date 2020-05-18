package com.example.customcard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.graphics.Path;

public class TriangleShapeView extends ConstraintLayout {

    public int colorCode = Color.WHITE;
    public int currentCard = 1;
    public static float factorWidth = 0.75f;
    public static float factorHeight = 0.75f;

    public int getColorCode() {
        return colorCode;
    }

    public void setColorCode(int colorCode) {
        this.colorCode = colorCode;
    }

    public TriangleShapeView(Context context) {
        super(context);
    }

    public TriangleShapeView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public TriangleShapeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int triangleHeight = 80;
        int w = getWidth();
        int h = getHeight();

        Path path = new Path();
        path.moveTo(0, 0);
        path.lineTo(0,h - triangleHeight);
        path.lineTo((float) (w * 0.5),  h);
        path.lineTo(w, h - triangleHeight);
        path.lineTo(w, 0);
        path.lineTo(0, 0);

        path.close();

        Paint p = new Paint();
        p.setColor(colorCode);
        p.setAntiAlias(true);

        canvas.drawPath(path, p);
    }
}