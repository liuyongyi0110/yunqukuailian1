package com.yunqukuailian.app.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.yunqukuailian.app.R;
import com.yunqukuailian.app.adapter.MainFragment3Adapter;
import com.yunqukuailian.app.base.BaseFragment;
import com.yunqukuailian.app.model.MainFragment3Bean;
import com.yunqukuailian.app.utils.SharedPrefsUtil;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/3/1/001.
 */

public class MainFragment3 extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.mainfragment4title)
    TextView mainfragment3title;
    Unbinder unbinder;
    ViewStub nologin;
    ViewStub loginfragment;
    TextView mianfragment3login_money;
    RecyclerView mainfragmen3listview;
    private List<MainFragment3Bean> list = new ArrayList<>();

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.setTitleBar(getActivity(), toolbar);
        addListData();
    }

    public void addListData(){
        for (int i = 0; i < 10; i++) {
            MainFragment3Bean bean = new MainFragment3Bean();
            bean.setTitle("资产 (BTCX)");
            bean.setPrice("0.00");
            bean.setFreeze("0.00");
            list.add(bean);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int setLayout() {
        return R.layout.mainfragment3;
    }


    @Override
    public void initView() {
        super.initView();
        mainfragment3title.setText("我的资产");
//        if (SharedPrefsUtil.isLogin(getActivity())) {
            loginfragment = mViewRoot.findViewById(R.id.loginfragment);
            loginfragment.inflate();
            mainfragmen3listview = mViewRoot.findViewById(R.id.mainfragmen3listview);
            mainfragmen3listview.setLayoutManager(new LinearLayoutManager(getActivity()));
            mianfragment3login_money = mViewRoot.findViewById(R.id.mianfragment3login_money);
            ImageView mianfragment3login_change = mViewRoot.findViewById(R.id.mianfragment3login_change);
            mianfragment3login_change.setOnClickListener(this);
            MainFragment3Adapter adapter = new MainFragment3Adapter(list,new WeakReference<Context>(getActivity()));
            mainfragmen3listview.setAdapter(adapter);
//        } else {
//            nologin = mViewRoot.findViewById(R.id.nologin);
//            nologin.inflate();
//            TextView mainfragment3gologintext = mViewRoot.findViewById(R.id.mainfragment3gologintext);
//            mainfragment3gologintext.setOnClickListener(this);
//
//        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mainfragment3gologintext:
                showToast("去登录");
                break;
            case R.id.mianfragment3login_change:
                showToast("改变什么呢");
                break;
        }
    }
}
