package com.example.hmh.firedemo.Activity;

import android.content.DialogInterface;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hmh.firedemo.R;
import com.example.hmh.firedemo.base.BaseActivity;
import com.example.hmh.firedemo.widght.MyListView;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * Created by hmh on 2017/3/20.
 */

public class RxjavaTestActivity extends BaseActivity implements GestureDetector.OnGestureListener {

    @BindView(R.id.gesture)
    GestureOverlayView mGesture;
    private GestureDetector detector;
    private MyListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout mView = (LinearLayout) findViewById(R.id.rx_root_view);
        mListView = (MyListView) findViewById(R.id.my_list);
        final ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list.add("数据"+i);
        }
        mListView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Object getItem(int position) {
                return list.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ViewHolder holder;
                if(convertView == null) {
                    convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_txt, parent, false);
                    holder = new ViewHolder();
                    holder.tx = (TextView) convertView.findViewById(R.id.item_test);
                    convertView.setTag(holder);
                }else{
                    holder = (ViewHolder) convertView.getTag();
                }

                String str = list.get(position);
                holder.tx.setText(str);

                return convertView;
            }

            class ViewHolder{
                public TextView tx;
            }
        });
    }

    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        super.overridePendingTransition(enterAnim, exitAnim);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        initRxjava();
        initGesture();
    }

    private void initGesture() {
        //创建手势检测器
        detector = new GestureDetector(this, this);

        //设置手势绘图的颜色
        mGesture.setGestureColor(Color.BLUE);
        //设置手势的绘制宽度
        mGesture.setGestureStrokeWidth(4);
        //设置手势绑定监听器
        mGesture.addOnGesturePerformedListener(new GestureOverlayView.OnGesturePerformedListener() {
            @Override
            public void onGesturePerformed(GestureOverlayView overlay, final Gesture gesture) {
                View inflate = getLayoutInflater().inflate(R.layout.save, null, false);
                ImageView  mImageView = (ImageView) inflate.findViewById(R.id.show);
                final EditText mText = (EditText) inflate.findViewById(R.id.gesture_name);
                //根据gesture包含的手势创建一个位图
                Bitmap mBitmap = gesture.toBitmap(128, 128, 10, 0xffff0000);
                mImageView.setImageBitmap(mBitmap);
                //使用dialog显示saveDialog组件
                new AlertDialog.Builder(RxjavaTestActivity.this)
                        .setView(inflate)
                        .setPositiveButton("保存", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //获取本地手势
                                GestureLibrary gestureLibrary = GestureLibraries.fromFile(Environment.getExternalStorageDirectory().getPath() + File.separator + "mygesture");
                                //添加手势
                                gestureLibrary.addGesture(mText.getText().toString().trim(), gesture);

                                gestureLibrary.save();

                            }
                        }).setNegativeButton("取消", null)
                .show();
            }
        });


    }

    private void initRxjava() {
        String[] data = {"111", "ddddd", "44444", "gggg"};
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

    @Override
    public boolean onDown(MotionEvent e) {
        //触碰事件按下时出发该方法
        Toast.makeText(this, "onDown", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        // 当用户在触摸屏幕上按下、而且还未移动和松开时触发该方法
        Toast.makeText(this, "onShowPress", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        // 在屏幕上的轻击事件将会触发该方法
        Toast.makeText(this, "onSingleTapUp", Toast.LENGTH_LONG).show();
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Toast.makeText(this, "scroll", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        //当用户长按时触发该方法
        Toast.makeText(this, "longpress", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        //当前用户在屏幕上拖动时触发的方法
        Toast.makeText(this, "onFling", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //将activity的触碰事件交给GestureDetector处理
        return detector.onTouchEvent(event);
    }
}
