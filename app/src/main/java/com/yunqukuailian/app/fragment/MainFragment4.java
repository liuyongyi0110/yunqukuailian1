package com.yunqukuailian.app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yunqukuailian.app.R;
import com.yunqukuailian.app.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/3/1/001.
 */

public class MainFragment4 extends BaseFragment {
    @BindView(R.id.mytext)
    TextView mytext;

    private View view;
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
        mytext.setText(MainFragment4.class.getName());
    }
    @Override
    public void onDestroy() {
        super.onDestroy();

    }


}
