package com.wya.env.base;

import android.app.Activity;
import android.content.Intent;

import com.wya.env.MainActivity;


public abstract class BaseMvpFragment<T extends BasePresent> extends BaseLazyFragment implements BaseView {
    /**
     * 显示加载对话框
     */
    @Override
    public void showLoading() {

    }

    /**
     * 隐藏加载对话框
     */
    @Override
    public void hideLoading() {

    }

    /**
     * 失败回调
     *
     * @param s
     */
    @Override
    public void failedResult(String s) {
        getWyaToast().showShort(s);
    }

    /**
     * token失效
     */
    @Override
    public void tokenFaile(Activity activity) {
        //跳转到登陆界面
        startActivity(new Intent(activity, MainActivity.class));
        activity.finish();

    }

}
