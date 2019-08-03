package com.wya.env.util

import android.app.Activity

import com.wya.env.base.BaseView

/**
 * @date: 2018/5/31 14:00
 * @author: Chunjiang Mao
 * @classname: ResultStatusUtil
 * @describe: 返回结果处理的封装
 */

object ResultStatusUtil {
    fun resultStatus(mView: BaseView, status: Int, msg: String): Boolean {
        if (status == 1) {
            return true
        }
        if (status == 0) {
            mView.failedResult(msg)
            return false
        }
        if (status == -1) {
            mView.tokenFaile(mView as Activity)
            return false
        }
        return false
    }
}
