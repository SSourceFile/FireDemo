package com.example.hmh.firedemo;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hmh.firedemo.Activity.RxjavaTestActivity;
import com.example.hmh.firedemo.Activity.ScanActivity;
import com.example.hmh.firedemo.Activity.ServiceActivity;
import com.example.hmh.firedemo.Fragment.HomeFragment;
import com.example.hmh.firedemo.Fragment.ImageFragment;
import com.example.hmh.firedemo.Fragment.NewFragment;
import com.example.hmh.firedemo.Fragment.VideoFragment;
import com.example.hmh.firedemo.adapter.HeaderAndFooterWrapper;
import com.example.hmh.firedemo.adapter.ImageAdapter;
import com.example.hmh.firedemo.base.BaseActivity;
import com.example.hmh.firedemo.base.BaseFragment;
import com.example.hmh.firedemo.utils.FinalApi;
import com.example.hmh.firedemo.utils.ImageUtil;
import com.example.hmh.firedemo.widght.DragPointView;
import com.jakewharton.rxbinding2.view.RxView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.orhanobut.logger.Logger;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 主界面
 */
public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {


    @BindView(R.id.scan)
    TextView mScan;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.fab)
    FloatingActionButton mFab;
    @BindView(R.id.nav_view)
    NavigationView mNavView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.recycle_view)
    XRecyclerView recycleView;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    @BindView(R.id.tab_img_chats)
    ImageView mImageChats;
    @BindView(R.id.tab_text_chats)
    TextView mTextChats;
    @BindView(R.id.ll)
    RelativeLayout ll;
    @BindView(R.id.seal_num)
    DragPointView sealNum;
    @BindView(R.id.seal_chat)
    RelativeLayout sealChat;
    @BindView(R.id.tab_img_contact)
    ImageView mImageContact;
    @BindView(R.id.tab_text_contact)
    TextView mTextContact;
    @BindView(R.id.seal_contact_list)
    RelativeLayout sealContactList;
    @BindView(R.id.tab_img_find)
    ImageView mImageFind;
    @BindView(R.id.tab_text_find)
    TextView mTextFind;
    @BindView(R.id.seal_find)
    RelativeLayout sealFind;
    @BindView(R.id.tab_img_me)
    ImageView mImageMe;
    @BindView(R.id.tab_text_me)
    TextView mTextMe;
    @BindView(R.id.mine_red)
    ImageView mMineRed;
    @BindView(R.id.seal_me)
    RelativeLayout sealMe;
    @BindView(R.id.main_bottom)
    LinearLayout mainBottom;
    private XRecyclerView recycle;
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initListener() {
        sealChat.setOnClickListener(this);
        sealContactList.setOnClickListener(this);
        sealFind.setOnClickListener(this);
        sealMe.setOnClickListener(this);
    }

    /**
     * 初始化view
     */
    protected void initView() {

        changeTextViewColor();
        changeSelectedTabState(0);
        initViewPage();
        setSupportActionBar(mToolbar);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        mNavView.setNavigationItemSelectedListener(this);
        RxPermissions rxPermissions = new RxPermissions(this);
        RxView.clicks(mScan)
                .compose(rxPermissions.ensure(Manifest.permission.CAMERA))
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Boolean aBoolean) {
                        if (aBoolean) {
                            startActivity(new Intent(MainActivity.this, ScanActivity.class));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
//        mScan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//            }
//        });
        Logger.e("hahhaahhah");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("哈哈" + i);
        }
        ImageAdapter mAdapter = new ImageAdapter(list);
        HeaderAndFooterWrapper wrapper = new HeaderAndFooterWrapper(mAdapter);
        recycle = (XRecyclerView) findViewById(R.id.recycle_view);
        TextView tv = new TextView(this);
        tv.setText("日了老板的");
        recycle.setLayoutManager(new LinearLayoutManager(this));
        recycle.addHeaderView(tv);
        recycle.setAdapter(mAdapter);
    }

    /**初始化viewPager*/
    private void initViewPage() {

        Fragment mHomeFragment = getHomeFragment();
        fragments.add(mHomeFragment);
        fragments.add(new NewFragment());
        fragments.add(new ImageFragment());
        fragments.add(new VideoFragment());
        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }
        };
        mViewPager.setAdapter(fragmentPagerAdapter);
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.addOnPageChangeListener(this);

    }

    BaseFragment mHomeFragment = null;
    private Fragment getHomeFragment() {
        if(mHomeFragment == null){
            return new HomeFragment();
        }else {
            return mHomeFragment;
        }
    }


    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("fuck", "返回结果");
        /**
         * 处理二维码扫描结果
         */
        if (requestCode == FinalApi.REQUEST_CODE) {
            Log.e("fuck", "111111");
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Log.e("fuck", "123");

                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(MainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }

        /**
         * 选择系统图片并解析
         */
        else if (requestCode == FinalApi.REQUEST_IMAGE) {
            if (data != null) {
                Uri uri = data.getData();
                try {
                    CodeUtils.analyzeBitmap(ImageUtil.getImageAbsolutePath(this, uri), new CodeUtils.AnalyzeCallback() {
                        @Override
                        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                            Toast.makeText(MainActivity.this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onAnalyzeFailed() {
                            Toast.makeText(MainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (requestCode == FinalApi.REQUEST_CAMERA_PERM) {
            Toast.makeText(this, "从设置页面返回...", Toast.LENGTH_SHORT)
                    .show();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            startActivity(new Intent(MainActivity.this, ServiceActivity.class));
        } else if (id == R.id.nav_gallery) {
            startActivity(new Intent(MainActivity.this, RxjavaTestActivity.class));

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        changeTextViewColor();
        changeSelectedTabState(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    private void changeTextViewColor() {
        mImageChats.setBackgroundDrawable(getResources().getDrawable(R.mipmap.tab_chat));
        mImageContact.setBackgroundDrawable(getResources().getDrawable(R.mipmap.tab_contacts));
        mImageFind.setBackgroundDrawable(getResources().getDrawable(R.mipmap.tab_found));
        mImageMe.setBackgroundDrawable(getResources().getDrawable(R.mipmap.tab_me));
        mTextChats.setTextColor(Color.parseColor("#abadbb"));
        mTextContact.setTextColor(Color.parseColor("#abadbb"));
        mTextFind.setTextColor(Color.parseColor("#abadbb"));
        mTextMe.setTextColor(Color.parseColor("#abadbb"));
    }

    private void changeSelectedTabState(int position) {
        switch (position) {
            case 0:
                mTextChats.setTextColor(Color.parseColor("#0099ff"));
                mImageChats.setBackgroundDrawable(getResources().getDrawable(R.mipmap.tab_chat_hover));
                break;
            case 1:
                mTextContact.setTextColor(Color.parseColor("#0099ff"));
                mImageContact.setBackgroundDrawable(getResources().getDrawable(R.mipmap.tab_contacts_hover));
                break;
            case 2:
                mTextFind.setTextColor(Color.parseColor("#0099ff"));
                mImageFind.setBackgroundDrawable(getResources().getDrawable(R.mipmap.tab_found_hover));
                break;
            case 3:
                mTextMe.setTextColor(Color.parseColor("#0099ff"));
                mImageMe.setBackgroundDrawable(getResources().getDrawable(R.mipmap.tab_me_hover));
                break;
        }
    }

    long firstClick = 0;
    long secondClick = 0;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.seal_chat:
                mViewPager.setCurrentItem(0, false);
                break;
            case R.id.seal_contact_list:
                mViewPager.setCurrentItem(1, false);
                break;
            case R.id.seal_find:
                mViewPager.setCurrentItem(2, false);
                break;
            case R.id.seal_me:
                mViewPager.setCurrentItem(3, false);
                mMineRed.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("systemconversation", false)) {
            mViewPager.setCurrentItem(0, false);
        }
    }

}
