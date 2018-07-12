package com.example.dell.sixlive.Persenter;

import android.util.Log;

import com.example.dell.sixlive.Bean.ChoicenessBean;
import com.example.dell.sixlive.View.IView;
import com.example.dell.sixlive.model.https.RetrofitUntils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by DELL on 2018/7/5.
 */

public class ChoicenessPersenter extends BasePresenter<IView> {
    private RetrofitUntils retrofitUntils;

    public ChoicenessPersenter() {
        //拿到单例
        retrofitUntils= RetrofitUntils.getInsatnce();
    }

    public void loadchoiceness() {
        Observable<ChoicenessBean> beijing = retrofitUntils.getApi().getchoiceness();
        beijing.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ChoicenessBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ChoicenessBean choicenessBean) {
                        getView().chenggong(choicenessBean);
                        Log.e("onNext", "成功");
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().shibai(e.getMessage());
                        Log.e("onError", "失败");
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
