package com.wya.env.uiview.login

import androidx.lifecycle.MutableLiveData
import com.wya.env.base.model.BaseRepository
import com.wya.env.bean.BaseResult
import com.wya.env.bean.LoginInfo
import com.wya.env.http.BaseObserver
import com.wya.env.http.BaseRequest
import com.wya.env.http.api.ResultApi
import com.wya.env.util.ResultStatusUtil
import io.reactivex.disposables.Disposable

/**
 *     @author : xdl
 *     @time   : 2019/08/07
 *     @describe :
 */
class LoginRepository(private val clazz: Class<*>) : BaseRepository(clazz) {
    private var resultApi = ResultApi()
    var data =MutableLiveData<LoginInfo>()


    /**
     * 登录
     * @param name String
     * @param pwd String
     * @return LoginInfo?
     */
    fun login(name: String, pwd: String){
        showLoading()
        val observer = BaseRequest.request(resultApi.loginApi(name, pwd), object :
                BaseObserver<BaseResult<LoginInfo>>(clazz) {
            override fun onNext(t: BaseResult<LoginInfo>) {
                super.onNext(t)
                if (ResultStatusUtil.handleResult(t)) {
                    data.value=t.data
                }
            }
        })
        addDisposable(observer as Disposable)
    }

}