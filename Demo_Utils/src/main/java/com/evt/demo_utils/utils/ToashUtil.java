package com.evt.demo_utils.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by mrxus on 16/8/11.
 * <p/>
 * toash工具类
 */
public class ToashUtil {
    public static boolean isToash = true;//是否吐司,可以在自定义application里面定义

    public static void showToash(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void showToash(Context context, int msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();

    }
}
