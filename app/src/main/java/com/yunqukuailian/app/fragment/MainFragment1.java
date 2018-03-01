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

public class MainFragment1 extends BaseFragment {
    @BindView(R.id.mytext)
    TextView mytext;
    Unbinder unbinder;
    private View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.mainfragment1, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    public void initView() {
        mytext.setText(MainFragment1.class.getName());
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
