package com.example.dell.sixlive.View.Fragment;

import android.view.View;

import com.example.dell.sixlive.Persenter.BeijingPersenter;
import com.example.dell.sixlive.R;
import com.example.dell.sixlive.View.IView;

/**
 * Created by DELL on 2018/7/6.
 */

public class My extends  BaseHot<BeijingPersenter> implements IView {
    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected int bindLayout() {
        return R.layout.my;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void bindEvent() {

    }

    @Override
    protected BeijingPersenter setPresenter() {
        return new BeijingPersenter();
    }
}
