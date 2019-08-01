package com.wya.env.base.fragment;

import android.content.Intent;

import com.wya.env.MainActivity;
import com.wya.env.base.presenter.AbstractPresenter;
import com.wya.env.base.view.BaseView;

/**
 * @date: 2018/7/3 13:48
 * @author: Chunjiang Mao
 * @classname: BaseMvpFragment
 * @describe: BaseMvpFragment
 */

public abstract class BaseMvpFragment<T extends AbstractPresenter> extends BaseLazyFragment implements BaseView {
    /**
     * 显示加载对话框
     */
    @Override
    public void showLoading() {
    
    }
    
    /**
     * 隐藏加载对话框
     */
    @Override
    public void hideLoading() {
    
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
        startActivity(new Intent(getActivity(), MainActivity.class));
        getActivity().finish();
        
    }
    
}
