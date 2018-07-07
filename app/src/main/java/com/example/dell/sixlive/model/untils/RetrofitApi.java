package com.example.dell.sixlive.model.untils;

import com.example.dell.sixlive.Bean.ChoicenessBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by nyj on 2018/5/26.
 */

public interface RetrofitApi {

    //精选
    @GET("front/homePageApi/homePage.do")
    Observable<ChoicenessBean> getchoiceness();

}
