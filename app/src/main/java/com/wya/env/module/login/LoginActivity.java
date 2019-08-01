package com.wya.env.module.login;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

import com.jakewharton.rxbinding2.view.RxView;
import com.wya.env.MainActivity;
import com.wya.env.R;
import com.wya.env.base.activity.BaseMvpActivity;
import com.wya.env.bean.login.LoginInfo;
import com.wya.env.common.Constant;
import com.wya.env.utils.SharedPreferencesUtil;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.disposables.Disposable;

/**
 * @date: 2019/1/3 13:57
 * @author: Chunjiang Mao
 * @classname: LoginActivity
 * @describe: 登录
 */

public class LoginActivity extends BaseMvpActivity<LoginPresenter> implements LoginView {
    
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.but_login)
    Button butLogin;
    private LoginPresenter loginPresent;
    
    @Override
    protected void initView() {
        showToolBar(false);
        setBackgroundColor(R.color.white, true);
        loginPresent = new LoginPresenter();
        loginPresent.attachView(this);

        Disposable disposable = RxView.clicks(butLogin)
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe(Observable -> {
                    String userName = username.getText().toString().trim();
                    String pwd = password.getText().toString().trim();
                    boolean isRight = loginPresent.checkInfo(userName, pwd, this);
                    if (isRight) {
                        loginPresent.login(userName, pwd);
                    }
                });
        loginPresent.addSubscribe(disposable);

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

        SharedPreferencesUtil.getInstance().save(Constant.LOGIN,true);
        
    }
    
    @Override
    protected int getLayoutId() {
        return R.layout.login_activity;
    }

    @Override
    protected void onDestroy() {
        loginPresent.detachView();
        super.onDestroy();
    }

}
