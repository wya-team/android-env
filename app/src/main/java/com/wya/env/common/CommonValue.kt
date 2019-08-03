package com.wya.env.common

/**
 * @date: 2018/7/3 13:51
 * @author: Chunjiang Mao
 * @classname: CommonValue
 * @describe: 公共字段类
 */

interface CommonValue {
    companion object {
        /**
         * 是否登录成功
         */
        val IS_LOGIN = "is_login"
        /**
         * SharedPreferences文件名
         */
        val SHARE_PREFERENCES_NAME = "share_preferences_name"
    }
}
