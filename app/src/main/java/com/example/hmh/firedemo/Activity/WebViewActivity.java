package com.example.hmh.firedemo.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.hmh.firedemo.R;
import com.example.hmh.firedemo.base.BaseActivity;
import com.example.hmh.firedemo.utils.JavascriptInterface;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hmh on 2017/3/30.
 * 加载WebView
 */

public class WebViewActivity extends BaseActivity {


    @BindView(R.id.web_view)
    WebView mwebView;
    private JavascriptInterface window;

    private Handler handler = new Handler();
    private WebSettings settings;

    @Override
    protected void initListener() {
//        window.openImage();
    }

    @Override
    protected void initView() {
        settings = mwebView.getSettings();
//        mwebView.loadUrl("file:///android_asset/image.html");
//        window = new JavascriptInterface(this);
//        mwebView.addJavascriptInterface(window, "imageListener");
//        mwebView.setWebViewClient(new WebViewClient(){
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                super.onPageFinished(view, url);
//                mwebView.loadUrl("javascript:(function(){"
//                        + "var objs = document.getElementsByTagName(\"img\"); "
//                        + "for(var i=0;i<objs.length;i++)  " + "{"
//                        + "    objs[i].onclick=function()  " + "    {  "
//                        + "        window.imagelistner.openImage(this.src);  "
//                        + "    }  " + "}" + "})()");
//            }
//        });

        initLongView();



    }

    /**long */
    private void initLongView() {
        settings.setJavaScriptEnabled(true);
        mwebView.addJavascriptInterface(new Object(){
            public void clickOnAndroid(){
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mwebView.loadUrl("javascript:wave()");
                    }
                });
            }
        }, "demo");
        mwebView.loadUrl("file:///android_asset/long.html");
    }

    @Override
    public int getLayout() {
        return R.layout.activity_webview;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
