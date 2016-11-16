package com.shine.sun.babygrowdiary.ui.activity;

import android.content.Intent;

import com.shine.sun.babygrowdiary.R;
import com.shine.sun.babygrowdiary.base.BaseActivity;

public class LoginActivity extends BaseActivity {

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    private void launchHomeActivity() {
        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
    }
}
