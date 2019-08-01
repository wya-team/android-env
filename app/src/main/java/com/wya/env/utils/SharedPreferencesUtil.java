package com.wya.env.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.wya.env.App;
import com.wya.env.common.Constant;

import java.util.HashSet;
import java.util.Set;

/**
 *  @author : xdl
 *  @time   : 2019-08-01
 *  @describe  :
 */
public class SharedPreferencesUtil {
    private SharedPreferences mSharedPreferences;
    private static SharedPreferencesUtil instance;

    private SharedPreferencesUtil() {
        mSharedPreferences = App.getInstance().getSharedPreferences(Constant.SHAREDPREFERENCES,
                Context.MODE_PRIVATE);
    }

    public static SharedPreferencesUtil getInstance() {
        if (instance == null) {
            instance = new SharedPreferencesUtil();
        }
        return instance;
    }

    /**
     * 保存信息
     *
     * @param key   键
     * @param value 值
     */
    public void save(String key, Object value) {
        //判断要保存的数据
        if (value instanceof String) {
            mSharedPreferences.edit().putString(key, (String) value).apply();
        } else if (value instanceof Integer) {
            mSharedPreferences.edit().putInt(key, (int) value).apply();
        } else if (value instanceof Boolean) {
            mSharedPreferences.edit().putBoolean(key, (boolean) value).apply();
        } else if (value instanceof Float) {
            mSharedPreferences.edit().putFloat(key, (Float) value).apply();
        }
    }

    /**
     * 存放当前账户临时数据
     *
     * @param key
     * @param value
     */
    public void saveTemp(String key, Object value) {
        Set<String> keySet = mSharedPreferences.getStringSet(Constant.TEMP_KEY, null);
        if (keySet == null) {
            keySet = new HashSet<>();
        }
        keySet.add(key);
        mSharedPreferences.edit().putStringSet(Constant.TEMP_KEY, keySet).apply();

        //判断要保存的数据
        if (value instanceof String) {
            mSharedPreferences.edit().putString(key, (String) value).apply();
        } else if (value instanceof Integer) {
            mSharedPreferences.edit().putInt(key, (int) value).apply();
        } else if (value instanceof Boolean) {
            mSharedPreferences.edit().putBoolean(key, (boolean) value).apply();
        } else if (value instanceof Float) {
            mSharedPreferences.edit().putFloat(key, (Float) value).apply();
        }
    }

    /**
     * 清除临时数据
     */
    public void clearTempData() {
        Set<String> keySet = mSharedPreferences.getStringSet(Constant.TEMP_KEY, null);
        if (keySet != null) {
            for (String key : keySet) {
                mSharedPreferences.edit().remove(key).apply();
            }
        }
    }

    /**
     * 从sharedpreferences获取数据
     *
     * @param key 键
     * @return 返回值
     */
    public String getString(String key) {
        return mSharedPreferences.getString(key, "");
    }

    public String getString(String key, String defValue) {
        return mSharedPreferences.getString(key, defValue);
    }

    public Integer getInt(String key) {
        return mSharedPreferences.getInt(key, 0);
    }

    public Integer getInt(String key, int defValue) {
        return mSharedPreferences.getInt(key, defValue);
    }

    public Float getFloat(String key) {
        return mSharedPreferences.getFloat(key, 0);
    }

    public Float getFloat(String key, int defValue) {
        return mSharedPreferences.getFloat(key, defValue);
    }

    public Boolean getBoolean(String key) {
        return mSharedPreferences.getBoolean(key, false);
    }

    public Boolean getBoolean(String key, boolean defValue) {
        return mSharedPreferences.getBoolean(key, defValue);
    }

    public void deleteData(String key) {
        mSharedPreferences.edit().remove(key).apply();
    }

    public void removeAll() {
        mSharedPreferences.edit().clear().apply();
    }
}
