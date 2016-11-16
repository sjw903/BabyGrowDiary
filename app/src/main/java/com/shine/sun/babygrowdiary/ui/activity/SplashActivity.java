package com.shine.sun.babygrowdiary.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.shine.sun.babygrowdiary.inter.AppConstant;

/**
 * Created by Steven on 2016/11/5 0005.
 */

public class SplashActivity extends AppCompatActivity implements AppConstant {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean bNeedUserGuide = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getBoolean(KEY_GUIDE, true);
        Intent intent = new Intent();
        if (bNeedUserGuide) {
            PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putBoolean(KEY_GUIDE, false).apply();
            intent.setClass(SplashActivity.this, GuideActivity.class);
        } else {
            intent.setClass(SplashActivity.this, LoginActivity.class);
        }
        intent.setClass(SplashActivity.this, GuideActivity.class);
        new Handler().postDelayed(() ->
                        SplashActivity.this.startActivity(intent)
                , 1000L);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return false;
    }
}
