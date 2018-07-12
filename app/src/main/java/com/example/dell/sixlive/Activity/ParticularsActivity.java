package com.example.dell.sixlive.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dell.sixlive.Bean.ChoicenessBean;
import com.example.dell.sixlive.Bean.LoadurlBean;
import com.example.dell.sixlive.Persenter.LoadUrlPresenter;
import com.example.dell.sixlive.R;
import com.example.dell.sixlive.View.Fragment.ChoicenessFragment.BriefIntroduction;
import com.example.dell.sixlive.View.Fragment.ChoicenessFragment.Comment;
import com.example.dell.sixlive.View.IView;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class ParticularsActivity extends BaseActivity<LoadUrlPresenter> implements IView {
    private boolean flag;
    private String loadURL;
    private StandardGSYVideoPlayer videoPlayer;
    private OrientationUtils orientationUtils;
    private String a;
    private TabLayout tabLayout;
    private ViewPager viewpager;
    private String[] tab = {"简介", "评论"};
    private List<Fragment> list;
    private ArrayList<String> list_path;
    private ArrayList<String> list_title;
    private TextView tv;
    private ImageView iv;
    private ImageView fanhui;

    @Override
    protected void initData() {

        Intent intent = getIntent();
        loadURL = intent.getStringExtra("loadURL");
        String[] split = loadURL.split("=");
        a = split[1];
        Log.e("AA", a);
        BasePresenter.loadloadurl(a);
    }

    @Override
    protected void initView() {
        init();
        videoPlayer = findViewById(R.id.detail_player);
        tabLayout = findViewById(R.id.tabLayout);
        viewpager = findViewById(R.id.viewpager);
        viewpager.setAdapter(new MyVpAdapter(this.getSupportFragmentManager()));
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewpager);
        tv = findViewById(R.id.particulars_tv);
        iv = findViewById(R.id.particulars_iv);
        fanhui = findViewById(R.id.conditioning_fanhui);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_particulars;
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
        String smoothURL = bean.getRet().getSmoothURL();
        String title = bean.getRet().getTitle();
        tv.setText(bean.getRet().getTitle());
        videoPlayer.setUp(smoothURL, true, title);

        //增加封面
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        videoPlayer.setThumbImageView(imageView);
        //增加title
        videoPlayer.getTitleTextView().setVisibility(View.VISIBLE);
        //设置返回键
        videoPlayer.getBackButton().setVisibility(View.VISIBLE);
        //设置旋转
        orientationUtils = new OrientationUtils(this, videoPlayer);
        //设置全屏按键功能,这是使用的是选择屏幕，而不是全屏
        videoPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orientationUtils.resolveByClick();
            }
        });
        //是否可以滑动调整
        videoPlayer.setIsTouchWiget(true);
        //设置返回按键功能
        videoPlayer.getBackButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        videoPlayer.startPlayLogic();
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag) {
                    iv.setImageResource(R.mipmap.collection);

                } else {
                    iv.setImageResource(R.mipmap.collection_select);

                }
                flag = !flag;

            }
        });
    }

    @Override
    public void shibaiurl(String msg) {

    }


    @Override
    protected void onPause() {
        super.onPause();
        videoPlayer.onVideoPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        videoPlayer.onVideoResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GSYVideoManager.releaseAllVideos();
        if (orientationUtils != null)
            orientationUtils.releaseListener();
    }

    @Override
    public void onBackPressed() {
        //先返回正常状态
        if (orientationUtils.getScreenType() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            videoPlayer.getFullscreenButton().performClick();
            return;
        }
        //释放所有
        videoPlayer.setVideoAllCallBack(null);
        super.onBackPressed();
    }

    private void init() {
        list = new ArrayList<>();
        BriefIntroduction briefIntroduction = new BriefIntroduction();
        Comment comment = new Comment();
        list.add(briefIntroduction);
        list.add(comment);

    }

    public void setIndicator(TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());

        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                setIndicator(tabLayout, 35, 35);
            }
        });
    }

    class MyVpAdapter extends FragmentPagerAdapter {


        public MyVpAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tab[position];
        }
    }
}
