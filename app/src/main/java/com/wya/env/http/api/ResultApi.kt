package com.wya.env.http.api

import com.wya.env.bean.BaseResult
import com.wya.env.bean.LoginInfo
import com.wya.env.http.RetrofitFactory
import io.reactivex.Observable
import java.util.*

/**
 * @date: 2018/7/3 13:58
 * @author: Chunjiang Mao
 * @classname: ResultApi
 * @describe: 传参api
 */

class ResultApi {
    /**
     * 登录
     *
     * @param userName
     * @param pwd
     * @return
     */
    fun loginApi(userName: String, pwd: String): Observable<BaseResult<LoginInfo>> {
        val hashMap = HashMap<String, String>()
        hashMap["user_name"] = userName
        hashMap["password"] = pwd
        return RetrofitFactory.get().create(ApiService::class.java).login(hashMap)
    }
}
