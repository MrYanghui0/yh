package com.example.dell.sixlive.View.Fragment.ChoicenessFragment;

import android.view.View;

import com.example.dell.sixlive.Bean.ChoicenessBean;
import com.example.dell.sixlive.Bean.LoadurlBean;
import com.example.dell.sixlive.Bean.WelfareBean;
import com.example.dell.sixlive.Persenter.LoadUrlPresenter;
import com.example.dell.sixlive.R;
import com.example.dell.sixlive.View.Fragment.BaseHot;
import com.example.dell.sixlive.View.IView;

public class Comment extends BaseHot<LoadUrlPresenter> implements IView {
    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected int bindLayout() {
        return R.layout.comment;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void bindEvent() {

    }

    @Override
    protected LoadUrlPresenter setPresenter() {
        return new LoadUrlPresenter();
    }

    @Override
    public void chenggong(ChoicenessBean bean) {

    }

    @Override
    public void shibai(String msg) {

    }

    @Override
    public void chenggongurl(LoadurlBean bean) {

    }

    @Override
    public void shibaiurl(String msg) {

    }

    @Override
    public void chenggongwelf(WelfareBean bean) {

    }

    @Override
    public void shibaiwelf(String msg) {

    }
}
