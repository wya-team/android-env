package com.wya.env.base

import android.app.Activity

/**
 * @date: 2018/7/3 13:49
 * @author: Chunjiang Mao
 * @classname: BaseView
 * @describe: 基类View层
 */

interface BaseView {
    /**
     * 显示加载框
     */
    fun showLoading()

    /**
     * 隐藏加载框
     */
    fun hideLoading()

    /**
     * 请求失败
     *
     * @param s
     */
    fun failedResult(s: String)

    /**
     * token失效
     *
     * @param activity
     */
    fun tokenFaile(activity: Activity)
}
