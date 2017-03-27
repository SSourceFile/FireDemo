package com.example.hmh.firedemo.base;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;

import me.imid.swipebacklayout.lib.SwipeBackLayout;

/**
 * Created by Administrator on 2017/3/27.
 */

public abstract class BaseSwiperBackActivity extends BaseActivity {

    private SwipeBackLayout mSwipeBackLayout;

    @Override
    protected void initView() {
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mSwipeBackLayout = new SwipeBackLayout(this);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mSwipeBackLayout.attachToActivity(this);
        // 触摸边缘变为屏幕宽度的1/2
        mSwipeBackLayout.setEdgeSize(getResources().getDisplayMetrics().widthPixels / 2);
    }

    public SwipeBackLayout getmSwipeBackLayout() {
        return mSwipeBackLayout;
    }

    @Override
    public int getLayout() {
        return getLayoutResId();
    }

    public abstract int getLayoutResId();
}
