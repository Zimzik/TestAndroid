package com.example.zimzik.testandroid;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFragmentList = new ArrayList<>();

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    public void removePage(Fragment fragment) {
        mFragmentList.remove(fragment);
        this.notifyDataSetChanged();
    }

    public void addPage(Fragment fragment) {
        mFragmentList.add(fragment);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
