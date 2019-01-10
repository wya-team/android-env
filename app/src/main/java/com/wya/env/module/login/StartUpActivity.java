package com.wya.env.module.login;

import android.content.Intent;

import com.wya.env.MainActivity;
import com.wya.env.R;
import com.wya.env.base.BaseActivity;
import com.wya.env.common.CommonValue;
import com.wya.env.util.SaveSharedPreferences;
import com.wya.utils.utils.ColorUtil;

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
        initShowToolBar(false);
        initToolBarBgColor(ColorUtil.hex2Int("#ffffff"), true);
        //是否登录
        boolean isLogin = SaveSharedPreferences.getBoolean(this, CommonValue.IS_LOGIN);
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
    protected int getLayoutID() {
        return R.layout.start_up_activity;
    }
}
