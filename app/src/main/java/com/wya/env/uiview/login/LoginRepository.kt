package com.wya.env.uiview.login

import androidx.lifecycle.MutableLiveData
import com.wya.env.base.model.BaseRepository
import com.wya.env.bean.BaseResult
import com.wya.env.bean.login.LoginInfo
import com.wya.env.http.BaseObserver
import com.wya.env.http.BaseRequest
import com.wya.env.http.api.ResultApi
import com.wya.env.util.ResultStatusUtil

/**
 *     @author : xdl
 *     @time   : 2019/08/07
 *     @describe :
 */
object LoginRepository : BaseRepository() {
    private var resultApi = ResultApi()


    /**
     * 登录
     * @param name String
     * @param pwd String
     * @return LoginInfo?
     */
    fun login(name: String, pwd: String): MutableLiveData<LoginInfo> {
        showLoading()
        val tempLoginInfo = MutableLiveData<LoginInfo>()
        BaseRequest.request(resultApi.loginApi(name, pwd), object : BaseObserver<BaseResult<LoginInfo>>() {
            override fun onNext(t: BaseResult<LoginInfo>) {
                super.onNext(t)
                if (ResultStatusUtil.handleResult(t)) {
                    tempLoginInfo.value = t.data
                }
            }
        })
        return tempLoginInfo
    }
}