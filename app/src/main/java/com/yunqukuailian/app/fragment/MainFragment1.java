package com.yunqukuailian.app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yunqukuailian.app.R;
import com.yunqukuailian.app.base.BaseFragment;
import com.yunqukuailian.app.http.ApiService;
import com.yunqukuailian.app.http.CostApi;
import com.yunqukuailian.app.model.BaseBean;
import com.yunqukuailian.app.model.MyFirstFragmentBean;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

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
        Map<String,String> map = new HashMap<>();
        map.put("fteacherid","7708C4D9-A138-41B3-9EC0-7053EC8BB93A");
        map.put("pageindex","1");
        map.put("pagesize","10");
        map.put("ftype","2");
        ApiService.getInstance().create(CostApi.class).getTeacherPubCoursePage(map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<MyFirstFragmentBean>() {
                    @Override
                    public void call(MyFirstFragmentBean baseBean) {
                        //请求成功
                        mytext.setText(baseBean.getMapX().getList().get(0).getFteacherintroduce());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        //请求失败
                        mytext.setText("请求数据失败");
                    }
                });
        ApiService.getInstance().create(CostApi.class).getTeacherPubCoursePage(map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<BaseBean>() {
                    @Override
                    public void call(BaseBean myFirstFragmentBean) {

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
                });

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
