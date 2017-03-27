package com.example.hmh.firedemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by hmh on 2017/3/9.
 * 基类的fragment
 */

public abstract class BaseFragment extends Fragment {

    private View inflate;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = LayoutInflater.from(container.getContext()).inflate(getResouseId(), container, false);
        ButterKnife.bind(getActivity());
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        onActivityCreate(savedInstanceState);
    }

    /**数据操作等*/
    protected abstract void onActivityCreate(Bundle savedInstanceState);

    /**资源ID*/
    public abstract int getResouseId();
}
