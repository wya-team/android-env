package com.wya.env.base.view;

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
    void errorResult(String s);
    
    /**
     * token失效
     *
     * @param view
     */
    void tokenFailure();
}
