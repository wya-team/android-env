package com.wya.env.module.login;

import android.content.Intent;

import com.wya.env.MainActivity;
import com.wya.env.R;
import com.wya.env.base.activity.BaseActivity;
import com.wya.env.common.Constant;
import com.wya.env.utils.SharedPreferencesUtil;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * @date: 2018/4/8 13:58
 * @author: Chunjiang Mao
 * @classname: StartUpActivity
 * @describe: 启动页
 */

public class StartUpActivity extends BaseActivity {
    
    @Override
    protected void initView() {
        showToolBar(false);
        setBackgroundColor(R.color.white, true);
        //是否登录
        boolean isLogin = SharedPreferencesUtil.getInstance().getBoolean( Constant.LOGIN);
        Observable.just(1).delay(1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    if (isLogin) {
                        startActivity(new Intent(StartUpActivity.this, MainActivity.class));
                        finish();
                    } else {
                        startActivity(new Intent(StartUpActivity.this, LoginActivity.class));
                        finish();
                    }
                });
    }
    
    @Override
    protected int getLayoutId() {
        return R.layout.start_up_activity;
    }
}
