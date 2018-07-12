package com.example.dell.sixlive.Persenter;

import android.util.Log;

import com.example.dell.sixlive.Bean.LoadurlBean;
import com.example.dell.sixlive.View.IView;
import com.example.dell.sixlive.model.https.RetrofitUntils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoadUrlPresenter extends BasePresenter<IView> {
    private RetrofitUntils retrofitUntils;

    public LoadUrlPresenter() {
        //拿到单例
        retrofitUntils = RetrofitUntils.getInsatnce();
    }

    public void loadloadurl(String mediaId) {
        Observable<LoadurlBean> getloadurl = retrofitUntils.getApi().getloadurl(mediaId);
        getloadurl.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoadurlBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoadurlBean loadurlBean) {
                        getView().chenggongurl(loadurlBean);
                        Log.e("onNextURL", "成功");
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().shibaiurl(e.getMessage());
                        Log.e("onErrorURL", "失败");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
