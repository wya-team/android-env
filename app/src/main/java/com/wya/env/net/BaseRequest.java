package com.wya.env.net;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @date: 2018/5/31 13:58
 * @author: Chunjiang Mao
 * @classname: BaseRequest
 * @describe: 基类Observanle，防止多次写相同代码
 */
public class BaseRequest {

    public static <T> BaseObserver<T> request(Observable<T> observable, BaseObserver<T> observer) {
        return observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(observer);
    }
}
