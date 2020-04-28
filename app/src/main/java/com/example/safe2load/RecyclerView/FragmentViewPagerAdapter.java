package com.example.safe2load.RecyclerView;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

public class FragmentViewPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {


    List<Fragment> list_fragment = new ArrayList<>() ;
    List<String> list_title_fragment = new ArrayList<>();

    public FragmentViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return list_fragment.get(i);
    }

    @Override
    public int getCount() {
        return list_fragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list_title_fragment.get(position);
    }

    public void addFragment(Fragment fragment , String fragment_title) {
        this.list_fragment.add(fragment) ;
        this.list_title_fragment.add(fragment_title) ;
    }
}
