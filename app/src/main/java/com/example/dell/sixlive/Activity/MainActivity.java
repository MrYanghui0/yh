package com.example.dell.sixlive.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.dell.sixlive.Bean.ChoicenessBean;
import com.example.dell.sixlive.Bean.LoadurlBean;
import com.example.dell.sixlive.Bean.WelfareBean;
import com.example.dell.sixlive.Persenter.ChoicenessPersenter;
import com.example.dell.sixlive.R;
import com.example.dell.sixlive.View.Fragment.Choiceness;
import com.example.dell.sixlive.View.Fragment.Discover;
import com.example.dell.sixlive.View.Fragment.My;
import com.example.dell.sixlive.View.Fragment.Special;
import com.example.dell.sixlive.View.IView;
import com.hjm.bottomtabbar.BottomTabBar;

public class MainActivity extends BaseActivity<ChoicenessPersenter> implements IView {

    private BottomTabBar boottomTabBar;
    private LinearLayout xiazai;
    private LinearLayout welfare;


    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        boottomTabBar = findViewById(R.id.boottomTabBar);
        welfare = findViewById(R.id.main_Welfare);
        xiazai = findViewById(R.id.main_xiazai);
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
        xiazai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "敬请期待", Toast.LENGTH_SHORT).show();
            }
        });
        welfare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WelfareActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected ChoicenessPersenter setPresenter() {
        return new ChoicenessPersenter();
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
