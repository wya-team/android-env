package com.wya.env.base;

import android.app.Activity;
import android.content.Intent;

import com.wya.env.MainActivity;
import com.wya.env.util.ToastUtils;

/**
 * Created by Administrator on 2018/7/3 0003.
 */

public abstract class BaseMvpActivity<T extends BasePresent> extends BaseActivity implements BaseView {


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
    public void hideLodoing() {
        loadingDialog.dismiss();
    }

    /**
     * 失败回调
     * @param s
     */
    @Override
    public void failedResult(String s) {
        ToastUtils.showToast(this, s);

    }

    /**
     * token失效
     */
    @Override
    public void tokenFaile(Activity activity) {
        //跳转到登陆界面
        startActivity(new Intent(activity, MainActivity.class));
        activity.finish();

    }


}
