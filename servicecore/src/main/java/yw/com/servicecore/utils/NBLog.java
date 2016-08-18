package yw.com.servicecore.utils;

import android.util.Log;

/**
 * Created by wutong on 2014/10/5.
 */
public class NBLog {
    public static boolean VERBOSE = true;
    public static boolean DEBUG = true;
    public static boolean INFO = true;
    public static boolean WARN = true;
    public static boolean ERROR = true;

    public static void v(String tag, String message) {
        if (VERBOSE) {
            Log.v(tag, message);
        }
    }

    public static void d(String tag, String message) {
        if (DEBUG) {
            Log.d(tag, message);
        }
    }

    public static void i(String tag, String message) {
        if (INFO) {
            Log.i(tag, message);
        }
    }

    public static void w(String tag, String message) {
        if (WARN) {
            Log.w(tag, message);
        }
    }


    public static void e(String tag, String message) {
        if (ERROR) {
            Log.e(tag, message);
        }
    }

}
