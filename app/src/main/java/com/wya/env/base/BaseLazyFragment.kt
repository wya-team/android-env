package com.wya.env.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wya.uikit.toast.WYAToast


/**
 * @date: 2018/7/3 13:48
 * @author: Chunjiang Mao
 * @classname: BaseLazyFragment
 * @describe: BaseLazyFragment
 */

abstract class BaseLazyFragment : Fragment() {
    protected var rootView: View? = null
    /**
     * 当前Fragment是否处于可见状态标志，防止因ViewPager的缓存机制而导致回调函数的触发
     */
    private var isFragmentVisible: Boolean = false
    /**
     * 是否是第一次开启网络加载
     */
    var isFirst: Boolean = false
    var token: String? = null

    /**
     * 获取布局文件
     *
     * @return
     */
    protected abstract val layoutResource: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (rootView == null) {
            rootView = inflater.inflate(layoutResource, container, false)
        }
        initView()
        //可见，但是并没有加载过
        if (isFragmentVisible && !isFirst) {
            onFragmentVisibleChange(true)
        }
        return rootView
    }

    /**
     * 初始化view
     */
    protected abstract fun initView()

    fun showShort(msg: String) {
        WYAToast.showShort(activity, msg)
    }

    fun toastShowLong(msg: String) {
        WYAToast.showLong(activity, msg)
    }

    fun toastShowLong(msg: String, res: Int, gravity: Int) {
        WYAToast.showToastWithImage(activity, msg, res, gravity)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            isFragmentVisible = true
        }
        if (rootView == null) {
            return
        }
        //可见，并且没有加载过
        if (!isFirst && isFragmentVisible) {
            onFragmentVisibleChange(true)
            return
        }
        //由可见——>不可见 已经加载过
        if (isFragmentVisible) {
            onFragmentVisibleChange(false)
            isFragmentVisible = false
        }
    }

    /**
     * 当前fragment可见状态发生变化时会回调该方法
     * 如果当前fragment是第一次加载，等待onCreateView后才会回调该方法，其它情况回调时机跟 [.setUserVisibleHint]一致
     * 在该回调方法中你可以做一些加载数据操作，甚至是控件的操作.
     *
     * @param isVisible true  不可见 -> 可见
     * false 可见  -> 不可见
     */
    open fun onFragmentVisibleChange(isVisible: Boolean) {

    }

}
