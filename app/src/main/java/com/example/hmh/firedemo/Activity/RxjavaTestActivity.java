package com.example.hmh.firedemo.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.hmh.firedemo.R;
import com.example.hmh.firedemo.base.BaseActivity;
import com.example.hmh.firedemo.widght.MyView;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * Created by hmh on 2017/3/20.
 */

public class RxjavaTestActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout mView = (LinearLayout) findViewById(R.id.rx_root_view);

    }

    @Override
    protected void initView() {
        initRxjava();
    }

    private void initRxjava() {
        String[]  data = {"111", "ddddd", "44444", "gggg"};
        Observable.just(data)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .flatMap(new Func1<String[], Observable<String>>() {
                    @Override
                    public Observable<String> call(String[] strings) {
                        return Observable.from(strings);
                    }
                }).map(new Func1<String, String>() {
                     @Override
                     public String call(String s) {
                         return s;
                        }
                }).subscribe(new Action1<String>() {
                     @Override
                     public void call(String s) {
                         Log.e("fuck", s);
                     }
        });

    }

    @Override
    public int getLayout() {
        return R.layout.activity_rxjava_test;
    }
}
