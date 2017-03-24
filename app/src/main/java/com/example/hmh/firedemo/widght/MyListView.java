package com.example.hmh.firedemo.widght;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 * Created by Administrator on 2017/3/24.
 */

public class MyListView extends ListView {
    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.e("fuck", "listview_down");
                return true;
            case MotionEvent.ACTION_MOVE:
                Log.e("fuck", "listview_move");
                break;

            case MotionEvent.ACTION_UP:
                Log.e("fuck", "listview_up");
                break;
        }
        return super.onTouchEvent(ev);
    }
}
