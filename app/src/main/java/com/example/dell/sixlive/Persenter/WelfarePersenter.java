package com.example.dell.sixlive.Persenter;

import com.example.dell.sixlive.Bean.WelfareBean;
import com.example.dell.sixlive.View.IView;
import com.example.dell.sixlive.model.https.RetrofitUntils1;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class WelfarePersenter extends BasePresenter<IView> {
    private RetrofitUntils1 retrofitUntils1;

    public WelfarePersenter() {
        //拿到单例
        retrofitUntils1 = RetrofitUntils1.getInsatnce();
    }

    public void loadwelfare() {
        Observable<WelfareBean> getwelfare = retrofitUntils1.getApi().getwelfare();
        getwelfare.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WelfareBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WelfareBean welfareBean) {
                        getView().chenggongwelf(welfareBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().shibaiwelf(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
