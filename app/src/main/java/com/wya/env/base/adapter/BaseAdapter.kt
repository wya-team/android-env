package com.wya.env.base.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView

/**
 * @author : xdl
 * @time   : 2019/08/09
 * @describe : RecyclerView 适配器，注意item的variableName 必须叫做dataBean
 */

class BaseAdapter<T>(private var list: List<T>,
                     private var layoutId: Int,
                     private var listener: BaseAdapter.OnItemClickListener) : RecyclerView.Adapter<BaseAdapter.BindingViewHolder>() {
    var bind: ViewDataBinding? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        bind = DataBindingUtil.inflate(inflater, layoutId, parent, false)
        return BindingViewHolder(bind!!)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        holder.bind(list[position])
        listener.item(bind!!,position)
    }

    class BindingViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun <T> bind(data: T) {
            binding.setVariable(BR.dataBean, data)
            binding.executePendingBindings()
        }
    }


    interface OnItemClickListener{
        fun item(binding: ViewDataBinding, position: Int)
    }

}