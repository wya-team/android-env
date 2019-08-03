package com.wya.env.base

import android.os.Bundle
import android.view.GestureDetector
import com.wya.env.R
import com.wya.uikit.dialog.WYALoadingDialog
import com.wya.uikit.toast.WYAToast
import com.wya.uikit.toolbar.BaseToolBarActivity

/**
 * @date: 2018/7/3 13:48
 * @author: Chunjiang Mao
 * @classname: BaseActivity
 * @describe: BaseActivity
 */

abstract class BaseActivity : BaseToolBarActivity() {
    lateinit var loadingDialog: WYALoadingDialog
    private val mIsSwipeBack = false
    private var mGestureDetector: GestureDetector? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        initToolBar()
        loadingDialog = WYALoadingDialog(this, false, false)
        initView()
    }


    private fun initToolBar() {
        setBackgroundColor(R.color.white, true)
    }

    /**
     * 初始化view
     */
    protected abstract fun initView()

    /**
     * 获取布局id
     *
     * @return
     */
    abstract override fun getLayoutId(): Int

    fun showShort(msg: String) {
        WYAToast.showShort(this, msg)
    }

    fun toastShowLong(msg: String) {
        WYAToast.showLong(this, msg)
    }

    fun toastShowLong(msg: String, res: Int, gravity: Int) {
        WYAToast.showToastWithImage(this, msg, res, gravity)
    }



}
