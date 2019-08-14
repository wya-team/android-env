package com.wya.env.base.model

import com.wya.env.rxbus.RxBus
import com.wya.env.rxbus.event.ShowLoadingEvent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 *     @author : xdl
 *     @time   : 2019/08/07
 *     @describe :
 */
open class BaseRepository(private val clazz: Class<*>) : IModel {
    private var compositeDisposable: CompositeDisposable? = null


    fun addDisposable(disposable: Disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = CompositeDisposable()
        }
        compositeDisposable?.add(disposable)
    }

    fun showLoading() {
        RxBus.getInstance().post(ShowLoadingEvent(clazz))
    }


    /**
     * 清除内存
     */
    override fun clear() {
        compositeDisposable?.dispose()
        compositeDisposable?.clear()
    }

}