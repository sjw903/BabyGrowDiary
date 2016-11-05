package com.shine.sun.babygrowdiary.app;

import android.app.Application;

import com.shine.sun.babygrowdiary.util.AppException;

/**
 * Created by Steven on 2016/11/5 0005.
 * load some global configs
 */

public class BabyGrowDiary extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        /**
         * AppException init to catch exception
         */
        AppException.getInstance().init(getApplicationContext());
    }
}
