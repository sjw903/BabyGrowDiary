package com.shine.sun.babygrowdiary.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.shine.sun.babygrowdiary.util.AppLogUtil;

import butterknife.ButterKnife;

/**
 * Created by Steven on 2016/11/5 0005.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected abstract void initView();

    protected abstract void initData();

    protected abstract int getLayout();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        AppLogUtil.log(this.getClass().getSimpleName() + " onCreate ");
        initData();
        initView();
    }
}
