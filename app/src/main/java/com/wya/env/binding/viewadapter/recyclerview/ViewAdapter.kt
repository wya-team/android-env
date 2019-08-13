package com.wya.env.binding.viewadapter.recyclerview

import android.util.Log
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 *     @author : xdl
 *     @time   : 2019/08/12
 *     @describe :
 */
object ViewAdapter {

    @JvmStatic
    @BindingAdapter("onItemClick")
    fun onItemClickListener(view: View, position: Int) {
        view.setOnClickListener {
            Log.i("test", "click")
        }
    }

    @JvmStatic
    @BindingAdapter("adapter")
    fun setAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>) {
        recyclerView.adapter = adapter
    }



}