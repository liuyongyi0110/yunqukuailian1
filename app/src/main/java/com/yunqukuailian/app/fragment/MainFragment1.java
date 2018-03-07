package com.yunqukuailian.app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;

import com.gyf.barlibrary.ImmersionBar;
import com.yunqukuailian.app.R;
import com.yunqukuailian.app.adapter.MainFragmentAdapter;
import com.yunqukuailian.app.base.BaseFragment;
import com.yunqukuailian.app.http.ApiService;
import com.yunqukuailian.app.http.CostApi;
import com.yunqukuailian.app.model.MainFragment1Bean;
import com.yunqukuailian.app.model.MyFirstFragmentBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private List<MainFragment1Bean> list = new ArrayList<>();
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    Unbinder unbinder;
    @BindView(R.id.main_fragment1_expandablelist)
    ExpandableListView mainfragment1expandablelist;

    private MainFragmentAdapter adapter;

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.setTitleBar(getActivity(), toolbar);
        initMyData();
    }

    private void initMyData() {
        for (int i = 0; i < 20; i++) {
            MainFragment1Bean bean = new MainFragment1Bean();
            bean.setBname("BTC");
            bean.setBprice("11.36");
            bean.setPic("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1520266903890&di=be" +
                    "30eca72ae46e746fcf4cb7426e474c&imgtype=0&src=http%3A%2F%2Fwww.iapps.im%2Fpublic%2Fuploadfiles%2Ficons%2Fb1de8ce2f3733d2125fea9eb17ec9798.jpg");
            bean.setPricedoll("6.3");
            bean.setPriceupdown("+0.03");
            bean.setPriceren("12.6");
            list.add(bean);
        }
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
        adapter = new MainFragmentAdapter(getActivity(),list);
        mainfragment1expandablelist.setGroupIndicator(null);
        mainfragment1expandablelist.setAdapter(adapter);
        mainfragment1expandablelist.expandGroup(0);
        //设置只展开一个view
        mainfragment1expandablelist.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                int count = mainfragment1expandablelist.getExpandableListAdapter().getGroupCount();
                for(int j = 0; j < count; j++){
                    if(j != groupPosition){
                        mainfragment1expandablelist.collapseGroup(j);
                    }
                }
            }
        });

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
//                        mytext.setText(baseBean.getMap().getList().get(0).getFteacherintroduce());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        //请求失败
//                        mytext.setText("请求数据失败");
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
