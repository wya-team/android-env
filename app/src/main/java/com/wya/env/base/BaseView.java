package com.wya.env.base;

import android.app.Activity;

/**
 * @date: 2018/7/3 13:49
 * @author: Chunjiang Mao
 * @classname: BaseView
 * @describe: 基类View层
 */

public interface BaseView {
    /**
     * 显示加载框
     */
    void showLoading();
    
    /**
     * 隐藏加载框
     */
    void hideLoading();
    
    /**
     * 请求失败
     *
     * @param s
     */
    void failedResult(String s);
    
    /**
     * token失效
     *
     * @param activity
     */
    void tokenFaile(Activity activity);
}
