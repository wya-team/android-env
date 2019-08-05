package com.wya.env.base

import android.app.Activity
import android.content.Intent

import com.wya.env.module.MainActivity

/**
 * @date: 2018/7/3 13:48
 * @author: Chunjiang Mao
 * @classname: BaseMvpFragment
 * @describe: BaseMvpFragment
 */

abstract class BaseMvpFragment<T : BasePresent<*>> : BaseLazyFragment(), BaseView {
    /**
     * 显示加载对话框
     */
    override fun showLoading() {

    }

    /**
     * 隐藏加载对话框
     */
    override fun hideLoading() {

    }

    /**
     * 失败回调
     *
     * @param s
     */
    override fun failedResult(s: String) {
        showShort(s)
    }

    /**
     * token失效
     */
    override fun tokenFaile(activity: Activity) {
        //跳转到登陆界面
        startActivity(Intent(activity, MainActivity::class.java))
        activity.finish()

    }

}
