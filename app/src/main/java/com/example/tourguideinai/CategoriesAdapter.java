package com.example.tourguideinai;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CategoriesAdapter extends FragmentPagerAdapter {

    //массив заголовков  - 1
    private final int PAGE_COUNT = 4;
    private String[] tabTitles = new String[PAGE_COUNT];


    public CategoriesAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);


        tabTitles[0] = context.getString(R.string.cat_museums);
        tabTitles[1] = context.getString(R.string.cat_parks);
        tabTitles[2] = context.getString(R.string.cat_palaces);
        tabTitles[3] = context.getString(R.string.cat_monuments);
    }


    @Override
    public int getCount() {
        return PAGE_COUNT;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new BibliotekFragment();
            case 1:
                return new ParksFragment();
            case 2:
                return new PalacesFragment();
            case 3:
                return new CafesFragment();
        }
        return null;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

}