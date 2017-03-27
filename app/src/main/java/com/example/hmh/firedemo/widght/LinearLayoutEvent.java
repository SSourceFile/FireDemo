package com.example.hmh.firedemo.widght;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by hmh on 2017/3/27.
 * 事件分发机制的ViewGroup
 */

public class LinearLayoutEvent extends LinearLayout {
    public LinearLayoutEvent(Context context) {
        super(context);
    }

    public LinearLayoutEvent(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LinearLayoutEvent(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
