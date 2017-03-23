package com.example.hmh.firedemo.widght;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.orhanobut.logger.Logger;

/**
 * Created by hmh on 2017/3/21.
 */

public class MyView extends View implements View.OnClickListener{

    private Paint mPaint;
    private Rect mBounds;



    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //初始化画笔
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBounds = new Rect();
        //点击事件的监听
        this.setOnClickListener(this);
    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int width_mode = MeasureSpec.getMode(widthMeasureSpec);
        int width_size = MeasureSpec.getSize(widthMeasureSpec);

        int height_mode = MeasureSpec.getMode(heightMeasureSpec);
        int height_size = MeasureSpec.getSize(heightMeasureSpec);

//        setMeasuredDimension((width_mode == MeasureSpec.EXACTLY)? width_size : width, (height_mode == MeasureSpec.EXACTLY)? height_size: height);
        Logger.e("宽度的"+width_mode +"   /   "+ width_size+"  高度的"+height_mode+"   /   "+height_size);


        int unWidth = getMeasuredWidth();
        int unHeight = getMeasuredHeight();
        Logger.e("未测量的宽度"+unWidth + "未测量的高度"+unHeight);
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);


        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        Logger.e("测量过宽度"+width+"测量过的高度"+height);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置画笔的颜色
        mPaint.setColor(Color.BLUE);
        //绘制长方形
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);

        mPaint.setColor(Color.RED);
        //透明度
        mPaint.setAlpha(250);
        //绘制圆形
        canvas.drawCircle(150, 150, 100, mPaint);

        mPaint.setColor(Color.RED);
        canvas.drawCircle(550, 150, 100, mPaint);

        mPaint.setColor(Color.YELLOW);
        canvas.drawLine(10, 300, 200, 300, mPaint);




    }

    @Override
    public void onClick(View v) {

    }
}
