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
    private MyFragment2 myFragment2 = null;
    private MyFragment3 myFragment3 = null;
    private MyFragment4 myFragment4 = null;

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        myFragment1 = new MyFragment();
        myFragment1.setTitle("What is ecstasy (MDMA)?");
        myFragment2 = new MyFragment2();
        myFragment2.setTitle("Ecstasy (MDMA): Effects on the Body & Mind");
        myFragment3 = new MyFragment3();
        myFragment3.setTitle("Other Reasons");
        myFragment4 = new MyFragment4();

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
