package com.shine.sun.babygrowdiary.ui.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.shine.sun.babygrowdiary.R;
import com.shine.sun.babygrowdiary.adapter.GuidePagerAdapter;
import com.shine.sun.babygrowdiary.base.BaseActivity;
import com.shine.sun.babygrowdiary.util.AppLogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static android.support.v4.view.ViewPager.SCROLL_STATE_IDLE;

/**
 * Created by Steven on 2016/11/15 0015.
 */

public class GuideActivity extends BaseActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private ImageView[] mDotViews;
    private int mCurrentIndex;
    @BindView(R.id.view_pager_guide)
    ViewPager mViewPager;
    private List<View> mViewList;
    @Override
    protected void initView() {
        initDot();
    }

    @OnClick(R.id.tv_skip)
    public void skipClick() {
        launchLoginActivity();
    }

    @Override
    protected void initData() {
        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        mViewList = new ArrayList<>();
        mViewList.add(inflater.inflate(R.layout.actvity_guide1, null));
        mViewList.add(inflater.inflate(R.layout.actvity_guide2, null));
        mViewList.add(inflater.inflate(R.layout.actvity_guide3, null));
        GuidePagerAdapter guidePagerAdapter = new GuidePagerAdapter(mViewList);
        mViewPager.setAdapter(guidePagerAdapter);
        mViewPager.addOnPageChangeListener(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_guide;
    }

    private void initDot() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.ll_indicator);
        int size = layout.getChildCount();
        mDotViews = new ImageView[size];
        for (int i = 0; i < size; i++) {
            mDotViews[i] = (ImageView) layout.getChildAt(i);
            mDotViews[i].setSelected(false);
            mDotViews[i].setOnClickListener(this);
            mDotViews[i].setTag(i);
        }
        mCurrentIndex = 0;
        mDotViews[mCurrentIndex].setSelected(true);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_skip) {
            return;
        }
        if (view instanceof ImageView) {
            int position = (int) view.getTag();
            setCurrentDot(position);
            setCurrentView(position);
        }
    }

    private void launchLoginActivity() {
        startActivity(new Intent(GuideActivity.this, LoginActivity.class));
    }

    private void setCurrentDot(int position) {
        if (position >= mViewList.size() || position < 0) {
            return;
        }
        if (mCurrentIndex == position) {
            return;
        }
        mDotViews[mCurrentIndex].setSelected(false);
        mCurrentIndex = position;
        mDotViews[mCurrentIndex].setSelected(true);
    }

    private void setCurrentView(int position) {
        if (position >= mViewList.size() || position < 0) {
            return;
        }
        mViewPager.setCurrentItem(position);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        AppLogUtil.log("onPageScrolled position " + position + " positionOffset " + positionOffset);
    }

    @Override
    public void onPageSelected(int position) {
        setCurrentDot(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        AppLogUtil.log("onPageScrollStateChanged state " + state);
        if (state == SCROLL_STATE_IDLE && mCurrentIndex == mViewList.size() - 1) {
//            launchLoginActivity();
        }
    }
}
