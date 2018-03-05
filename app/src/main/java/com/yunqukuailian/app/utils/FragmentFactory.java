package com.yunqukuailian.app.utils;

import android.support.v4.app.Fragment;

import com.yunqukuailian.app.fragment.MainFragment2BuyFragment;
import com.yunqukuailian.app.fragment.MainFragment2CurrentFragment;
import com.yunqukuailian.app.fragment.MainFragment2HistoryFragment;
import com.yunqukuailian.app.fragment.MainFragment2SellFragment;


public class FragmentFactory {

    public static Fragment createMainFragmenItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new MainFragment2BuyFragment();
                break;
            case 1:
                fragment = new MainFragment2SellFragment();
                break;
            case 2:
                fragment = new MainFragment2CurrentFragment();
                break;
            case 3:
                fragment = new MainFragment2HistoryFragment();
                break;

        }
        return fragment;
    }

}
