package com.wya.env.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.trello.rxlifecycle2.components.support.RxFragment

abstract class BaseFragment<V : ViewDataBinding, VM : ViewModel> : RxFragment() {


    lateinit var viewModel: VM
    lateinit var binding: V

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(layoutInflater, getLayoutId(), container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initBindingViewModel()
        initView()
    }

    private fun initBindingViewModel() {
        viewModel = initViewModel()
        binding.setVariable(getVariableId(), viewModel)
        binding.lifecycleOwner = this
    }


    /**
     * 获取当前ViewModel对象
     *
     * @return VM
     */
    abstract fun initViewModel(): VM

    /**
     * 布局id
     *
     * @return Int
     */
    abstract fun getLayoutId(): Int

    /**
     * 初始化布局
     */
    abstract fun initView()

    /**
     * 获取ViewModel的variableId 用于绑定DataBinding
     *
     * @return Int
     */
    abstract fun getVariableId(): Int
}
