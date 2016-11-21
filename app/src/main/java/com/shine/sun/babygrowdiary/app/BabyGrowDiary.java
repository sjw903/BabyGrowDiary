package com.shine.sun.babygrowdiary.app;

import android.app.Application;

import com.shine.sun.babygrowdiary.BuildConfig;
import com.shine.sun.babygrowdiary.util.AppException;
import com.shine.sun.babygrowdiary.util.AppLogUtil;
import com.shine.sun.babygrowdiary.util.AppPackage;

import timber.log.Timber;

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
        if (BuildConfig.APP_DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        AppPackage.getInstance().init(getApplicationContext());
        AppPackage appPackage = AppPackage.getInstance();
        String packageName = appPackage.getPackageName();
        String versionCode = appPackage.getVersionCode();
        String versionName = appPackage.getVersionName();
        String packName = appPackage.getPackName();
        AppLogUtil.log(" packageName = " + packageName + " versionCode = " + versionCode + " versionName = " + versionName + " packName = " + packName);
    }
}
