package com.wya.env.http.api

import java.util.HashMap

import io.reactivex.Observable

import com.wya.env.bean.BaseResult
import com.wya.env.bean.login.LoginInfo

import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * @date: 2018/7/3 13:44
 * @author: Chunjiang Mao
 * @classname: Api
 * @describe: 请求数据的接口
 */

interface Api {
    /**
     * 登录
     *
     * @param hashMap
     * @return
     */
    @FormUrlEncoded
    @POST("app/login")
    fun login(@FieldMap hashMap: HashMap<String, String>): Observable<BaseResult<LoginInfo>>
}
