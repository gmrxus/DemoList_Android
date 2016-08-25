package com.evt.demo_utils.utils;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by mrxus on 16/8/25.
 */
public class DateUtil {
    public static final int YEAR = 1;
    public static final int MONTH = 2;
    public static final int DATE = 3;
    public static final int HOUR = 4;
    public static final int MINUTE = 5;
    public static final int SECOND = 6;
    public static final int DAY_OF_MONTH = 7;


    /**
     * 获取当前时间的毫秒数
     *
     * @return
     */
    public static long getThisTimeLong() {
        return System.currentTimeMillis();
    }

    /**
     * 获取当前时间  String
     * <p/>
     * 格式:yyyy年MM月dd日 HH:mm:ss
     *
     * @return
     */
    public static String getThisTimeStr() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date date = new Date(getThisTimeLong());
        return format.format(date);
    }

    /**
     * 获取当前时间的单个日期
     *
     * @param t
     * @return
     */
    public static int get(int t) {
        Calendar c = Calendar.getInstance();
        int cg;
        switch (t) {
            case YEAR:
                cg = c.get(Calendar.YEAR);
                break;
            case MONTH:
                cg = c.get(Calendar.MONTH);
                break;
            case DATE:
                cg = c.get(Calendar.DATE);
                break;
            case HOUR:
                cg = c.get(Calendar.HOUR);
                break;
            case MINUTE:
                cg = c.get(Calendar.MINUTE);
                break;
            case SECOND:
                cg = c.get(Calendar.SECOND);
                break;
            case DAY_OF_MONTH:
                cg = c.get(Calendar.DAY_OF_MONTH);
                break;
            default:
                throw new RuntimeException("你写的啥啊,查不到!");
        }
        return cg;
    }
}
