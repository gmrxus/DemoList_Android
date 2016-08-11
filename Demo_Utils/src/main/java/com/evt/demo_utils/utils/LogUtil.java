package com.evt.demo_utils.utils;

import com.orhanobut.logger.Logger;

/**
 * Created by mrxus on 16/8/11.
 * <p/>
 * 依赖 orhanobut.logger  1.15
 */
public class LogUtil {
    private static boolean isLog = true;//是否需要打印log,可以换成public 在自定义application的onCreate里面设置
    private static String TAG = "";//自定义tag

    static {
        Logger
                .init(TAG)//初始化tag
                .methodCount(3);//显示方法层级,默认是2
    }

    /**
     * 公共tag
     *
     * @param msg
     */
    public static void d(String msg) {
        if (isLog) {
            Logger.d(msg);
        }
    }

    /**
     * 公共tag
     *
     * @param msg
     */
    public static void e(String msg) {
        if (isLog) {

            Logger.e(msg);
        }
    }

    /**
     * 自定义tag
     *
     * @param msg
     * @param tag
     */
    public static void d_t(String msg, String tag) {
        if (isLog) {

            Logger.t(tag).d(msg);
        }
    }

    /**
     * 自定义tag
     *
     * @param msg
     * @param tag
     */
    public static void e_t(String msg, String tag) {
        if (isLog) {

            Logger.t(tag).e(msg);
        }
    }

}
