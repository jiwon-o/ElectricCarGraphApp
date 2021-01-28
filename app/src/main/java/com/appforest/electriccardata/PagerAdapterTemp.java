package com.appforest.electriccardata;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapterTemp extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapterTemp(@NonNull FragmentManager fm, int NumOfTabs) {
        super(fm, NumOfTabs);
        this.mNumOfTabs = NumOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TemperatureActivity1();
            case 1:
                return new TemperatureActivity2();
            case 2:
                return new TemperatureActivity3();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
