package com.wya.env.util

import android.content.Context
import android.content.SharedPreferences

import com.wya.env.common.CommonValue

/**
 * @date: 2018/5/31 14:01
 * @author: Chunjiang Mao
 * @classname: SaveSharedPreferences
 * @describe:
 */

object SaveSharedPreferences {
    /**
     * 保存信息
     *
     * @param context 上下文
     * @param key     键
     * @param value   值
     */
    fun save(context: Context, key: String, value: Any) {
        val sp = context.getSharedPreferences(CommonValue.SHARE_PREFERENCES_NAME, 0)
        //判断要保存的数据
        if (value is String) {
            sp.edit().putString(key, value).apply()
        } else if (value is Int) {
            sp.edit().putInt(key, value).apply()
        } else if (value is Boolean) {
            sp.edit().putBoolean(key, value).apply()
        } else if (value is Float) {
            sp.edit().putFloat(key, value).apply()
        }
    }

    /**
     * 从sharedpreferences获取数据
     *
     * @param context 上下文
     * @param key     键
     * @return 返回值
     */
    fun getString(context: Context, key: String): String? {
        val sp = context.getSharedPreferences(CommonValue.SHARE_PREFERENCES_NAME, 0)
        return sp.getString(key, "")
    }

    fun getString(context: Context, key: String, defValue: String): String? {
        val sp = context.getSharedPreferences(CommonValue.SHARE_PREFERENCES_NAME, 0)
        return sp.getString(key, defValue)
    }

    fun getInt(context: Context, key: String): Int {
        val sp = context.getSharedPreferences(CommonValue.SHARE_PREFERENCES_NAME, 0)
        return sp.getInt(key, 0)
    }

    fun getInt(context: Context, key: String, defValue: Int): Int {
        val sp = context.getSharedPreferences(CommonValue.SHARE_PREFERENCES_NAME, 0)
        return sp.getInt(key, defValue)
    }

    fun getFloat(context: Context, key: String): Float {
        val sp = context.getSharedPreferences(CommonValue.SHARE_PREFERENCES_NAME, 0)
        return sp.getFloat(key, 0f)
    }

    fun getFloat(context: Context, key: String, defValue: Int): Float {
        val sp = context.getSharedPreferences(CommonValue.SHARE_PREFERENCES_NAME, 0)
        return sp.getFloat(key, defValue.toFloat())
    }

    fun getBoolean(context: Context, key: String): Boolean {
        val sp = context.getSharedPreferences(CommonValue.SHARE_PREFERENCES_NAME, 0)
        return sp.getBoolean(key, false)
    }

    fun getBoolean(context: Context, key: String, defValue: Boolean): Boolean {
        val sp = context.getSharedPreferences(CommonValue.SHARE_PREFERENCES_NAME, 0)
        return sp.getBoolean(key, defValue)
    }

    fun deleteData(context: Context, key: String) {
        val sp = context.getSharedPreferences(CommonValue.SHARE_PREFERENCES_NAME, 0)
        sp.edit().remove(key).commit()
    }
}
