package com.wya.env.net.api;

import com.wya.env.bean.BaseResult;
import com.wya.env.bean.login.LoginInfo;
import com.wya.env.net.RetrofitFactory;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * @date: 2018/7/3 13:58
 * @author: Chunjiang Mao
 * @classname: ResultApi
 * @describe: 传参api
 */

public class ResultApi {
    /**
     * 登录
     *
     * @param userName
     * @param pwd
     * @return
     */
    public Observable<BaseResult<LoginInfo>> loginApi(String userName, String pwd) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("user_name", userName);
        hashMap.put("password", pwd);
        return RetrofitFactory.getInstance().create().login(hashMap);
    }
}
