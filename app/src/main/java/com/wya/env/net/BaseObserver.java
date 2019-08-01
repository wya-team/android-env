package com.wya.env.net;

import com.wya.env.base.view.BaseView;

import io.reactivex.observers.ResourceObserver;

/**
 * @date: 2018/5/31 13:59
 * @author: Chunjiang Mao
 * @classname: BaseObserver
 * @describe: 写一个Subscriber继承Observer，重写相应的方法，在具体调用时，只需要重写你需要的onNext方法即可，不需要写入其余的回调方法
 */

public class BaseObserver<T> extends ResourceObserver<T> {
    private BaseView mBaseView;

    public BaseObserver(BaseView baseView) {
        this.mBaseView = baseView;
    }

    @Override
    public void onNext(T t) {
        mBaseView.hideLoading();
    }

    @Override
    public void onError(Throwable e) {
        mBaseView.hideLoading();
        mBaseView.errorResult(e.getMessage());
    }
    @Override
    public void onComplete() {
        mBaseView.hideLoading();
    }
}
