package com.wya.env.net.api;

import java.util.HashMap;

import io.reactivex.Observable;
import com.wya.env.bean.BaseResult;
import com.wya.env.bean.login.LoginInfo;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2018/7/3 0003.
 * 请求数据的接口
 */

public interface Api {
    //登录
    @FormUrlEncoded
    @POST("app/login")
    Observable<BaseResult<LoginInfo>> login(@FieldMap HashMap<String ,String> hashMap);
}
