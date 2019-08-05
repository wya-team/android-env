package com.wya.env.http

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @date: 2018/5/31 13:58
 * @author: Chunjiang Mao
 * @classname: BaseExt
 * @describe: 基类Observanle，防止多次写相同代码
 */

object BaseExt {
    fun <T> ext(observable: Observable<T>, observer: Observer<T>) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }
}
