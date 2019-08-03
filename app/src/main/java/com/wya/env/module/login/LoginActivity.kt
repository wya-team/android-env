package com.wya.env.module.login

import android.content.Intent
import com.jakewharton.rxbinding2.view.RxView
import com.wya.env.MainActivity
import com.wya.env.R
import com.wya.env.base.BaseMvpActivity
import com.wya.env.bean.login.LoginInfo
import com.wya.env.common.CommonValue
import com.wya.env.util.SaveSharedPreferences
import kotlinx.android.synthetic.main.login_activity.*
import java.util.concurrent.TimeUnit


/**
 * @date: 2019/1/3 13:57
 * @author: Chunjiang Mao
 * @classname: LoginActivity
 * @describe: 登录
 */

class LoginActivity : BaseMvpActivity<LoginPresent>(), LoginView {

    private val loginPresent = LoginPresent()

    override fun initView() {
        showToolBar(false)
        setBackgroundColor(R.color.white, true)
        loginPresent.mView = this
        RxView.clicks(but_login!!)
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe { _ ->
                    val userName = username!!.text.toString().trim { it <= ' ' }
                    val pwd = password!!.text.toString().trim { it <= ' ' }
                    val isRight = loginPresent.checkInfo(userName, pwd, this)
                    if (isRight) {
                        loginPresent.login(userName, pwd)
                    }
                }

    }

    /**
     * 登录结果的返回
     *
     * @param loginInfo
     */
    override fun onLoginResult(loginInfo: LoginInfo) {
        //保存数据
        saveInfo()
        //跳转到主界面
        startActivity(Intent(this, MainActivity::class.java))
        finish()

    }

    private fun saveInfo() {
        SaveSharedPreferences.save(this@LoginActivity, CommonValue.IS_LOGIN, true)

    }

    override fun getLayoutId(): Int {
        return R.layout.login_activity
    }

}
