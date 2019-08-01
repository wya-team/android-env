package com.wya.env.utils;

import com.wya.env.base.view.BaseView;
import com.wya.env.bean.BaseResult;

/**
 * @date: 2018/5/31 14:00
 * @author: Chunjiang Mao
 * @classname: ResultStatusUtil
 * @describe: 返回结果处理的封装
 */

public class ResultStatusUtil {
    public static boolean resultStatus(BaseView mView, BaseResult result) {
        switch (result.status) {
            case 1:
                return true;
            case -1:
                mView.tokenFailure();
                return false;
            default:
                mView.errorResult(result.msg);
                return false;
        }
    }
}
