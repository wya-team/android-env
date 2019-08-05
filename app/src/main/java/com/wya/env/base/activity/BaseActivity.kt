package com.wya.env.base.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import com.wya.env.R
import com.wya.env.databinding.BaseLayoutBinding
import kotlinx.android.synthetic.main.base_layout.*

/**
 *     @author : xdl
 *     @time   : 2019/08/03
 *     @describe :
 */
abstract class BaseActivity<V : ViewDataBinding, VM : ViewModel> : RxAppCompatActivity() {

    private lateinit var binding: V
    private lateinit var baseBinding: BaseLayoutBinding
    private lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_layout)
        baseBinding=DataBindingUtil.setContentView(this,R.layout.base_layout)
//        initToolbar()
//        binding = DataBindingUtil.inflate(layoutInflater, getLayoutId(), null, false)

    }

    private fun initToolbar() {
        setSupportActionBar(baseToolbar)

        baseToolbar.setNavigationIcon(R.drawable.icon_back)
        supportActionBar!!.title="Test"
    }

    abstract fun getLayoutId(): Int

}