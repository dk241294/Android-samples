package com.example.note.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.appcompat.widget.AppCompatEditText;

public class LineEditText extends AppCompatEditText {

    private static final String TAG = "LinedEditText";

    private Rect rect;
    private Paint paint;



    // we need this constructor for LayoutInflater
    //we need  atleast one attribute when cudtomising
    public LineEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        rect = new Rect();
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        paint.setColor(0xFFFFD966); // Color of the lines on paper

    }

    @Override
    protected void onDraw(Canvas canvas) {

        // get the height of the view
        int height = ((View)this.getParent()).getHeight();

        int lineHeight = getLineHeight();
        int numberOfLines = height / lineHeight;

        Rect r = rect;
        Paint paint = this.paint;

        int baseline = getLineBounds(0, r);

        for (int i = 0; i < numberOfLines; i++) {

            canvas.drawLine(r.left, baseline + 1, r.right, baseline + 1, paint);

            baseline += lineHeight;
        }

        super.onDraw(canvas);
    }

}