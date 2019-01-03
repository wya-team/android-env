package com.wya.env.base;

import android.app.Activity;

/**
 * Created by Administrator on 2018/7/3 0003.
 * 基类View层
 */

public interface BaseView {
    //显示加载框
    void showLoading();
    //隐藏加载框
    void hideLoading();
    //请求失败
    void failedResult(String s);
    //token失效
    void tokenFaile(Activity activity);
}
