package com.wya.env.net.api;

import java.util.HashMap;

import io.reactivex.Observable;
import com.wya.env.bean.BaseResult;
import com.wya.env.bean.login.LoginInfo;
import com.wya.env.net.RetrofitFactory;

/**
 * Created by Administrator on 2018/7/3 0003.
 * 传参api
 */

public class ResultApi {
    //登录
    public Observable<BaseResult<LoginInfo>> loginApi(String userName, String pwd){
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("user_name",userName);
        hashMap.put("password",pwd);
        return RetrofitFactory.getInstance().create(Api.class).login(hashMap);
    }
}
