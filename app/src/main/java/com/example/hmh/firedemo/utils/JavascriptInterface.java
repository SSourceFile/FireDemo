package com.example.hmh.firedemo.utils;

import android.content.Context;
import android.content.Intent;

import com.example.hmh.firedemo.Activity.ImageActivity;

/**
 * Created by hmh on 2017/3/30.
 * js调用原生控件
 */

public class JavascriptInterface {
    private Context context;

    public JavascriptInterface(Context context){
        this.context = context;
    }

    @android.webkit.JavascriptInterface
    public void openImage(String img){
        Intent intent = new Intent();
        intent.putExtra("img", img);
        intent.setClass(context, ImageActivity.class);
        context.startActivity(intent);
    }

}
