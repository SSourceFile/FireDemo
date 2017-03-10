package com.example.hmh.firedemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by hmh on 2017/3/9.
 * 基类的activity
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder mUnBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mUnBinder = ButterKnife.bind(this);

        initView();
    }

    protected abstract void initView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();
    }

    /**抽象出去给子类实现后调用该方法*/
    public abstract int getLayout();
}
