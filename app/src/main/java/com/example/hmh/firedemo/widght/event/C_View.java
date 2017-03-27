package com.example.hmh.firedemo.widght.event;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

import com.example.hmh.firedemo.utils.Utils;

/**
 * Created by hmh on 2017/3/27.
 * 事件分发机制View
 */

public class C_View extends android.support.v7.widget.AppCompatTextView {
    public C_View(Context context) {
        super(context);
    }

    public C_View(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public C_View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("fuck",Utils.getActionName(ev) + ", ViewC.dispatch");
        boolean result = super.dispatchTouchEvent(ev);
        Log.e("fuck",Utils.getActionName(ev) + ", ViewC.dispatch = " + result);
        return result;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean result = false;
        Log.e("fuck",Utils.getActionName(event) + ", ViewC.touch = " + result);
        return result;
    }


}
