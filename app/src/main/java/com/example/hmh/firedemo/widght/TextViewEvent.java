package com.example.hmh.firedemo.widght;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by hmh on 2017/3/27.
 * 事件分发机制View
 */

public class TextViewEvent extends android.support.v7.widget.AppCompatTextView {
    public TextViewEvent(Context context) {
        super(context);
    }

    public TextViewEvent(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TextViewEvent(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch(action){
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:

                break;

            case MotionEvent.ACTION_CANCEL:

                break;
            case MotionEvent.ACTION_UP:

                break;
        }

        return super.onTouchEvent(event);
    }


}
