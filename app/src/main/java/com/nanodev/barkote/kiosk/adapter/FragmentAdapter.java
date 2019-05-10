package com.nanodev.barkote.kiosk.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.nanodev.barkote.kiosk.Cart;
import com.nanodev.barkote.kiosk.Productlist;

public class FragmentAdapter extends FragmentPagerAdapter {

    public FragmentAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 1:
                return new Cart();
            case 2:
                return new Productlist();
            default:
                return new Productlist();

        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Products";
            case 1:
                return "new sale";
            default:
                return null;
        }
    }
}
