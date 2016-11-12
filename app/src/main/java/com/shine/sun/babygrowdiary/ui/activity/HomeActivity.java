package com.shine.sun.babygrowdiary.ui.activity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.shine.sun.babygrowdiary.R;
import com.shine.sun.babygrowdiary.adapter.HomePagerAdapter;
import com.shine.sun.babygrowdiary.base.BaseActivity;
import com.shine.sun.babygrowdiary.base.BaseFragment;
import com.shine.sun.babygrowdiary.ui.fragment.FragmentContent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import hugo.weaving.DebugLog;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

public class HomeActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    @BindView(R.id.pager_tab)
    PagerTabStrip mPagerTabStrip;
    Subscriber<String> mSubscriber;

    private long mExitTime;
    private static final long INTERVAL_TIME = 2000L;
    //modify system language, fragment content can't change content
    private static String[] TITLES;
    private static final int[] IMG_RES = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    @Override
    protected void initView() {
        setSupportActionBar(mToolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        List<BaseFragment> fragmentList = new ArrayList<>();
        for (String title : TITLES) {
            Bundle bundle = new Bundle();
            bundle.putString("title", title);
            fragmentList.add(FragmentContent.getInstance(bundle));
        }
        HomePagerAdapter adapter = new HomePagerAdapter(getSupportFragmentManager(), TITLES, fragmentList);
        mPagerTabStrip.setTextColor(Color.RED);
        mPagerTabStrip.setBackgroundColor(Color.GREEN);
        mPagerTabStrip.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        mPagerTabStrip.setFitsSystemWindows(true);
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setCurrentItem(1);
        setTabsValue();
    }

    private void setTabsValue() {

    }

    @Override
    protected void initData() {
        Resources res = getResources();
        TITLES = new String[]{String.format(res.getString(R.string.tab_title_home)), String.format(res.getString(R.string.tab_title_history)), String.format(res.getString(R.string.tab_title_grow_up))};
        rxInit();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void rxInit() {
//        mObservable = Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext(getSelfContent());
//            }
//        });

        mSubscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

            }
        };
//        mObservable.subscribe(mSubscriber);
        Observable.just(getSelfContent()).observeOn(AndroidSchedulers.mainThread()).subscribe(mSubscriber);
    }

    @DebugLog
    private String getSelfContent() {
        return "Hello My son!";
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            long currentTime = System.currentTimeMillis();
            if (currentTime - mExitTime < INTERVAL_TIME) {
                super.onBackPressed();
            } else {
                mExitTime = currentTime;
                Toast.makeText(this, getResources().getString(R.string.home_quit_tip), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
