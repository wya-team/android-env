package com.wya.env.binding.viewadapter.view

import android.view.View
import androidx.databinding.BindingAdapter

/**
 *     @author : xdl
 *     @time   : 2019/08/06
 *     @describe :
 */

object ViewAdapter {

    @JvmStatic
    @BindingAdapter("myClick", requireAll = false)
    fun onClick(view: View,string: String) {

    }
}