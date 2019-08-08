package com.wya.env.http

import com.wya.env.common.Constant
import com.wya.env.http.api.ApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @date: 2018/5/31 13:59
 * @author: Chunjiang Mao
 * @classname: RetrofitFactory
 * @describe: Retrofit的创建工厂
 */

class RetrofitFactory private constructor(){

    private val retrofit: Retrofit


    init {

        retrofit = Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .client(initClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    private fun initClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(initLogInterceptor())
                .connectTimeout(100, TimeUnit.SECONDS)
                .writeTimeout(100, TimeUnit.SECONDS)
                .build()
    }

    private fun initLogInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    fun <T> create(cls: Class<T>): T {
        return retrofit.create(cls)
    }

    fun create(): ApiService {
        return create(ApiService::class.java)
    }

    companion object {

        private var instances: RetrofitFactory ?=null
             get() {
                 if (field == null) {
                     field=RetrofitFactory()
                 }
                 return field
             }
        @Synchronized
        fun get():RetrofitFactory{
            return instances!!
        }
    }
}
