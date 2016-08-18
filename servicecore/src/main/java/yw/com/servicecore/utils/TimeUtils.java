package yw.com.servicecore.utils;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * 日期时间格式封装类
 */
public class TimeUtils {
    private final static Pattern emailer = Pattern
            .compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
    // private final static SimpleDateFormat dateFormater = new

    // SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // private final static SimpleDateFormat dateFormater2 = new
    // SimpleDateFormat("yyyy-MM-dd");

    private final static ThreadLocal<SimpleDateFormat> dateFormater = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        }
    };

    private final static ThreadLocal<SimpleDateFormat> dateFormater2 = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy/MM/dd");
        }
    };

    private final static ThreadLocal<SimpleDateFormat> dateFormater3 = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    private final static ThreadLocal<SimpleDateFormat> dateFormater4 = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    /**
     * 将字符串转为日期类型
     *
     * @param sdate
     * @return
     */
    public static Date toDate(String sdate) {

        try {
            if (sdate.contains("/")) {
                return dateFormater.get().parse(sdate);
            } else {
                return dateFormater3.get().parse(sdate);
            }

        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 将字符串转为日期类型
     *
     * @param sdate
     * @return
     */
    public static Date toDate2(String sdate) {

        try {
            if (sdate.contains("/")) {
                return dateFormater2.get().parse(sdate);
            } else {
                return dateFormater4.get().parse(sdate);
            }

        } catch (ParseException e) {
            return null;
        }
    }


    /**
     * 显示生日格式
     *
     * @param sdata
     * @return
     */
    public static String getBirthday(String sdata) {
        if (TextUtils.isEmpty(sdata)) {
            return "";
        } else {
            Date time = toDate2(sdata);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(time);
            String birthday_time = calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
            return birthday_time;
        }

    }

    /**
     * 获取天数
     */
    public static int getDay(String sdate) {
      /*  Date time = toDate(sdate);
        String timeDate = dateFormater4.get().format(time);
        String s_rq = timeDate.substring(8, 10);
        return s_rq;*/
        Date time = toDate2(sdate);
        if (time == null) {
            return Integer.parseInt("Unknown");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        int dayIndex = calendar.get(Calendar.DAY_OF_MONTH);
        return dayIndex;
    }


    /**
     * 以友好的方式显示时间
     *
     * @param sdate
     * @return
     */
    public static String friendly_time(String sdate) {
        boolean bool = false;

        if (sdate.contains("-")) {
            bool = true;
        }
        Date time = toDate(sdate);
        if (time == null) {
            return "Unknown";
        }

//        Date serviceTime = toDate(RequestCallBack.time);
        Date serviceTime = new Date(System.currentTimeMillis());
        if (serviceTime == null) {
            return "Unknown";
        }
        String ftime = "";

        // 判断是否是同一天
        String curDate = bool ? dateFormater4.get().format(serviceTime.getTime()) : dateFormater2.get().format(serviceTime.getTime());
        String paramDate = bool ? dateFormater4.get().format(time) : dateFormater2.get().format(time);
        if (curDate.equals(paramDate)) {
            int hour = (int) ((serviceTime.getTime() - time.getTime()) / 3600000);
            if (hour == 0)
                ftime = Math.max(
                        (serviceTime.getTime() - time.getTime()) / 60000, 1)
                        + "分钟前";
            else
                ftime = hour + "小时前";
            return ftime;
        }

        long lt = time.getTime() / 86400000;
        long ct = serviceTime.getTime() / 86400000;
        int days = (int) (ct - lt);
        if (days == 0) {
            int hour = (int) ((serviceTime.getTime() - time.getTime()) / 3600000);
            if (hour == 0)
                ftime = Math.max(
                        (serviceTime.getTime() - time.getTime()) / 60000, 1)
                        + "分钟前";
            else
                ftime = hour + "小时前";
        } else if (days == 1) {
            ftime = "昨天";
        } else if (days == 2) {
            ftime = "前天";
        } else if (days > 2 && days <= 30) {
            ftime = days + "天前";
        } else if (days > 30) {
            int month = days / 30;
            if (month > 12) {
                ftime = bool ? dateFormater4.get().format(time) : dateFormater2.get().format(time);
            } else {
                ftime = month + "个月前";
            }


        }
        return ftime;
    }

    /**
     * 判断给定字符串时间是否为今日
     *
     * @param sdate
     * @return boolean
     */
    public static boolean isToday(String sdate) {
        boolean b = false;
        Date time = toDate2(sdate);
        Date today = new Date();
        if (time != null) {
            if (sdate.contains("/")) {
                String nowDate = dateFormater2.get().format(today);
                String timeDate = dateFormater2.get().format(time);
                if (nowDate.equals(timeDate)) {
                    b = true;
                }
            } else {
                String nowDate = dateFormater4.get().format(today);
                String timeDate = dateFormater4.get().format(time);
                if (nowDate.equals(timeDate)) {
                    b = true;
                }
            }
        }
        return b;
    }

    /**
     * 判断是否为今年，必须固定格式如下 ：2014-01-01
     *
     * @param time 如：2014-01-01
     * @return
     */
    public static boolean isThisYear(String time) {
        if (time.length() != 10) {
            return false;
        } else {
            Date today = new Date();
            String nowDate = dateFormater2.get().format(today);
            if (nowDate.substring(0, 4).equals(time.substring(0, 4))) {
                return true;
            } else {
                return false;
            }
        }

    }

    /**
     * 判断给定字符串是否空白串。 空白串是指由空格、制表符、回车符、换行符组成的字符串 若输入字符串为null或空字符串，返回true
     *
     * @param input
     * @return boolean
     */
    public static boolean isEmpty(String input) {
        if (input == null || "".equals(input))
            return true;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断是不是一个合法的电子邮件地址
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        if (email == null || email.trim().length() == 0)
            return false;
        return emailer.matcher(email).matches();
    }

    /**
     * 字符串转整数
     *
     * @param str
     * @param defValue
     * @return
     */
    public static int toInt(String str, int defValue) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
        }
        return defValue;
    }

    /**
     * 对象转整数
     *
     * @param obj
     * @return 转换异常返回 0
     */
    public static int toInt(Object obj) {
        if (obj == null)
            return 0;
        return toInt(obj.toString(), 0);
    }

    /**
     * 对象转整数
     *
     * @param obj
     * @return 转换异常返回 0
     */
    public static long toLong(String obj) {
        try {
            return Long.parseLong(obj);
        } catch (Exception e) {
        }
        return 0;
    }

    /**
     * 字符串转布尔值
     *
     * @param b
     * @return 转换异常返回 false
     */
    public static boolean toBool(String b) {
        try {
            return Boolean.parseBoolean(b);
        } catch (Exception e) {
        }
        return false;
    }
}
