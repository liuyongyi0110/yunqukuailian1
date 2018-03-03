package com.yunqukuailian.app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.yunqukuailian.app.R;
import com.yunqukuailian.app.base.BaseFragment;
import com.yunqukuailian.app.http.ApiService;
import com.yunqukuailian.app.http.CostApi;
import com.yunqukuailian.app.model.MyFirstFragmentBean;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/3/1/001.
 */

public class MainFragment1 extends BaseFragment {
    @BindView(R.id.mytext)
    TextView mytext;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    Unbinder unbinder;

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.setTitleBar(getActivity(), toolbar);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int setLayout() {
        return R.layout.mainfragment1;
    }

    @Override
    public void initView() {
        super.initView();
        Map<String, String> map = new HashMap<>();
        map.put("fteacherid", "58C5FC4E-2E1C-41A1-8075-55B804FB8979");
        map.put("pageindex", "1");
        map.put("pagesize", "10");
        map.put("ftype", "1");
        ApiService.getInstance().create(CostApi.class).getTeacherPubCoursePage(map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<MyFirstFragmentBean>() {
                    @Override
                    public void call(MyFirstFragmentBean baseBean) {
                        //请求成功
                        mytext.setText(baseBean.getMap().getList().get(0).getFteacherintroduce());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        //请求失败
                        mytext.setText("请求数据失败");
                    }
                });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }
}
