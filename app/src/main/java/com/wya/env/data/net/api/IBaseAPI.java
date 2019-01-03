package com.wya.env.data.net.api;

import com.wya.env.bean.BaseResult;
import com.wya.env.bean.login.LoginInfo;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IBaseAPI {
    
    //登录
    @FormUrlEncoded
    @POST("app/login")
    Observable<BaseResult<LoginInfo>> login(@FieldMap HashMap<String, String> hashMap);
}
