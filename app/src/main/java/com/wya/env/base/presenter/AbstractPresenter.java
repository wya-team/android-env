package com.wya.env.base.presenter;

import com.wya.env.base.view.BaseView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


/**
 *  @author : xdl
 *  @time   : 2019-08-01
 *  @describe  : Presenter 抽象类
 */
public abstract class AbstractPresenter<T extends BaseView> {
    public T mView;
    protected CompositeDisposable mCompositeDisposable;

    /**
     * Presenter和view层连接
     * @param view
     */
    public abstract void attachView(T view);

    /**
     * Presenter和view层断开连接
     */
    public abstract void detachView();

    /**
     * @param disposable
     */
    public void addSubscribe(Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }
}
