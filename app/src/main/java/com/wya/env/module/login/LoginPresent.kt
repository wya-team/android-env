package com.wya.env.module.login

import android.app.Activity
import android.text.TextUtils
import android.widget.Toast

import com.wya.env.base.BasePresent
import com.wya.env.bean.BaseResult
import com.wya.env.bean.login.LoginInfo
import com.wya.env.http.BaseExt
import com.wya.env.http.BaseSubscriber
import com.wya.env.http.api.ResultApi
import com.wya.env.util.ResultStatusUtil
import com.wya.uikit.toast.WYAToast

/**
 * @date: 2018/5/31 13:57
 * @author: Chunjiang Mao
 * @classname: LoginPresent
 * @describe: 登录的P层
 */

class LoginPresent : BasePresent<LoginView>() {
    private val resultApi = ResultApi()

    /**
     * 登录的方法
     *
     * @param userName
     * @param pwd
     */
    fun login(userName: String, pwd: String) {
        //业务逻辑的处理
        mView!!.showLoading()
        BaseExt.ext(resultApi.loginApi(userName, pwd), object : BaseSubscriber<BaseResult<LoginInfo>>(mView!!) {
            override fun onNext(t: BaseResult<LoginInfo>) {
                if (ResultStatusUtil.resultStatus(mView!!, t.status, t.msg!!)) {
                    Toast.makeText(mView as Activity, t.msg, Toast.LENGTH_SHORT).show()
                    mView!!.onLoginResult(t.data!!)
                }
            }
        })
    }

    fun checkInfo(username: String?, password: String?, activity: Activity): Boolean {
        if (TextUtils.isEmpty(username) || "" == username || username == null) {
            WYAToast.showShort(activity, "请输入用户名")
            return false
        }
        if (TextUtils.isEmpty(password) || "" == password || password == null) {
            WYAToast.showShort(activity, "请输入密码")
            return false
        }

        return true

    }

}
