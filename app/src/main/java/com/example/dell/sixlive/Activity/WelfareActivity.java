package com.example.dell.sixlive.Activity;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.dell.sixlive.Adater.WelfareAdater;
import com.example.dell.sixlive.Bean.ChoicenessBean;
import com.example.dell.sixlive.Bean.LoadurlBean;
import com.example.dell.sixlive.Bean.WelfareBean;
import com.example.dell.sixlive.Persenter.WelfarePersenter;
import com.example.dell.sixlive.R;
import com.example.dell.sixlive.View.IView;

import java.util.List;

public class WelfareActivity extends BaseActivity<WelfarePersenter> implements IView {

    private RecyclerView rec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initData() {
        BasePresenter.loadwelfare();
    }

    @Override
    protected void initView() {
        rec = findViewById(R.id.recyclerview);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_welfare;
    }

    @Override
    protected WelfarePersenter setPresenter() {
        return new WelfarePersenter();
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
        List<WelfareBean.ResultsBean> results = bean.getResults();
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rec.setLayoutManager(staggeredGridLayoutManager);
        WelfareAdater welfareAdater = new WelfareAdater(results, this);
        rec.setItemAnimator(new DefaultItemAnimator());
        rec.setAdapter(welfareAdater);
    }

    @Override
    public void shibaiwelf(String msg) {

    }
}
