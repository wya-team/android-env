package com.wya.env.binding.viewadapter.imageview

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.wya.env.uiview.App

/**
 *     @author : xdl
 *     @time   : 2019/08/12
 *     @describe :
 */
object ViewAdapter {
    @JvmStatic
    @BindingAdapter("android:urlSrc")
    fun setImageUrl(view: ImageView, url: String) {
        Glide.with(App.getInstance()).load(url).into(view)
    }
}