package com.zhuruilin.drugeducationcentre.Drugs.Methamphetamine;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.zhuruilin.drugeducationcentre.Drugs.Ecstasy.DrugFragment;
import com.zhuruilin.drugeducationcentre.Drugs.Ecstasy.MyFragment;
import com.zhuruilin.drugeducationcentre.Drugs.Ecstasy.MyFragment2;
import com.zhuruilin.drugeducationcentre.Drugs.Ecstasy.MyFragment3;
import com.zhuruilin.drugeducationcentre.Drugs.Ecstasy.MyFragment4;

public class MethFragmentPagerAdapter extends FragmentPagerAdapter {
    private final int PAGER_COUNT = 4;
    private MethFragment myFragment1 = null;
    private MethFragment2 myFragment2 = null;
    private MethFragment3 myFragment3 = null;
    private MethFragment4 myFragment4 = null;

    public MethFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        myFragment1 = new MethFragment();

        myFragment2 = new MethFragment2();

        myFragment3 = new MethFragment3();

        myFragment4 = new MethFragment4();

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
            case MethamphetamineFragment.PAGE_ONE:
                fragment = myFragment1;
                break;
            case MethamphetamineFragment.PAGE_TWO:
                fragment = myFragment2;
                break;
            case MethamphetamineFragment.PAGE_THREE:
                fragment = myFragment3;
                break;
            case MethamphetamineFragment.PAGE_FOUR:
                fragment = myFragment4;
                break;
        }
        return fragment;
    }
}
