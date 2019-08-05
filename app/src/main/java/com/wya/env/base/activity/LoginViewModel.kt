package com.wya.env.base.activity

import android.app.Application
import com.wya.env.base.viewmodel.BaseViewModel
import com.wya.env.uiview.login.LoginModel

/**
 *     @author : xdl
 *     @time   : 2019/08/03
 *     @describe :
 */

class LoginViewModel : BaseViewModel<LoginModel>{
    constructor(application: Application,loginModel: LoginModel):super(application,loginModel){

    }
}
