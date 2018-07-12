package com.example.dell.sixlive.View.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dell.sixlive.Activity.ParticularsActivity;
import com.example.dell.sixlive.Activity.SearchActivity;
import com.example.dell.sixlive.Adater.ChoicenessAdater;
import com.example.dell.sixlive.Bean.ChoicenessBean;
import com.example.dell.sixlive.Bean.LoadurlBean;
import com.example.dell.sixlive.Persenter.ChoicenessPersenter;
import com.example.dell.sixlive.R;
import com.example.dell.sixlive.View.IView;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2018/7/6.
 */

public class Choiceness extends BaseHot<ChoicenessPersenter> implements IView, XBanner.XBannerAdapter {
    private List<String> list;
    private XBanner banner;
    private RecyclerView rec;
    private String loadURL1;
    private EditText edidtext;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView(View inflate) {
        banner = inflate.findViewById(R.id.banner);
        rec = inflate.findViewById(R.id.choiceness_rec);
        edidtext = inflate.findViewById(R.id.choiceness_edidtext);
        edidtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected int bindLayout() {
        return R.layout.choiceness;
    }

    @SuppressLint("NewApi")
    @Override
    protected void initData() {
        BasePresenter.loadchoiceness();

    }

    @Override
    protected void bindEvent() {

    }

    @Override
    protected ChoicenessPersenter setPresenter() {
        return new ChoicenessPersenter();
    }

    @Override
    public void chenggong(ChoicenessBean bean) {
        List<ChoicenessBean.RetBean.ListBean> data = bean.getRet().getList();

        list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            String icon = data.get(0).getChildList().get(i).getPic();
            loadURL1 = data.get(0).getChildList().get(i).getLoadURL();
            if (icon.equals("")) {
                list.remove(i);
            } else {
                this.list.add(icon);
            }

        }
        banner.setData(list, null);
        banner.setPageTransformer(Transformer.Default);
        banner.setPageChangeDuration(2000);
        banner.setmAdapter(this);
        banner.setOnItemClickListener(new XBanner.OnItemClickListener() {
            @Override
            public void onItemClick(XBanner banner, int position) {
                Intent intent = new Intent(getActivity(), ParticularsActivity.class);
                intent.putExtra("loadURL1", loadURL1);
                startActivity(intent);
            }
        });

        ChoicenessAdater choicenessAdater = new ChoicenessAdater(data, getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rec.setLayoutManager(linearLayoutManager);
        rec.setAdapter(choicenessAdater);
        choicenessAdater.setSetOnLisenner(new ChoicenessAdater.setOn() {
            @Override
            public void setOnitem(int i, View view, String loadURL) {
                Intent intent = new Intent(getActivity(), ParticularsActivity.class);
                intent.putExtra("loadURL", loadURL);
                startActivity(intent);
            }
        });
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
    public void loadBanner(XBanner banner, View view, int position) {
        Glide.with(this).load(list.get(position)).into((ImageView) view);
    }

}
