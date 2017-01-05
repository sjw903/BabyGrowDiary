package com.shine.sun.babygrowdiary.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.shine.sun.babygrowdiary.util.AppLogUtil;
import com.shine.sun.babygrowdiary.util.AppPackage;

public class MyTestService extends Service {
    public MyTestService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return new MyAidlServiceImpl();
    }

    private static final class MyAidlServiceImpl extends IMyAidlService.Stub {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public String getPackageName() throws RemoteException {
            String packageName = AppPackage.getInstance().getPackageName();
            AppLogUtil.log("MyTestService getPackageName packageName = " + packageName);
            return packageName;
        }
    }
}
