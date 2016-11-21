package com.shine.sun.babygrowdiary.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by Steven on 2016/11/19 0019.
 */

public class AppPackage {
    private Context mContext;
    private PackageInfo mPackageInfo;
    private static final String EMPTY = "";

    private AppPackage() {

    }

    private static final class Holder {
        private static final AppPackage mInstance = new AppPackage();
    }

    public static AppPackage getInstance() {
        return Holder.mInstance;
    }

    public void init(Context context) {
        mContext = context;
    }

    public String getPackageName() {
        checkContextException();
        return mContext.getPackageName();
    }

    public String getVersionName() {
        checkContextException();
        return mPackageInfo.versionName;
    }

    private void checkContextException() {
        if (null == mContext) {
            throw new ExceptionInInitializerError("context must be set first!");
        }
    }

    private void checkPackageInfo() {
        if (mPackageInfo == null) {
            try {
                mPackageInfo = mContext.getPackageManager().getPackageInfo(getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public String getVersionCode() {
        checkContextException();
        checkPackageInfo();
        if (null != mPackageInfo) {
            return String.valueOf(mPackageInfo.versionCode);
        }
        return EMPTY;
    }

    public String getPackName() {
        checkContextException();
        checkPackageInfo();
        if (null != mPackageInfo) {
            return mPackageInfo.packageName;
        }
        return EMPTY;
    }
}
