package com.example.hmh.firedemo.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by hmh on 2017/4/12.
 * 使用sharepreference存储数据
 */

public class SharePreferenceManager {

    private static SharePreferenceManager mSharePreference;
    private Context mContext;
    private static SharedPreferences mPfec;

    public SharePreferenceManager(Context context) {
        this.mContext  = context;
        mPfec = context.getSharedPreferences("FireDemo", Context.MODE_PRIVATE);
    }

    public static SharePreferenceManager  getInstance(Context context){
        if(mSharePreference == null) {
            mSharePreference = new SharePreferenceManager(context);
        }
        return mSharePreference;
    }

    /**缓存String类型的数据*/
    public void setCacheString(String key, String value){
        mPfec.edit().putString(key, value);
    }

    public String getCacheString(String key, String value){
        return mPfec.getString(key, value);
    }


}
