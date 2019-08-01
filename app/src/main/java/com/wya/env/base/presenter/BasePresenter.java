package com.wya.env.base.presenter;

import com.wya.env.base.view.BaseView;

import io.reactivex.disposables.CompositeDisposable;

/**
 * @author : xdl
 * @time : 2019/08/01
 * @describe : 基础Presenter
 */
public class BasePresenter<T extends BaseView>  extends AbstractPresenter<T> {

    @Override
    public void attachView(T view) {
        this.mView = view;
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
    }

    @Override
    public void detachView() {
        this.mView = null;
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
            mCompositeDisposable.clear();
        }
    }
}
