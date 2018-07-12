package com.example.dell.sixlive.Adater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.sixlive.Bean.LoadurlBean;

import java.util.List;

public class LoadUrlAdater extends RecyclerView.Adapter<LoadUrlAdater.Holder> {
    private List<LoadurlBean.RetBean.ListBean> list;
    private Context context;

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class Holder extends RecyclerView.ViewHolder {
        public Holder(View itemView) {
            super(itemView);
        }
    }
}
