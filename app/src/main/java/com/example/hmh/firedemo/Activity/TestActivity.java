package com.example.hmh.firedemo.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RadioGroup;

import com.example.hmh.firedemo.R;
import com.example.hmh.firedemo.base.BaseActivity;
import com.example.hmh.firedemo.base.BaseSwiperBackActivity;
import com.example.hmh.firedemo.utils.Utils;

import me.imid.swipebacklayout.lib.SwipeBackLayout;

/**
 * Created by hmh on 2017/3/27.
 * 事件分发机制的activity
 */

public class TestActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {

    }

    @Override
    public int getLayout() {
        return R.layout.activity_test;
    }
    
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("fuck", "---------------------------------------------");
        Log.e("fuck", Utils.getActionName(ev) + ", Activity.dispatch");
        boolean result = super.dispatchTouchEvent(ev);
        Log.e("fuck", Utils.getActionName(ev) + ", Activity.dispatch = " + result);
        return result;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean result = false;
        Log.e("fuck", Utils.getActionName(event) + ", Activity.touch = " + result);
        return result;
    }

}
