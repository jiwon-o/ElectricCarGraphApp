package com.appforest.electriccardata;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapterRange extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapterRange(@NonNull FragmentManager fm, int NumOfTabs) {
        super(fm, NumOfTabs);
        this.mNumOfTabs = NumOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new RangeActivity1();
            case 1: return new RangeActivity2();
            case 2: return new RangeActivity3();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
