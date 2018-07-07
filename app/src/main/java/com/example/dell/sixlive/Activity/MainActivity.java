package com.example.dell.sixlive.Activity;

import android.graphics.Color;
import android.os.Bundle;

import com.example.dell.sixlive.Persenter.BeijingPersenter;
import com.example.dell.sixlive.R;
import com.example.dell.sixlive.View.Fragment.Choiceness;
import com.example.dell.sixlive.View.Fragment.Discover;
import com.example.dell.sixlive.View.Fragment.My;
import com.example.dell.sixlive.View.Fragment.Special;
import com.example.dell.sixlive.View.IView;
import com.hjm.bottomtabbar.BottomTabBar;

public class MainActivity extends BaseActivity<BeijingPersenter> implements IView {

    private BottomTabBar boottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        boottomTabBar = findViewById(R.id.boottomTabBar);
        boottomTabBar.init(getSupportFragmentManager())
                .setImgSize(70, 70)
                .setFontSize(10)
                .setTabPadding(4, 6, 10)
                .setChangeColor(Color.RED, Color.DKGRAY)
                .addTabItem("精选", R.mipmap.found_select, Choiceness.class)
                .addTabItem("专题", R.mipmap.special_select, Special.class)
                .addTabItem("发现", R.mipmap.fancy_select, Discover.class)
                .addTabItem("我的", R.mipmap.my_select, My.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected BeijingPersenter setPresenter() {
        return new BeijingPersenter();
    }
}
