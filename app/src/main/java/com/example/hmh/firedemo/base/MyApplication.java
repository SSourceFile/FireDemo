package com.example.hmh.firedemo.base;

import android.app.Application;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

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
