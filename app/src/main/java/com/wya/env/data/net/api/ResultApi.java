package com.wya.env.data.net.api;

import com.wya.env.bean.BaseResult;
import com.wya.env.bean.login.LoginInfo;
import com.wya.env.data.net.RetrofitFactory;

import java.util.HashMap;

import io.reactivex.Observable;

public class ResultApi {
    //登录
    public Observable<BaseResult<LoginInfo>> loginApi(String userName, String pwd) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("user_name", userName);
        hashMap.put("password", pwd);
        return RetrofitFactory.getInstance().create(IBaseAPI.class).login(hashMap);
    }
}
