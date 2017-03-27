package com.example.hmh.firedemo.base;

import android.app.Application;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import cn.bingoogolapple.swipebacklayout.BGASwipeBackManager;

/**
 * Created by hmh on 2017/3/9.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化扫描
        ZXingLibrary.initDisplayOpinion(this);
        initLog();
        initBGASwipe();
    }

    /**初始化侧滑activity*/
    private void initBGASwipe() {
       //必须在application的onCreate方法中执行
        BGASwipeBackManager.getInstance().init(this);
    }

    /**初始化日志系统*/
    private void initLog() {
        Logger.init("FireDemo")
              .methodCount(3)
              .hideThreadInfo()
              .methodOffset(2)
              .logLevel(LogLevel.FULL);
    }
}
