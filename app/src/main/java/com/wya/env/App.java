package com.wya.env;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.wya.env.util.DynamicTimeFormatUtil;

/**
 * @date: 2019/1/3 16:19
 * @author: Chunjiang Mao
 * @classname: App
 * @describe:
 */

public class App extends Application {
    
    private static App INSTANCE;
    
    public static App getInstance() {
        return INSTANCE;
    }
    
    static {
        //启用矢量图兼容
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        SmartRefreshLayout.setDefaultRefreshHeaderCreator((context, layout) -> {
            //第一个参数是刷新的背景色，第二个参数是涮选的字体颜色
            layout.setPrimaryColorsId(R.color.refresh_bg, R.color.colorPrimary);
            return new ClassicsHeader(context).setTimeFormat(new DynamicTimeFormatUtil("更新于 %s"));
        });
    }
    
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
