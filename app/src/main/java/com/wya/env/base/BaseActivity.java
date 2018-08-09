package com.wya.env.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.slide_libray.swipeback.SwipeBackActivity;
import com.wya.views.dialog.LoadingDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;
import com.wya.env.util.StatusUtil;

/**
 * Created by Administrator on 2018/7/3 0003.
 */

public abstract class BaseActivity extends SwipeBackActivity {
    public static final CompositeDisposable mDisposables = new CompositeDisposable();
    private Unbinder unbinder;
    public LoadingDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        StatusUtil.setStatusBarColor(this, android.R.color.white);
        StatusUtil.setStatue(this, true);
        unbinder = ButterKnife.bind(this);
        loadingDialog = new LoadingDialog(this,true);
        initView();
    }

    protected abstract void initView();

    protected abstract int getLayoutID();

    @Override
    protected void onDestroy() {
        if (unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }
        super.onDestroy();
        if (mDisposables != null) {
            mDisposables.clear();
        }

    }

}
