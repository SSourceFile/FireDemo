package com.example.hmh.firedemo.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.hmh.firedemo.R;
import com.example.hmh.firedemo.base.BaseActivity;
import com.orhanobut.logger.Logger;
import com.uuzuche.lib_zxing.activity.CaptureFragment;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

/**
 * Created by hmh on 2017/3/9.
 */

public class ScanActivity extends BaseActivity {
    @BindView(R.id.fl_my_container)
    FrameLayout flMyContainer;
    @BindView(R.id.linear1)
    LinearLayout linear1;
    @BindView(R.id.activity_second)
    FrameLayout activitySecond;
    private static boolean isOpen = false;

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        CaptureFragment captureFragment = new CaptureFragment();
        CodeUtils.setFragmentArgs(captureFragment, R.layout.my_camera);
        captureFragment.setAnalyzeCallback(analyzeCallback);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_my_container, captureFragment)
                .commit();
//        initLight();
    }
    @OnClick(R.id.linear1)
    void initLight() {
        Logger.e("打开");
        if(!isOpen){
            CodeUtils.isLightEnable(true);
            isOpen = true;
        }  else{
            CodeUtils.isLightEnable(false);
            isOpen = false;
        }
    }


    /**
     * 二维码解析回调函数
     */
    CodeUtils.AnalyzeCallback analyzeCallback = new CodeUtils.AnalyzeCallback() {
        @Override
        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
            Intent resultIntent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_SUCCESS);
            bundle.putString(CodeUtils.RESULT_STRING, result);
            resultIntent.putExtras(bundle);
            ScanActivity.this.setResult(RESULT_OK, resultIntent);
            ScanActivity.this.finish();
        }

        @Override
        public void onAnalyzeFailed() {
            Intent resultIntent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_FAILED);
            bundle.putString(CodeUtils.RESULT_STRING, "");
            resultIntent.putExtras(bundle);
            ScanActivity.this.setResult(RESULT_OK, resultIntent);
            ScanActivity.this.finish();
        }
    };

    @Override
    public int getLayout() {
        return R.layout.activity_scan;
    }


}
