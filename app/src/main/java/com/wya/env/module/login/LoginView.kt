package com.wya.env.module.login

import com.wya.env.base.BaseView
import com.wya.env.bean.login.LoginInfo

/**
 * @date: 2018/5/31 13:57
 * @author: Chunjiang Mao
 * @classname: LoginView
 * @describe:
 */

interface LoginView : BaseView {
    /**
     * 登录返回结果
     *
     * @param loginInfo
     */
    fun onLoginResult(loginInfo: LoginInfo)
}
