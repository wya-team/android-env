package com.wya.env.http.api

import com.wya.env.bean.BaseResult
import com.wya.env.bean.LoginInfo
import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import java.util.*

/**
 * @date: 2018/7/3 13:44
 * @author: Chunjiang Mao
 * @classname: Api
 * @describe: 请求数据的接口
 */

interface ApiService {
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
