package com.wya.env.base.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 *     @author : xdl
 *     @time   : 2019/08/09
 *     @describe :
 */
abstract class BaseBindingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(iItem: IItem)
}