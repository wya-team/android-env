package com.wya.env.data.net;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/31 0031.
 * 基类Observanle，防止多次写相同代码
 */

public class BaseExt {
    public  static  <T>void ext(Observable<T> observable,Observer<T>observer){
       observable.subscribeOn(Schedulers.io())
             .unsubscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe(observer);
    }
}
