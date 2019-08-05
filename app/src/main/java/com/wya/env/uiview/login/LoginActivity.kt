package com.wya.env.uiview.login

import com.wya.env.R
import com.wya.env.base.activity.BaseActivity
import com.wya.env.base.activity.LoginViewModel
import com.wya.env.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity<ActivityLoginBinding,LoginViewModel>(){
    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login)
//        DataBindingUtil.setContentView<ViewDataBinding>(this,R.layout.activity_login)
//    }
}
