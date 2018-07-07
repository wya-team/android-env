package com.wya.env.net;


import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import com.wya.env.common.Constance;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/5/31 0031.
 * Retrofit的创建工厂
 */

public class RetrofitFactory {

    private final Retrofit retrofit;

    private static class InstanceHolder {
        private static final RetrofitFactory instance = new RetrofitFactory();
    }

    public static RetrofitFactory getInstance() {
        return InstanceHolder.instance;
    }

    public RetrofitFactory() {

        retrofit = new Retrofit.Builder()
                .baseUrl(Constance.BASE_URL)
                .client(initClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private OkHttpClient initClient() {
        OkHttpClient client=new OkHttpClient.Builder()
                .addInterceptor(initLogInterceptor())
                .connectTimeout(100, TimeUnit.SECONDS)
                .writeTimeout(100,TimeUnit.SECONDS)
                .build();
        return client;
    }

    private Interceptor initLogInterceptor() {
        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

  public <T> T create(Class<T> cls){
        return retrofit.create(cls);
  }
}
