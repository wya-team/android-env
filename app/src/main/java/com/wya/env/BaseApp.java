package com.wya.env;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.wya.env.base.AppLifestyle;
import com.wya.env.util.DynamicTimeFormatUtil;
import com.wya.env.util.SystemUtil;

public class BaseApp extends Application implements AppLifestyle {
    
    private static BaseApp APPLICATION;
    
    static {
        //初始化刷新头部
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);//启用矢量图兼容
        SmartRefreshLayout.setDefaultRefreshHeaderCreator((context, layout) -> {
            layout.setPrimaryColorsId(R.color.refresh_bg, R.color.colorPrimary);//第一个参数是刷新的背景色，第二个参数是涮选的字体颜色
            return new ClassicsHeader(context).setTimeFormat(new DynamicTimeFormatUtil("更新于 %s"));
        });
    }
    
    @Override
    public void onCreate() {
        super.onCreate();
        APPLICATION = this;
        if (SystemUtil.isProcess(getApp().getPackageName())) {
            init();
        }
    }
    
    private void init() {
    
    }
    
    public static BaseApp getApp() {
        return APPLICATION;
    }
    
    @Override
    public void onBaseContextAttached(Context base) {
    
    }
}
