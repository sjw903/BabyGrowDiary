package com.shine.sun.babygrowdiary.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.shine.sun.babygrowdiary.base.BaseFragment;

import java.util.List;

/**
 * Created by Steven on 2016/11/9 0009.
 */

public class HomePagerAdapter extends FragmentPagerAdapter {
    private final String[] mTitles;
    //    private final int[] mRes;
    private final List<BaseFragment> mFragmentList;

    public HomePagerAdapter(FragmentManager fm, String[] titles, /*int[] res,*/ List<BaseFragment> fragmentList) {
        super(fm);
        mTitles = titles;
        mFragmentList = fragmentList;
//        if (null == mRes || null == mTitles) {
//            throw new RuntimeException("not null!");
//        }
        if (null == mTitles || mTitles.length == 0) {
            throw new IllegalArgumentException("");
        }
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
