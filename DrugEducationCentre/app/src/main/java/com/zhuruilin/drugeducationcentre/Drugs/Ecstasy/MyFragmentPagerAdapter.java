package com.zhuruilin.drugeducationcentre.Drugs.Ecstasy;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.zhuruilin.drugeducationcentre.Drugs.Ecstasy.DrugFragment;
import com.zhuruilin.drugeducationcentre.Drugs.Ecstasy.MyFragment;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private final int PAGER_COUNT = 4;
    private MyFragment myFragment1 = null;
    private MyFragment myFragment2 = null;
    private MyFragment myFragment3 = null;
    private MyFragment myFragment4 = null;

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        myFragment1 = new MyFragment();
        myFragment1.setContent("第一");
        myFragment2 = new MyFragment();
        myFragment2.setContent("第二");
        myFragment3 = new MyFragment();
        myFragment3.setContent("第三");
        myFragment4 = new MyFragment();
        myFragment4.setContent("第四");
    }

    @Override
    public int getCount() {
        return PAGER_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        System.out.println("position Destory" + position);
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case DrugFragment.PAGE_ONE:
                fragment = myFragment1;
                break;
            case DrugFragment.PAGE_TWO:
                fragment = myFragment2;
                break;
            case DrugFragment.PAGE_THREE:
                fragment = myFragment3;
                break;
            case DrugFragment.PAGE_FOUR:
                fragment = myFragment4;
                break;
        }
        return fragment;
    }
}
