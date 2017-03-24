package com.example.hmh.firedemo.widght;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by hmh on 2017/3/24.
 */

public class TouchEvents extends android.support.v7.widget.AppCompatTextView {

    public TouchEvents(Context context) {
        super(context);
    }

    public TouchEvents(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchEvents(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.e("fuck", "////down");
                return true;
            case MotionEvent.ACTION_MOVE:
                Log.e("fuck", "///move");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("fuck", "////up");
                break;
        }
        return super.onTouchEvent(event);
    }
}
