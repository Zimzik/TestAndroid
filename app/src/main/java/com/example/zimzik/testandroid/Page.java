package com.example.zimzik.testandroid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Page extends Fragment {
    private static int sPageNum;
    private static MyPagerAdapter sMyPagerAdapter;
    private static ViewPager sViewPager;
    TextView mTvNum;
    public static Page newInstance(int pageNum, MyPagerAdapter pagerAdapter, ViewPager viewPager) {
        sPageNum = pageNum;
        sMyPagerAdapter = pagerAdapter;
        sViewPager = viewPager;
        Bundle args = new Bundle();

        Page fragment = new Page();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_fragment, container, false);
        mTvNum = view.findViewById(R.id.tv_page_num);
        mTvNum.setText(String.valueOf(sPageNum));

        view.findViewById(R.id.plus).setOnClickListener(v -> {
            sMyPagerAdapter.addPage(newInstance(++MainActivity.pagesCounter, sMyPagerAdapter, sViewPager));
            sViewPager.setCurrentItem(MainActivity.pagesCounter, true);
        });
        if (sPageNum == 1) {
            view.findViewById(R.id.minus).setVisibility(View.INVISIBLE);
        } else {
           /* view.findViewById(R.id.minus).setOnClickListener(v -> {
                sMyPagerAdapter.removePage(sMyPagerAdapter.getItem(sPageNum - 1));
                sViewPager.setAdapter(sMyPagerAdapter);
                sViewPager.setCurrentItem(sPageNum - 1, true);
            });*/
        }
        return view;
    }

    @Override
    public void onResume() {
        Log.i("Ololo", "State changed!");
        mTvNum.setText(String.valueOf(sPageNum));
        super.onResume();
    }
}
