package com.example.dell.sixlive.View.Fragment.ChoicenessFragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dell.sixlive.Activity.ParticularsActivity;
import com.example.dell.sixlive.Adater.BriefintroductionAdater;
import com.example.dell.sixlive.Bean.ChoicenessBean;
import com.example.dell.sixlive.Bean.LoadurlBean;
import com.example.dell.sixlive.Bean.WelfareBean;
import com.example.dell.sixlive.Persenter.LoadUrlPresenter;
import com.example.dell.sixlive.R;
import com.example.dell.sixlive.View.Fragment.BaseHot;
import com.example.dell.sixlive.View.IView;
import com.example.dell.sixlive.rewrite.GridSpacingItemDecoration;

import java.util.List;

public class BriefIntroduction extends BaseHot<LoadUrlPresenter> implements IView {
    int spanCount = 3;
    int spacing = 10;
    boolean includeEdge = true;
    private String loadURL;
    private RecyclerView rec;
    private String a;
    private TextView tv2;
    private TextView tv1;
    private TextView tv3;
    private TextView all_text;
    private LinearLayout description_layout;
    private int maxLines = 0;
    private boolean flag;

    @Override
    protected void initView(View inflate) {
        rec = inflate.findViewById(R.id.brightness_rec1);
        tv1 = inflate.findViewById(R.id.brightness_tv1);
        tv2 = inflate.findViewById(R.id.brightness_tv2);
        tv3 = inflate.findViewById(R.id.brightness_tv3);
        all_text = inflate.findViewById(R.id.all_text);
        description_layout = inflate.findViewById(R.id.description_layout);
        tv3.setHeight(tv3.getLineHeight() * maxLines);
//        tv3.post(new Runnable() {
//            @Override
//            public void run() {
//                /**
//                 * 整个内容可能存在本身就比默认的要少的情形
//                 */
//                all_text.setVisibility(tv3.getLineCount() > maxLines ? View.VISIBLE : View.GONE);
//            }
//        });
        all_text.setOnClickListener(new View.OnClickListener() {
            boolean isExpand = false;//默认指定3行，是折叠情形

            @Override
            public void onClick(View view) {
                isExpand = !isExpand;
                //需要判断是展开还是收缩
                tv3.clearAnimation();//清除原有动画
                final int dealHeight;//动画执行相对距离
                final int startHeight = tv3.getHeight();//开始的距离
                int duringAnimationTime = 200;//动画执行时间
                if (isExpand) {
                    dealHeight = tv3.getLineHeight() * tv3.getLineCount() - startHeight;
                    RotateAnimation animation = new RotateAnimation(0, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    animation.setDuration(duringAnimationTime);
                    animation.setFillAfter(true);
                } else {
                    dealHeight = tv3.getLineHeight() * maxLines - startHeight;
                    RotateAnimation animation = new RotateAnimation(0, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    animation.setDuration(duringAnimationTime);
                    animation.setFillAfter(true);
                    all_text.startAnimation(animation);
                }
                Animation animation = new Animation() {//内容展示动画
                    protected void applyTransformation(float interpolatedTime, Transformation t) {
                        tv3.setHeight((int) (startHeight + dealHeight * interpolatedTime));
                    }
                };
                animation.setDuration(duringAnimationTime);
                tv3.startAnimation(animation);
                if (flag) {
                    all_text.setText("展开");
                } else {
                    all_text.setText("收起");
                }
                flag = !flag;
            }
        });
    }


    @Override
    protected int bindLayout() {
        return R.layout.briefintroduction;
    }

    @SuppressLint("NewApi")
    @Override
    protected void initData() {
        Intent intent = getActivity().getIntent();
        loadURL = intent.getStringExtra("loadURL");
        BasePresenter.loadloadurl(loadURL);
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
        LoadurlBean.RetBean ret = bean.getRet();
        tv1.setText(ret.getDirector());
        tv2.setText(ret.getActors());
        tv3.setText(ret.getDescription());
        List<LoadurlBean.RetBean.ListBean> list = bean.getRet().getList();
        BriefintroductionAdater briefintroductionAdater1 = new BriefintroductionAdater(list, getActivity());
        rec.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        rec.setLayoutManager(gridLayoutManager);
        rec.setAdapter(briefintroductionAdater1);
        briefintroductionAdater1.setSetOnLisenner(new BriefintroductionAdater.setOnlisenner() {
            @Override
            public void setOnitem(int i, View view, String loadURL) {
                Intent intent = new Intent(getActivity(), ParticularsActivity.class);
                String[] split = loadURL.split("=");
                a = split[1];
                intent.putExtra("loadURL", a);
                startActivity(intent);
            }
        });

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
