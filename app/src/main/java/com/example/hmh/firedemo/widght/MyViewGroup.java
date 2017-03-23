package com.example.hmh.firedemo.widght;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.ViewGroup;

import com.orhanobut.logger.Logger;

/**
 * Created by hmh on 2017/3/22.
 */

public class MyViewGroup extends ViewGroup{

    private final long currentData;

    public MyViewGroup(Context context) {
        super(context);
        currentData = System.currentTimeMillis();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        long endData = System.currentTimeMillis();
        Logger.e(endData - currentData+"");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        long measureData = System.currentTimeMillis();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        long data = System.currentTimeMillis();
        Logger.e(data - measureData+"   measure");
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
