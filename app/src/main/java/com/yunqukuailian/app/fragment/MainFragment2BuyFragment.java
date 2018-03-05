package com.yunqukuailian.app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.yunqukuailian.app.R;
import com.yunqukuailian.app.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/3/5/005.
 */

public class MainFragment2BuyFragment extends BaseFragment {
    @BindView(R.id.mytext)
    TextView mytext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int setLayout() {
        return R.layout.mainfragment4;
    }

    @Override
    public void initView() {
        super.initView();
        mytext.setText(MainFragment2BuyFragment.class.getName());
    }
    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
