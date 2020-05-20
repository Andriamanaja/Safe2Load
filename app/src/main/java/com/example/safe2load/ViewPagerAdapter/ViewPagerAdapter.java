package com.example.safe2load.ViewPagerAdapter;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.safe2load.R;

import java.io.FileReader;
import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    Context context ;
    ViewPager viewPager ;
    TabLayout tabLayout ;
    private final ArrayList<Fragment> mFragmentList = new ArrayList<>() ;
    private final ArrayList<String> mFragmentTitleList = new ArrayList<>() ;

    private ArrayList<Fragment> allFragmant = new ArrayList<>();
    private ArrayList<String> allTitle = new ArrayList<>() ;


    public ViewPagerAdapter(FragmentManager fm, Context context, ViewPager viewPager, TabLayout tabLayout) {
        super(fm);
        this.context = context;
        this.viewPager = viewPager;
        this.tabLayout = tabLayout;
    }

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return this.mFragmentList.get(i);
    }

    @Override
    public int getCount() {
        return this.mFragmentList.size();
    }

    public void addFrag(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    public void addInspec() {

    }

    public void removeAllFrag() {
        for (int i = 0 ; i <= mFragmentList.size() ; i++ ) {
            removeTab(0);
            Fragment fragment = mFragmentList.get(0);
            mFragmentList.remove(fragment);
            mFragmentTitleList.remove(0);
            destroyFragmentView(viewPager, 0, fragment);
        }
        this.notifyDataSetChanged();
    }

    public void removeFrag(int position) {
        Log.d("remove => " , String.valueOf(position)) ;
        removeTab(position);
        Fragment fragment = mFragmentList.get(position);
        mFragmentList.remove(fragment);
        mFragmentTitleList.remove(position);
        destroyFragmentView(viewPager, position, fragment);
        this.notifyDataSetChanged();
    }

    public View getTabView (final int position) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.tab_item, null, false);
        TextView teb_item_name = view.findViewById(R.id.tab_item_name) ;
        teb_item_name.setText(mFragmentTitleList.get(position));
        return view;
    }

    public void destroyFragmentView(ViewGroup container, int position, Object object) {
        FragmentManager manager = ((Fragment) object).getFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();
        trans.remove((Fragment) object);
        trans.commit();
    }


    public void removeTab(int position) {
        tabLayout.removeTabAt(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}
