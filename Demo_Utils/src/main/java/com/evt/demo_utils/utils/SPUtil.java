package com.evt.demo_utils.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.evt.demo_utils.common.MyApplication;

import java.util.Map;


/**
 * Created by mrxus on 16/7/23.
 */
public class SPUtil {
    private static final String SP_FILE_NAME = "mSharedPreferences";


    /**
     * 存放
     *
     * @param key
     * @param value
     */
    public static void put(Context context,String key, Object value) {
        SharedPreferences sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        if (value instanceof String) {
            edit.putString(key, (String) value);
        } else if (value instanceof Intent) {
            edit.putInt(key, (Integer) value);
        } else if (value instanceof Boolean) {
            edit.putBoolean(key, (Boolean) value);
        } else if (value instanceof Float) {
            edit.putFloat(key, (Float) value);
        } else if (value instanceof Long) {
            edit.putLong(key, (Long) value);
        } else {
            edit.putString(key, value.toString());
        }
        edit.apply();
    }

    /**
     * 获取
     *
     * @param key
     * @param defValue
     * @return
     */
    public static Object get(Context context,String key, Object defValue) {
        SharedPreferences sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        if (defValue instanceof String) {
            return sp.getString(key, (String) defValue);
        } else if (defValue instanceof Integer) {
            return sp.getInt(key, (Integer) defValue);
        } else if (defValue instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) defValue);
        } else if (defValue instanceof Float) {
            return sp.getFloat(key, (Float) defValue);
        } else if (defValue instanceof Long) {
            return sp.getLong(key, (Long) defValue);
        } else {
            return null;
        }

    }

    /**
     * 删除该key指定的value
     *
     * @param key
     */
    public static void remove(Context context,String key) {
        SharedPreferences sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.remove(key);
        edit.apply();
    }

    /**
     * 清除所有
     */
    public static void clear(Context context) {
        SharedPreferences sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.clear();
        edit.apply();

    }

    /**
     * 判断这个key是否有值
     *
     * @param key
     * @return
     */
    public static boolean isExist(Context context,String key) {
        SharedPreferences sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        return sp.contains(key);
    }

    /**
     * 获取所有键值对
     *
     * @return map
     */
    public static Map<String, ?> getAll(Context context) {
        SharedPreferences sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        return sp.getAll();
    }
}
