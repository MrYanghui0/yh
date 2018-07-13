package com.example.dell.sixlive.model.untils;

import com.example.dell.sixlive.Bean.ChoicenessBean;
import com.example.dell.sixlive.Bean.LoadurlBean;
import com.example.dell.sixlive.Bean.WelfareBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by nyj on 2018/5/26.
 */

public interface RetrofitApi {

    //精选
    @GET("front/homePageApi/homePage.do")
    Observable<ChoicenessBean> getchoiceness();

    @POST("front/videoDetailApi/videoDetail.do")
    @FormUrlEncoded
    Observable<LoadurlBean> getloadurl(@Field("mediaId") String mediaId);

    @GET("api/data/%E7%A6%8F%E5%88%A9/1000/1")
    Observable<WelfareBean> getwelfare();
}
