package com.example.hmh.firedemo.Activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.hmh.firedemo.MyAIDLService;
import com.example.hmh.firedemo.R;
import com.example.hmh.firedemo.Service.MyService;
import com.example.hmh.firedemo.base.BaseActivity;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hmh on 2017/3/16.
 */

public class ServiceActivity extends BaseActivity {

    @BindView(R.id.start_service)
    Button mStartService;
    @BindView(R.id.stop_service)
    Button mStopService;
    @BindView(R.id.bind_service)
    Button mBindService;
    @BindView(R.id.unbind_service)
    Button mUnbindService;

    @Override
    protected void initView() {

    }

    @Override
    public int getLayout() {
        return R.layout.activity_service;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        initListener();
    }

    /*连接服务***/
    private ServiceConnection conn = new ServiceConnection() {

        private MyAIDLService myAIDLService;
        private MyService.MyBinder myBinder;

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myAIDLService = MyAIDLService.Stub.asInterface(service);
            try {
                int plus = myAIDLService.plus(3, 5);
                String upperCaseString = myAIDLService.toUpperCase("hello world");
                Logger.e(plus+"  // ");
                Logger.e(upperCaseString);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
//            myBinder = (MyService.MyBinder) service;
//            myBinder.startDownload();   //下载
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


    private void initListener() {
        //开启服务
        mStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(ServiceActivity.this, MyService.class));
            }
        });
        //停止服务
        mStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(ServiceActivity.this, MyService.class));
            }
        });
        //绑定服务
        mBindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceActivity.this, MyService.class);
                bindService(intent, conn, BIND_AUTO_CREATE);
            }
        });
        //解绑服务
        mUnbindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(conn);
            }
        });
    }
}
