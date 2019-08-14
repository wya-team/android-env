package com.wya.env.uiview.login

import android.app.Application
import android.text.TextUtils
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.wya.env.base.viewmodel.BaseViewModel
import com.wya.env.common.Constant
import com.wya.env.util.SharedPreferencesUtil
import com.wya.env.util.ToastUtils

/**
 *     @author : xdl
 *     @time   : 2019/08/03
 *     @describe :
 */
class LoginViewModel(application: Application, var loginRepository: LoginRepository) : BaseViewModel(application) {
    val adminInput = MutableLiveData("")
    val adminPwd = MutableLiveData("")
    var loginInfo = loginRepository.data



    fun onClickLogin(view: View) {
        if (TextUtils.isEmpty(adminInput.value)) {
            ToastUtils.show("请输入用户名")
            return
        }
        if (TextUtils.isEmpty(adminPwd.value)) {
            ToastUtils.show("请输入密码")
            return
        }
        loginRepository.login(adminInput.value!!, adminPwd.value!!)
    }



    fun initTitle() {
        baseViewModel!!.setTitle("登录")
    }

    fun saveLoginInfo(){
        SharedPreferencesUtil.getInstance().save(Constant.IS_LOGIN,true)
    }

    override fun onCleared() {
        super.onCleared()
        loginRepository.clear()
    }

}
