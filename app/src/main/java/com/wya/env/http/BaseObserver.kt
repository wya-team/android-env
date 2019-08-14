package com.wya.env.http

import com.wya.env.rxbus.RxBus
import com.wya.env.rxbus.event.DismissLoadingEvent
import io.reactivex.observers.ResourceObserver

/**
 * @date: 2018/5/31 13:59
 * @author: Chunjiang Mao
 * @classname: BaseSubscriber
 * @describe: 写一个Subscriber继承Observer，重写相应的方法，在具体调用时，只需要重写你需要的onNext方法即可，不需要写入其余的回调方法
 */

open class BaseObserver<T>(private val clazz: Class<*>) : ResourceObserver<T>(){

    override fun onNext(t: T) {
        dismissLoading()
    }

    override fun onError(e: Throwable) {
//        mBaseView.errorResult(e.message!!)
        dismissLoading()
    }

    override fun onComplete() {
        dismissLoading()
    }

    private fun dismissLoading() {
        RxBus.getInstance().post(DismissLoadingEvent(clazz))
    }
}
