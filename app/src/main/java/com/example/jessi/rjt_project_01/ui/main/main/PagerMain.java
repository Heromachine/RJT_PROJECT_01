package com.example.jessi.rjt_project_01.ui.main.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerMain extends FragmentStatePagerAdapter {

    int iTabCount;

    public PagerMain(FragmentManager fm, int tabCount) {
        super(fm);
        this.iTabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabCategories tabCategories = new TabCategories();
                return tabCategories;
            case 1:
                TabClothes tabClothes = new TabClothes();
                return tabClothes;
            case 2:
                TabElectronics tabElectronics = new TabElectronics();
                return tabElectronics;
            case 3:
                TabFashion tabFashion = new TabFashion();
                return tabFashion;
            case 4:
                TabHomeAppliance tabHomeAppliance = new TabHomeAppliance();
                return tabHomeAppliance;
            case 5:
                TabJewelry tabJewelry = new TabJewelry();
                return tabJewelry;
            case 6:
                TabMobilePhones tabMobilePhones = new TabMobilePhones();
                return tabMobilePhones;
            case 7:
                TabPersonalCare tabPersonalCare = new TabPersonalCare();
                return tabPersonalCare;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return iTabCount;
    }
}
