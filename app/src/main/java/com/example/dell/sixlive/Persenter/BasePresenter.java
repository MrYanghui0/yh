package com.example.dell.sixlive.Persenter;


import com.example.dell.sixlive.View.BaseIView;

/**
 * Created by nyj on 2018/5/26.
 */

public class BasePresenter<V extends BaseIView> {


    private V iBaseView;
    //
    public void attachView(V iBaseView) {
        this.iBaseView = iBaseView;
    }

    public V getView() {

        return iBaseView;
    }

    public void dechView() {
        iBaseView = null;
    }

}
