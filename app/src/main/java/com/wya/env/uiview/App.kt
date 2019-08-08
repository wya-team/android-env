package com.wya.env.uiview

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import com.wya.env.R
import com.wya.env.util.DynamicTimeFormatUtil

/**
 * @date: 2019/1/3 16:19
 * @author: Chunjiang Mao
 * @classname: App
 * @describe:
 */

class App  : Application() {

    companion object {
        init {
            //启用矢量图兼容
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
            SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, layout ->
                //第一个参数是刷新的背景色，第二个参数是涮选的字体颜色
                layout.setPrimaryColorsId(R.color.refresh_bg, R.color.colorPrimary)
                ClassicsHeader(context).setTimeFormat(DynamicTimeFormatUtil("更新于 %s"))
            }
        }

        private var instance: App? = null

        @Synchronized
        @JvmStatic
        fun getInstance(): App {
            return instance!!
        }

    }
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
