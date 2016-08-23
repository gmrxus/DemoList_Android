package com.evt.demo_utils.utils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.evt.demo_utils.R;



/**
 * Created by mrxus on 16/7/26.
 * <p/>
 * 依赖 glide 3.7.0
 */
public class LoadImageUtil {
    private LoadImageUtil() {
    }

    /**
     * #### Activity里面加载网络图片
     * >淡入淡出1秒
     *
     * @param t      context
     * @param imgUrl
     * @param iv
     * @param <T>
     */
    public static <T extends Context> void loadImgUrl(T t, String imgUrl, ImageView iv) {
        Glide.with(t)
                .load(imgUrl)
                .crossFade(1000)
//                .error(R.mipmap.ic_launcher)//此处应该是错误加载的图片
                .into(iv);
    }

    /**
     * <h3>contexst里面加载网络图片</>
     * > 淡入淡出1秒
     *
     * @param t      fragment
     * @param imgUrl
     * @param iv
     * @param <T>
     */
    public static <T extends Fragment> void loadImgUrl(T t, String imgUrl, ImageView iv) {
        Glide.with(t)
                .load(imgUrl)
                .crossFade(1000)
//                .error(R.mipmap.ic_launcher)//此处应该是错误加载的图片
                .into(iv);

    }


    /**
     * #### Activity里面加载drawable文件
     * >淡入淡出1秒
     *
     * @param t     context
     * @param imgId
     * @param iv    ImageView
     * @param <T>   context
     */
    public static <T extends Context> void loadImgRes(T t, int imgId, ImageView iv) {
        Glide.with(t)
                .load(imgId)
                .crossFade(1000)
//                .error(R.mipmap.ic_launcher)//此处应该是错误加载的图片
                .into(iv);
    }

    /**
     * #### Fragment里面加载Drawable文件
     * >淡入淡出1秒
     *
     * @param t     fragment
     * @param imgId
     * @param iv    ImageView
     * @param <T>   context
     */
    public static <T extends Fragment> void loadImgRes(T t, int imgId, ImageView iv) {
        Glide.with(t)
                .load(imgId)
                .crossFade(1000)
//                .error(R.mipmap.ic_launcher)//此处应该是错误加载的图片
                .into(iv);
    }

    /**
     * #### Activity里面加载gif图片
     *
     * @param t     context
     * @param imgId
     * @param iv    ImageView
     * @param <T>   context
     */
    public static <T extends Context> void loadImgGif(T t, int imgId, ImageView iv) {
        Glide.with(t)
                .load(imgId)
                .asGif()
//                .error(R.mipmap.ic_launcher)//此处应该是错误加载的图片
                .into(iv);
    }

    /**
     * <h3> Fragment里面加载gif图片 </h>
     *
     * @param t     fragment
     * @param imgId
     * @param iv
     * @param <T>
     */
    public static <T extends Fragment> void loadImgGif(T t, int imgId, ImageView iv) {
        Glide.with(t)
                .load(imgId)
                .asGif()
//                .error(R.mipmap.ic_launcher)//此处应该是错误加载的图片
                .into(iv);
    }

}
