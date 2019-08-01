package com.wya.env.module.login;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.Toast;

import com.wya.env.base.presenter.BasePresenter;
import com.wya.env.bean.BaseResult;
import com.wya.env.bean.login.LoginInfo;
import com.wya.env.net.BaseObserver;
import com.wya.env.net.BaseRequest;
import com.wya.env.net.api.ResultApi;
import com.wya.env.utils.ResultStatusUtil;
import com.wya.uikit.toast.WYAToast;

/**
 * @date: 2018/5/31 13:57
 * @author: Chunjiang Mao
 * @classname: LoginPresenter
 * @describe: 登录的P层
 */

public class LoginPresenter extends BasePresenter<LoginView> {
    private ResultApi resultApi = new ResultApi();

    
    /**
     * 登录的方法
     *
     * @param userName
     * @param pwd
     */
    public void login(String userName, String pwd) {
        //业务逻辑的处理
        mView.showLoading();
        BaseObserver<BaseResult<LoginInfo>> request = BaseRequest.request(resultApi.loginApi(userName, pwd),
                new BaseObserver<BaseResult<LoginInfo>>(mView) {
            @Override
            public void onNext(BaseResult<LoginInfo> loginInfoBaseResult) {
                if (ResultStatusUtil.resultStatus(mView, loginInfoBaseResult)) {
                    Toast.makeText((Activity) mView, loginInfoBaseResult.msg, Toast.LENGTH_SHORT).show();
                    mView.onLoginResult(loginInfoBaseResult.data);
                }
            }
        });
        mCompositeDisposable.add(request);
    }
    
    public boolean checkInfo(String username, String password, Activity activity) {
        if (TextUtils.isEmpty(username) || "".equals(username) || username == null) {
            WYAToast.showShort(activity, "请输入用户名");
            return false;
        }
        if (TextUtils.isEmpty(password) || "".equals(password) || password == null) {
            WYAToast.showShort(activity, "请输入密码");
            return false;
        }
        
        return true;
        
    }

}
