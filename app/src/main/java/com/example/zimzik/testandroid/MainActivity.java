package com.example.zimzik.testandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static int pagesCounter = 0;
    private ViewPager mPager;
    private MyPagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPager = findViewById(R.id.view_pager);



        FragmentManager fragmentManager = getSupportFragmentManager();

        mPagerAdapter = new MyPagerAdapter(fragmentManager);
        Fragment fragment = Page.newInstance(++pagesCounter, mPagerAdapter, mPager);
        mPagerAdapter.addPage(fragment);
        mPager.setAdapter(mPagerAdapter);
    }
}
