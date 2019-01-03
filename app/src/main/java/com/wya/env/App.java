package com.wya.env;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.wya.env.util.DynamicTimeFormatUtil;

/**
 * 创建日期：2019/1/3 16:19
 * 作者： Mao Chunjiang
 * 文件名称：App
 * 类说明：App
 */

public class App extends Application {

    private static App INSTANCE;

    public static App getInstance() {
        return INSTANCE;
    }

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
    }
}
