package com.wya.env;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;


import com.wya.views.bottomtabbar.BottomTabBar;

import butterknife.BindView;

import com.wya.env.base.BaseActivity;
import com.wya.env.module.home.fragment.Fragment1;
import com.wya.env.module.mine.Fragment2;
import com.wya.env.util.ToastUtils;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bottom_tab_bar)
    BottomTabBar bottomTabBar;

    @Override
    protected void initView() {
        getSwipeBackLayout().setEnableGesture(false);
        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(60, 60)//设置图片尺寸
                .setFontSize(12)//设置字体尺寸
                .setTabPadding(10, 6, 10)
                .setChangeColor(Color.BLUE, Color.GRAY)//设置选中和未选中的颜色
                .addTabItem("首页", R.mipmap.mystudy_select, R.mipmap.mystudy_normal, Fragment1.class)
                .addTabItem("我的", R.mipmap.my_select, R.mipmap.my_normal, Fragment2.class)
                .isShowDivider(true)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name, View view) {

                    }
                });
    }

    @Override
    protected int getLayoutID() {
        return R.layout.main_activity;
    }

    /**
     * 双击返回键退出app
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private static boolean isExit = false;

    private void exit() {
        if (!isExit) {
            isExit = true;
            ToastUtils.showToast(this, "再按一次退出程序");
            handler.sendEmptyMessageDelayed(0, 2000);
        } else {
            this.finish();
        }
    }

    @SuppressLint("HandlerLeak")
    private static Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };

}
