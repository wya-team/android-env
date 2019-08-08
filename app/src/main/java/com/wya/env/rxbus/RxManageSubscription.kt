package com.wya.env.rxbus

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 *     @author : xdl
 *     @time   : 2019/08/08
 *     @describe : 管理订阅
 */
object RxManageSubscription {
    private val compositeDisposable = CompositeDisposable()

    fun add(disposable: Disposable?) {
        if (disposable!=null) {
            compositeDisposable.add(disposable)
        }
    }

    fun remove(disposable: Disposable?) {
        disposable?.dispose()
        if (disposable!=null) {
            compositeDisposable.remove(disposable)
        }
    }

    fun clearAll() {
        compositeDisposable.dispose()
        compositeDisposable.clear()
    }

}