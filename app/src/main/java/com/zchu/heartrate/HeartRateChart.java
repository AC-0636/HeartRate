package com.zchu.heartrate;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import java.util.LinkedList;


public class HeartRateChart extends View {
    private int mStrokeColor = Color.RED;
    private float mStrokeWidth = 8;
    private float pathSpace = 10f; //distance between the path
    private long maxX; //Maximum value on x axis
    private Paint mPaint;
    private LinkedList<Float> linkedPathList;
    private float minPathY=0; //minimum value in y axis


    public HeartRateChart(Context context) {
        super(context);
        init();
    }

    public HeartRateChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    private void init() {
        linkedPathList = new LinkedList<>();
        maxX = getContext().getResources().getDisplayMetrics().widthPixels;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(mStrokeColor);
        mPaint.setStrokeWidth(mStrokeWidth);
        mPaint.setPathEffect(new CornerPathEffect(60));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (linkedPathList.isEmpty()) {
            return;
        }
        Path path = new Path();
        int i = 0;
        for (Float aFloat : linkedPathList) {
            if (i == 0) {
                path.moveTo(i * pathSpace, aFloat);
            }
            path.lineTo(i * pathSpace, aFloat);
            i++;
        }
        canvas.drawPath(path, mPaint);


    }

    //draw the heart rate line
    public void lineTo(float y) {
        if(minPathY>0) {
            linkedPathList.add(y * 25 - minPathY*24);
        }else{
            linkedPathList.add(y);
        }
        if (linkedPathList.size() * pathSpace > maxX) {

            if(minPathY==0){
                for (Float aFloat : linkedPathList) {
                    if(minPathY==0||minPathY>aFloat){
                        minPathY=aFloat;
                    }
                }
            }
            linkedPathList.removeFirst();
        }
        invalidate();
    }

    public void clear() {
        linkedPathList.clear();
        minPathY=0;
    }

}
