package com.example.hmh.firedemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hmh.firedemo.R;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hmh on 2017/3/14.
 *  头部和尾部的item
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder>{

    private List<String> mDataList = new ArrayList<>();
    //构造方法
    public ImageAdapter(List<String> mDataList){
        this.mDataList = mDataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_add_view, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Logger.e(position+"  ///");
        String str = mDataList.get(position);
        holder.mtv.setText(str);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView mtv;

        public ViewHolder(View itemView) {
            super(itemView);
            mtv = (TextView) itemView.findViewById(R.id.testss);
        }


    }
}
