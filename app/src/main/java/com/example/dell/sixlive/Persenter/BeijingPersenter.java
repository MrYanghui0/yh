package com.example.dell.sixlive.Persenter;

import com.example.dell.sixlive.View.IView;
import com.example.dell.sixlive.model.https.RetrofitUntils;

/**
 * Created by DELL on 2018/7/5.
 */

public class BeijingPersenter extends BasePresenter<IView> {
    private RetrofitUntils retrofitUntils;
    public BeijingPersenter(){
        //拿到单例
        retrofitUntils= RetrofitUntils.getInsatnce();
    }
//    public void loadBeijing(String pscid){
//        Observable<BeijingListBean> beijing = retrofitUntils.getApi().getBeijing(pscid);
//        beijing.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<BeijingListBean>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(BeijingListBean beijingListBean) {
//                        getView().chenggong(beijingListBean);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        getView().shibai(e.getMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });

//     }
}
