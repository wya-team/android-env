package com.wya.env.module.login;


import com.wya.env.base.BaseView;
import com.wya.env.bean.login.LoginInfo;

/**
 * Created by Administrator on 2018/5/31 0031.
 */

public interface LoginView extends BaseView {
     void onLoginResult(LoginInfo loginInfo);
}
