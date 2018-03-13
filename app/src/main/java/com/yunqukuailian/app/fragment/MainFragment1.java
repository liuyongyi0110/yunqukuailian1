package com.yunqukuailian.app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.gyf.barlibrary.ImmersionBar;
import com.yunqukuailian.app.R;
import com.yunqukuailian.app.activity.TransactionDetailsActivity;
import com.yunqukuailian.app.adapter.MainFragmentAdapter;
import com.yunqukuailian.app.base.BaseFragment;
import com.yunqukuailian.app.http.AbsAPICallback;
import com.yunqukuailian.app.http.LocalService;
import com.yunqukuailian.app.model.ChartData;
import com.yunqukuailian.app.model.MainFragment1Bean;
import com.yunqukuailian.app.utils.JumpUtils;

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
    @BindView(R.id.mainfragment4title)
    TextView mainfragment4title;
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
        mainfragment4title.setText("BTCX市场");
        adapter = new MainFragmentAdapter(getActivity(), list, getActivity());
        mainfragment1expandablelist.setGroupIndicator(null);
        mainfragment1expandablelist.setAdapter(adapter);

//        mainfragment1expandablelist.expandGroup(0);
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
        mainfragment1expandablelist.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                JumpUtils.JumpActivity(getActivity(), TransactionDetailsActivity.class);
                return true;
            }
        });

        Map<String,String> parm = new HashMap<>();
        parm.put("market","24");
        parm.put("lineType","1");
        parm.put("limit","100");
        LocalService.getApi().getHealthClassify(parm)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<ChartData>() {
                    @Override
                    protected void onDone(ChartData bean) {

                        //请求成功，做相应的页面操作
                      showToast("成功");
//                        for (int i = 0; i < bean.getData().length; i++) {
//                            for (int j = 0; j < bean.getData()[i].length; j++) {
//                                Log.e("yongyi",bean.getData()[i][j]);
//                            }
//                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        //e.getMessage() 可获取服务器返回错误信息
                        showToast("失败");
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
