package com.wya.env.util

import android.widget.Toast
import com.wya.env.uiview.App

/**
 *     @author : xdl
 *     @time   : 2019/08/06
 *     @describe :
 */
object ToastUtils {

    @JvmStatic
    fun show(msg: String) {
        Toast.makeText(App.getInstance(),msg,Toast.LENGTH_SHORT).show()
    }
}