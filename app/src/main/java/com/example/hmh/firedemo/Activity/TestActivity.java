package com.example.hmh.firedemo.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.RadioGroup;

import com.example.hmh.firedemo.R;
import com.example.hmh.firedemo.base.BaseActivity;
import com.example.hmh.firedemo.base.BaseSwiperBackActivity;

import me.imid.swipebacklayout.lib.SwipeBackLayout;

/**
 * Created by hmh on 2017/3/27.
 */

public class TestActivity extends BaseActivity {


//    @Override
//    public int getLayoutResId() {
//        return ;
//    }
    private int[] mBgColors;

    private static int mBgIndex = 0;

    private String mKeyTrackingMode;

    private RadioGroup mTrackingModeGroup;

    private SwipeBackLayout mSwipeBackLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_demo);
//        changeActionBarColor();
//        findViews();
//        mKeyTrackingMode = getString(R.string.key_tracking_mode);
//        mSwipeBackLayout = getmSwipeBackLayout();
//        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_RIGHT);

//        mTrackingModeGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                int edgeFlag;
//                switch (checkedId) {
//                    case R.id.mode_left:
//                        edgeFlag = SwipeBackLayout.EDGE_LEFT;
//                        break;
//                    case R.id.mode_right:
//                        edgeFlag = SwipeBackLayout.EDGE_RIGHT;
//                        break;
//                    case R.id.mode_bottom:
//                        edgeFlag = SwipeBackLayout.EDGE_BOTTOM;
//                        break;
//                    default:
//                        edgeFlag = SwipeBackLayout.EDGE_ALL;
//                }
//
////                saveTrackingMode(edgeFlag);
//            }
//        });
    }

    @Override
    protected void initView() {

    }

    @Override
    public int getLayout() {
        return R.layout.activity_test;
    }

}
