package com.wya.env.util

import android.content.Context
import android.content.SharedPreferences
import com.wya.env.common.Constant
import com.wya.env.uiview.App
import java.util.*

/**
 * @author : xdl
 * @time   : 2019-08-01
 * @describe  :
 */
class SharedPreferencesUtil private constructor() {
    private val mSharedPreferences: SharedPreferences

    init {
        mSharedPreferences = App.getInstance().getSharedPreferences(Constant.SP_NAME,
                Context.MODE_PRIVATE)
    }

    /**
     * 保存信息
     *
     * @param key   键
     * @param value 值
     */
    fun save(key: String, value: Any) {
        //判断要保存的数据
        if (value is String) {
            mSharedPreferences.edit().putString(key, value).apply()
        } else if (value is Int) {
            mSharedPreferences.edit().putInt(key, value).apply()
        } else if (value is Boolean) {
            mSharedPreferences.edit().putBoolean(key, value).apply()
        } else if (value is Float) {
            mSharedPreferences.edit().putFloat(key, value).apply()
        }
    }

    /**
     * 存放当前账户临时数据
     *
     * @param key
     * @param value
     */
    fun saveTemp(key: String, value: Any) {
        var keySet: MutableSet<String>? = mSharedPreferences.getStringSet(Constant.TEMP_KEY, null)
        if (keySet == null) {
            keySet = HashSet()
        }
        keySet.add(key)
        mSharedPreferences.edit().putStringSet(Constant.TEMP_KEY, keySet).apply()

        //判断要保存的数据
        if (value is String) {
            mSharedPreferences.edit().putString(key, value).apply()
        } else if (value is Int) {
            mSharedPreferences.edit().putInt(key, value).apply()
        } else if (value is Boolean) {
            mSharedPreferences.edit().putBoolean(key, value).apply()
        } else if (value is Float) {
            mSharedPreferences.edit().putFloat(key, value).apply()
        }
    }

    /**
     * 清除临时数据
     */
    fun clearTempData() {
        val keySet = mSharedPreferences.getStringSet(Constant.TEMP_KEY, null)
        if (keySet != null) {
            for (key in keySet) {
                mSharedPreferences.edit().remove(key).apply()
            }
        }
    }

    /**
     * 从sharedpreferences获取数据
     *
     * @param key 键
     * @return 返回值
     */
    fun getString(key: String): String {
        return getString(key, "")
    }

    fun getString(key: String, defValue: String): String {
        return mSharedPreferences.getString(key, defValue)!!
    }

    fun getInt(key: String): Int {
        return getInt(key, 0)
    }

    fun getInt(key: String, defValue: Int): Int {
        return mSharedPreferences.getInt(key, defValue)
    }

    fun getFloat(key: String): Float {
        return getFloat(key, 0f)
    }

    fun getFloat(key: String, defValue: Float): Float{
        return mSharedPreferences.getFloat(key, defValue)
    }

    fun getBoolean(key: String): Boolean {
        return getBoolean(key, false)
    }

    fun getBoolean(key: String, defValue: Boolean): Boolean {
        return mSharedPreferences.getBoolean(key, defValue)
    }

    fun deleteData(key: String) {
        mSharedPreferences.edit().remove(key).apply()
    }

    fun removeAll() {
        mSharedPreferences.edit().clear().apply()
    }

    companion object {
        private var instance: SharedPreferencesUtil? = null

        fun getInstance(): SharedPreferencesUtil {
            if (instance == null) {
                instance = SharedPreferencesUtil()
            }
            return instance!!
        }
    }
}
