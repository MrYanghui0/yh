package com.example.dell.sixlive.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.dell.sixlive.Persenter.BasePresenter;
import com.example.dell.sixlive.View.IView;


/**
 * Created by DELL on 2018/5/28.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IView {
    public P BasePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());


        initView();
        initBaseView();
        initData();
    }

    private void initBaseView() {
        BasePresenter=setPresenter();
        if(BasePresenter!=null){
            BasePresenter.attachView(this);
        }
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int setLayout();

    protected abstract P setPresenter();
}
