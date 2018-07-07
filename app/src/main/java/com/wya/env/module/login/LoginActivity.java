package com.wya.env.module.login;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

import com.jakewharton.rxbinding2.view.RxView;
import com.wya.env.MainActivity;
import com.wya.env.R;
import com.wya.env.base.BaseMvpActivity;
import com.wya.env.bean.login.LoginInfo;
import com.wya.env.common.CommonValue;
import com.wya.env.util.SaveSharedPreferences;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/7/3 0003.
 */

public class LoginActivity extends BaseMvpActivity<LoginPresent> implements LoginView {

    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.but_login)
    Button butLogin;
    private LoginPresent loginPresent = new LoginPresent();

    @Override
    protected void initView() {
        getSwipeBackLayout().setEnableGesture(false);
        loginPresent.mView = this;
        RxView.clicks(butLogin)
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe(Observable -> {
                    String userName = username.getText().toString().trim();
                    String pwd = password.getText().toString().trim();
                    boolean isRight = loginPresent.checkInfo(userName,pwd, this);
                    if (isRight){
                        loginPresent.login(userName,pwd);
                    }
                } );


    }

    /**
     * 登录结果的返回
     *
     * @param loginInfo
     */
    @Override
    public void onLoginResult(LoginInfo loginInfo) {
        //保存数据
        saveInfo(loginInfo);
        //跳转到主界面
        startActivity(new Intent(this, MainActivity.class));
        finish();

    }

    private void saveInfo(LoginInfo loginInfo) {
        SaveSharedPreferences.save(LoginActivity.this, CommonValue.ISLOGIN, true);

    }


    @Override
    protected int getLayoutID() {
        return R.layout.login_activity;
    }

}
