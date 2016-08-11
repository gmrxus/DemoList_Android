package com.evt.demo_utils.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

import com.evt.demo_utils.common.MyApplication;


/**
 * Created by mrxus on 16/7/23.
 */
public class DisplayUtil {

    /**
     * 获取屏幕宽度
     *
     * @return
     */
    public static int getScreenWidth() {
        WindowManager wm = (WindowManager) MyApplication.getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    /**
     * 获取屏幕高度
     *
     * @return
     */
    public static int getScreenHeight() {
        WindowManager wm = (WindowManager) MyApplication.getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }

    /**
     * 获取底部导航栏的高度
     *
     * @return
     */
    public static int getNavigationBarHeight() {
        Resources resources = MyApplication.getContext().getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        int height = resources.getDimensionPixelSize(resourceId);
        return height;
    }

    /**
     * 获取顶部状态栏的高度
     *
     * @return
     */
    public static int getStatusBarHeight() {
        Resources resources = MyApplication.getContext().getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        int height = resources.getDimensionPixelSize(resourceId);
        return height;
    }


    /**
     * 获取一个view的宽度
     *
     * @param view
     * @return
     */
    public static int getViewWidth(View view) {

        return view.getMeasuredWidth();
    }

    /**
     * 获取一个view的高
     *
     * @param view
     * @return
     */
    public static int getViewHeight(View view) {

        return view.getMeasuredHeight();
    }

}
