package com.taobao.newwidgetdemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class TabActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        Toolbar toolbar = (Toolbar) findViewById(R.id.title_bar);
        setSupportActionBar(toolbar);


        ViewPager viewPager = (ViewPager) findViewById(R.id.vpager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(TabFragment.newInstance("THIS IS TAB1"));
        fragmentList.add(TabFragment.newInstance("THIS IS TAB2"));
        fragmentList.add(TabFragment.newInstance("THIS IS TAB3"));
        fragmentList.add(TabFragment.newInstance("THIS IS TAB4"));
        fragmentList.add(TabFragment.newInstance("THIS IS TAB5"));
        fragmentList.add(TabFragment.newInstance("THIS IS TAB6"));
        fragmentList.add(TabFragment.newInstance("THIS IS TAB7"));
        fragmentList.add(TabFragment.newInstance("THIS IS TAB8"));

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(),fragmentList));

        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
//        tabLayout.setTabMode(TabLayout.MODE_FIXED);
//        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);


    }

    class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter
    {
        List<Fragment> mFragmentList;
        public FragmentPagerAdapter(FragmentManager fm,List<Fragment> fragmentList)
        {
            super(fm);
            this.mFragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int position)
        {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount()
        {
            return mFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position)
        {
            return "TAB "+(position+1);
        }
    }

}
