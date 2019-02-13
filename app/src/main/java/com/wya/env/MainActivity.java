package com.wya.env;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.MenuItem;

import com.wya.env.base.BaseActivity;
import com.wya.env.module.home.fragment.Fragment1;
import com.wya.env.module.mine.Fragment2;
import com.wya.uikit.tabbar.WYATabBar;

import butterknife.BindView;

/**
 * @date: 2019/1/9 14:04
 * @author: Chunjiang Mao
 * @classname: MainActivity
 * @describe: MainActivity
 */

public class MainActivity extends BaseActivity {
    
    @BindView(R.id.tab)
    WYATabBar tab;
    
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    
    @Override
    protected void initView() {
        initFragment();
        setToolBar();
    }
    
    private void initFragment() {
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.content, fragment1);
        fragmentTransaction.add(R.id.content, fragment2);
        fragmentTransaction.show(fragment1).hide(fragment2).commit();
    }
    
    private void setToolBar() {
        //取消偏移
        tab.disableShiftMode();
        //取消item动画
        tab.enableAnimation(false);
        //item点击监听
        tab.setOnNavigationItemSelectedListener((MenuItem item) -> {
            fragmentTransaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_my:
                    fragmentTransaction.show(fragment2).hide(fragment1).commit();
                    break;
                case R.id.navigation_my_study:
                    fragmentTransaction.show(fragment1).hide(fragment2).commit();
                    break;
                default:
                    break;
            }
            return true;
        });
    }
    
    @Override
    protected int getLayoutId() {
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
            showShort("再按一次退出程序");
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
