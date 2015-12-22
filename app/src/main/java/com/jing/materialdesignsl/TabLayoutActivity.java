package com.jing.materialdesignsl;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class TabLayoutActivity extends AppCompatActivity {

    TabLayout sliding_tabs;

    ViewPager viewpager;

    ArrayList<Fragment> lists = new ArrayList<Fragment>();
    ArrayList<String> titles = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_test);

        viewpager = (ViewPager) findViewById(R.id.viewpager);
        sliding_tabs = (TabLayout) findViewById(R.id.sliding_tabs);

//        sliding_tabs.addTab(sliding_tabs.newTab().setText("Tab One").setIcon(R.drawable.ic_dashboard));
//        sliding_tabs.addTab(sliding_tabs.newTab().setText("Tab Two").setIcon(R.drawable.ic_event));
//        sliding_tabs.addTab(sliding_tabs.newTab().setText("Tab Two").setIcon(R.drawable.ic_event));
//        sliding_tabs.addTab(sliding_tabs.newTab().setText("Tab There").setIcon(R.drawable.ic_headset));
//        sliding_tabs.addTab(sliding_tabs.newTab().setText("Tab There").setIcon(R.drawable.ic_headset));
//        sliding_tabs.addTab(sliding_tabs.newTab().setText("Tab Five").setIcon(R.drawable.ic_forum));
//        sliding_tabs.addTab(sliding_tabs.newTab().setText("Tab Six").setIcon(R.drawable.ic_forum));

        initData();

        viewpager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        sliding_tabs.setupWithViewPager(viewpager);


    }

    private void initData() {

        for (int i = 0; i < 3; i++) {

            titles.add("Tab" + i);

        }
        lists.add(BlankFragment.newInstance("page:" + 1, "parmas:" + 1));
        lists.add(BlankTwoFragment.newInstance("page:" + 2, "parmas:" + 2));
        lists.add(BlankThereFragment.newInstance("page:" + 3, "parmas:" + 3));
    }


    class MyPagerAdapter extends FragmentPagerAdapter {


        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return lists.size();
        }



        @Override
        public Fragment getItem(int position) {
            return lists.get(position);
        }


        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            Log.e("aaa", "destory " + position);
        }
    }

}
