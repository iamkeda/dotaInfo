package com.go.kd.dotainfo.ui;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.go.kd.dotainfo.R;
import com.go.kd.dotainfo.adapter.SectionsPagerAdapter;
import com.go.kd.dotainfo.fragment.TestFragment;
import com.go.kd.dotainfo.utils.BottomNavigationViewHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNavView;
    private ViewPager mViewPager;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        }
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        initBottomNavView();
        initViewPager();
    }

    private void initBottomNavView() {
        mBottomNavView = (BottomNavigationView) findViewById(R.id.bottom_nav);
        BottomNavigationViewHelper.disableShiftMode(mBottomNavView);
        mBottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.bottom_nav_zhuye:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.bottom_nav_faxian:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.bottom_nav_zhibo:
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.bottom_nav_more:
                        mViewPager.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });
    }

    private void initViewPager() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        fragments = new ArrayList<>();
        fragments.add(new TestFragment());
        fragments.add(new TestFragment());
        fragments.add(new TestFragment());
        fragments.add(new TestFragment());

        mViewPager.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager(), fragments));
        mViewPager.setCurrentItem(0);
        //禁止viewpager滑动
        mViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }
}
