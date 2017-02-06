package com.jikexueyuan.waimaidemo.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jikexueyuan.waimaidemo.fragment.FragmentOne;
import com.jikexueyuan.waimaidemo.fragment.FragmentThree;
import com.jikexueyuan.waimaidemo.fragment.FragmentTwo;

/**
 * Created by huyiqing on 2016/12/21.
 */

public class SectionPagerAdapter extends FragmentPagerAdapter {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public SectionPagerAdapter(FragmentManager fm){super(fm);}


    @Override
    public Fragment getItem(int position) {
        return newInstance(position +1);
    }

    public Fragment newInstance(int sectionNumber) {
        Fragment fragment = getDestFragment(sectionNumber);
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER,sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }


    private static Fragment getDestFragment(int sectionNumber){
        switch (sectionNumber){
            case 1:
                return new FragmentOne();
            case 2:
                return new FragmentTwo();
            case 3:
                return new FragmentThree();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
