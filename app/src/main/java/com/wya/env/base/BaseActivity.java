package com.wya.env.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.GestureDetector;

import com.wya.env.R;
import com.wya.env.util.GestureFlingRightHelper;
import com.wya.uikit.dialog.WYALoadingDialog;
import com.wya.uikit.toast.WYAToast;
import com.wya.uikit.toolbar.BaseToolBarActivity;
import com.wya.utils.utils.ColorUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @date: 2018/7/3 13:48
 * @author: Chunjiang Mao
 * @classname: BaseActivity
 * @describe: BaseActivity
 */

public abstract class BaseActivity extends BaseToolBarActivity {
    private Unbinder unbinder;
    public WYALoadingDialog loadingDialog;
    private boolean mIsSwipeBack = false;
    private GestureDetector mGestureDetector;
    
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        initToolBar();
        unbinder = ButterKnife.bind(this);
        loadingDialog = new WYALoadingDialog(this, false, false);
        initView();
        initGesture();
    }
    
    private void initGesture() {
        DisplayMetrics outMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        mGestureDetector = GestureFlingRightHelper.getInstance().getGestureDetector(this, () -> {
            if (mIsSwipeBack) {
                finish();
                return true;
            } else {
                return false;
            }
        }, outMetrics.widthPixels);
    }
    
    private void initToolBar() {
        initWYAActionBarDefault(true, "#ffffff", true, "初始化标题", 18, "#000000",
                false, "", 14, "#000000", true, R.drawable.icon_backblue,
                false, "", 14, "#000000", false, false, R.drawable.icon_search, R.drawable.iocn_saoyisao, false, "", 14, "#000000", false);
        initToolBarBgColor(ColorUtil.hex2Int("#ffffff"), true);
    }
    
    /**
     * 初始化view
     */
    protected abstract void initView();
    
    /**
     * 获取布局id
     *
     * @return
     */
    @Override
    protected abstract int getLayoutID();
    
    public WYAToast getWyaToast() {
        return new WYAToast(this);
    }
    
    @Override
    protected void onDestroy() {
        if (unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }
        super.onDestroy();
    }
    
}
