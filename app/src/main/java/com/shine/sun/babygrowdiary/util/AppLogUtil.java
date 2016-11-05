package com.shine.sun.babygrowdiary.util;

import android.support.compat.BuildConfig;
import android.util.Log;

/**
 * Created by Administrator on 2016/5/7 0007.
 */
public class AppLogUtil {
    private static final String TAG = "steven";
    private static boolean Debug = true;

    public static void log(String content) {
        if (Debug && BuildConfig.DEBUG) {
            Log.d(TAG, content);
        }
    }

    public static void setDebug(boolean flag) {
        Debug = flag;
    }
}
