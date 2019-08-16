package com.wya.env.base.activity

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import com.wya.env.R
import com.wya.env.base.viewmodel.BaseViewModel
import com.wya.env.common.Constant
import com.wya.env.databinding.BaseLayoutBinding
import com.wya.env.rxbus.RxBus
import com.wya.env.rxbus.RxManageSubscription
import com.wya.env.rxbus.event.DismissLoadingEvent
import com.wya.env.rxbus.event.ShowLoadingEvent
import com.wya.uikit.dialog.WYALoadingDialog
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.base_layout.*

/**
 *     @author : xdl
 *     @time   : 2019/08/03
 *     @describe :
 */
abstract class BaseActivity<V : ViewDataBinding, VM : BaseViewModel> : RxAppCompatActivity() {

    lateinit var binding: V
    lateinit var viewModel: VM
    private lateinit var baseBinding: BaseLayoutBinding
    private lateinit var baseViewModel: BaseViewModel
    private var dialog: WYALoadingDialog? = null
    private var dialogShowDisposable:Disposable?=null
    private var dialogDismissDisposable:Disposable?=null
    private var mIntent = Intent()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_layout)
        initToolbar()
        initDataBinding()
        initObserveEvent()
        initView()
    }


    private fun initDataBinding() {
        //初始化base binding和ViewModel
        baseBinding = DataBindingUtil.setContentView(this, R.layout.base_layout)
        baseViewModel = ViewModelProvider(this).get(BaseViewModel::class.java)
        baseBinding.viewModel = baseViewModel
        baseBinding.lifecycleOwner = this

        //初始化实际Activity的布局中的binding和ViewModel
        val group = layoutInflater.inflate(getLayoutId(), null)
        contentLayout.addView(group)
        viewModel = initViewModel()
        viewModel.baseViewModel = baseViewModel
        binding = DataBindingUtil.inflate(layoutInflater, getLayoutId(), contentLayout, true)
        //ViewModel和binding绑定binding的布局不固定所以用
        binding.setVariable(getVariableId(), viewModel)
        binding.lifecycleOwner = this
    }


    /**
     * 初始化原生toolbar
     */
    private fun initToolbar() {
        //把原生title设置为空
        setSupportActionBar(baseToolbar)
        supportActionBar!!.title = ""
    }

    /**
     * 初始化观察事件，用于ViewModel和View层数据传递
     */
    open fun initObserveEvent() {
        //toolbar  back
        baseViewModel.backIconClick.observe(this, Observer {
            finish()
        })
        //startActivity
        baseViewModel.activityInfo.observe(this, Observer {
            var activity = it[Constant.ACTIVITY_CLAZZ]
            var bundle = it[Constant.ACTIVITY_BUNDLE]
            mIntent.setClass(this, activity as Class<*>)
            mIntent.putExtras(bundle as Bundle)
            startActivity(mIntent)
        })

        dialogShowDisposable = RxBus.getInstance().toObservable(ShowLoadingEvent::class.java)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    if (it.clazz == javaClass) {
                        showDialog()
                    }
                }


        dialogDismissDisposable=RxBus.getInstance().toObservable(DismissLoadingEvent::class.java)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    if (it.clazz == javaClass) {
                        dialog?.dismiss()
                    }
                }
        RxManageSubscription.add(dialogShowDisposable)
        RxManageSubscription.add(dialogDismissDisposable)

    }

    private fun showDialog() {
        if (dialog == null) {
            dialog = WYALoadingDialog(this, false, false)
            dialog!!.show()
        } else {
            dialog!!.show()
        }
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

    override fun onDestroy() {
        super.onDestroy()
        RxManageSubscription.remove(dialogShowDisposable)
        RxManageSubscription.remove(dialogDismissDisposable)
//        dialog?.cancel()
//        dialog = null

    }

}