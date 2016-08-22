package com.evt.demo_utils.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;

import com.evt.demo_utils.common.MyApplication;


/**
 * 判断网络连接类
 * 需要加权限:<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
 *
 * Created by mrxus on 16/7/23.
 */
public class NetworkUtil {
    /**
     * 判断当前是否有网络
     *
     * @return
     */
    public static boolean isHaveNetwork(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        return (info != null && info.isConnected());
    }

    /**
     * 判断是否是wifi连接
     *
     * @return
     */
    public static boolean isWifiConnected(Context context) {
        if (!isHaveNetwork(context)) {
            return false;
        }
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (networkInfo != null) {
            return networkInfo.isAvailable();
        }
        return false;
    }

    /**
     * 判断是否用的流量连接
     * @return
     */
    public static boolean isMobileConnected(Context context) {
        if (!isHaveNetwork(context)) {
            return false;
        }
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (networkInfo != null) {
            return networkInfo.isAvailable();
        }
        return false;
    }


}
