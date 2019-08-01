package com.wya.env.base.activity;

import android.content.Intent;

import com.wya.env.MainActivity;
import com.wya.env.base.view.BaseView;
import com.wya.env.base.presenter.AbstractPresenter;

/**
 * @date: 2018/7/3 13:48
 * @author: Chunjiang Mao
 * @classname: BaseMvpActivity
 * @describe: BaseMvpActivity
 */

public abstract class BaseMvpActivity<T extends AbstractPresenter> extends BaseActivity implements BaseView {
    
    /**
     * 显示加载对话框
     */
    @Override
    public void showLoading() {
        loadingDialog.show();
    }
    
    /**
     * 隐藏加载对话框
     */
    @Override
    public void hideLoading() {
        loadingDialog.dismiss();
    }
    
    /**
     * 失败回调
     *
     * @param s
     */
    @Override
    public void errorResult(String s) {
        showShort(s);
    }
    
    /**
     * token失效
     */
    @Override
    public void tokenFailure() {
        //跳转到登陆界面
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
