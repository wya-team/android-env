package com.wya.env.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.wya.env.common.CommonValue;

/**
 * @date: 2018/5/31 14:01
 * @author: Chunjiang Mao
 * @classname: SaveSharedPreferences
 * @describe:
 */

public class SaveSharedPreferences {
    /**
     * 保存信息
     *
     * @param context 上下文
     * @param key 键
     * @param value 值
     */
    public static void save(Context context, String key, Object value) {
        SharedPreferences sp = context.getSharedPreferences(CommonValue.SHARE_PREFERENCES_NAME, 0);
        //判断要保存的数据
        if (value instanceof String) {
            sp.edit().putString(key, (String) value).apply();
        } else if (value instanceof Integer) {
            sp.edit().putInt(key, (int) value).apply();
        } else if (value instanceof Boolean) {
            sp.edit().putBoolean(key, (boolean) value).apply();
        } else if (value instanceof Float) {
            sp.edit().putFloat(key, (Float) value).apply();
        }
    }
    
    /**
     * 从sharedpreferences获取数据
     *
     * @param context 上下文
     * @param key 键
     *
     * @return 返回值
     */
    public static String getString(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(CommonValue.SHARE_PREFERENCES_NAME, 0);
        return sp.getString(key, "");
    }
    
    public static String getString(Context context, String key, String defValue) {
        SharedPreferences sp = context.getSharedPreferences(CommonValue.SHARE_PREFERENCES_NAME, 0);
        return sp.getString(key, defValue);
    }
    
    public static Integer getInt(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(CommonValue.SHARE_PREFERENCES_NAME, 0);
        return sp.getInt(key, 0);
    }
    
    public static Integer getInt(Context context, String key, int defValue) {
        SharedPreferences sp = context.getSharedPreferences(CommonValue.SHARE_PREFERENCES_NAME, 0);
        return sp.getInt(key, defValue);
    }
    
    public static Float getFloat(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(CommonValue.SHARE_PREFERENCES_NAME, 0);
        return sp.getFloat(key, 0);
    }
    
    public static Float getFloat(Context context, String key, int defValue) {
        SharedPreferences sp = context.getSharedPreferences(CommonValue.SHARE_PREFERENCES_NAME, 0);
        return sp.getFloat(key, defValue);
    }
    
    public static Boolean getBoolean(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(CommonValue.SHARE_PREFERENCES_NAME, 0);
        return sp.getBoolean(key, false);
    }
    
    public static Boolean getBoolean(Context context, String key, boolean defValue) {
        SharedPreferences sp = context.getSharedPreferences(CommonValue.SHARE_PREFERENCES_NAME, 0);
        return sp.getBoolean(key, defValue);
    }
    
    public static void deleteData(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(CommonValue.SHARE_PREFERENCES_NAME, 0);
        sp.edit().remove(key).commit();
    }
}
