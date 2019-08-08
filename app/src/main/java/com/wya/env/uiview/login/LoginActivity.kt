package com.wya.env.uiview.login

import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.wya.env.BR
import com.wya.env.R
import com.wya.env.base.activity.BaseActivity
import com.wya.env.common.Constant
import com.wya.env.databinding.ActivityLoginBinding
import com.wya.env.util.SharedPreferencesUtil


class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {
    /**
     * 获取viewmodel的variableId 用于绑定databinding
     * @return Int
     */
    override fun getVariableId(): Int {
        return BR.viewModel
    }


    override fun initViewModel(): LoginViewModel {
        return ViewModelProviders.of(this, ViewModelProvider.AndroidViewModelFactory(application))
                .get(LoginViewModel::class.java)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initView() {
        viewModel.initTitle()
        Log.e("test",SharedPreferencesUtil.getInstance().getBoolean(Constant.IS_LOGIN).toString())
    }


    override fun initObserveEvent() {
        super.initObserveEvent()
        viewModel.loginInfo.observe(this, Observer {
            viewModel.saveLoginInfo()
        })
    }


}
