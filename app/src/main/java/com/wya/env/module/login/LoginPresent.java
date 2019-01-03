package com.wya.env.module.login;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.Toast;

import com.wya.env.base.BasePresent;
import com.wya.env.bean.BaseResult;
import com.wya.env.bean.login.LoginInfo;
import com.wya.env.data.net.BaseExt;
import com.wya.env.data.net.BaseSubscriber;
import com.wya.env.data.net.api.ResultApi;
import com.wya.env.util.ResultStatusUtil;
import com.wya.env.util.ToastUtils;


/**
 * Created by Administrator on 2018/5/31 0031.
 * 登录的P层
 */

public class LoginPresent extends BasePresent<LoginView> {
    private ResultApi resultApi=new ResultApi();

    //登录的方法
    public void login(String userName,String pwd){
        //业务逻辑的处理
        mView.showLoading();
        BaseExt.ext(resultApi.loginApi(userName, pwd),new BaseSubscriber<BaseResult<LoginInfo>>(mView){
            @Override
            public void onNext(BaseResult<LoginInfo> loginInfoBaseResult) {
                if (ResultStatusUtil.resultStatus(mView,loginInfoBaseResult.status,loginInfoBaseResult.msg)){//返回true
                    Toast.makeText((Activity)mView,loginInfoBaseResult.msg,Toast.LENGTH_SHORT).show();
                    mView.onLoginResult(loginInfoBaseResult.data);
                }
            }
        });
    }

    public boolean checkInfo(String username,String password,Activity activity){
        if (TextUtils.isEmpty(username) || "".equals(username) || username == null) {
            ToastUtils.showToast(activity, "请输入用户名");
            return false;
        }
        if (TextUtils.isEmpty(password) || "".equals(password) || password == null) {
            ToastUtils.showToast(activity, "请输入密码");
            return false;
        }

        return true;

    }

}
