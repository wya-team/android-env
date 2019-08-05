package com.wya.env.http

import com.wya.env.base.BaseView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * @date: 2018/5/31 13:59
 * @author: Chunjiang Mao
 * @classname: BaseSubscriber
 * @describe: 写一个Subscriber继承Observer，重写相应的方法，在具体调用时，只需要重写你需要的onNext方法即可，不需要写入其余的回调方法
 */

open class BaseSubscriber<T>(private val mBaseView: BaseView) : Observer<T> {
    private var disposable: Disposable? = null

    override fun onSubscribe(d: Disposable) {
        disposable = d
    }

    override fun onNext(t: T) {
        mBaseView.hideLoading()
    }

    override fun onError(e: Throwable) {
        mBaseView.hideLoading()
        mBaseView.failedResult(e.message!!)
    }

    override fun onComplete() {
        mBaseView.hideLoading()
    }
}
