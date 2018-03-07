package com.yunqukuailian.app.fragment;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.yunqukuailian.app.MainActivity;
import com.yunqukuailian.app.R;
import com.yunqukuailian.app.adapter.MainFragmen2PopupWindowAdapter;
import com.yunqukuailian.app.base.BaseFragment;
import com.yunqukuailian.app.model.MainFragmenPopupBean;
import com.yunqukuailian.app.utils.DisplayUtil;
import com.yunqukuailian.app.utils.FragmentFactory;
import com.yunqukuailian.app.view.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/3/1/001.
 */

public class MainFragment2 extends BaseFragment {
    @BindView(R.id.mainfragment2title)
    TextView mainfragment2title;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    Unbinder unbinder;
    @BindView(R.id.indicator)
    TabPageIndicator indicator;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    private View trans;
    private MainActivity activity;


    private View popView;
    private PopupWindow window;

    private List<MainFragmenPopupBean> popupList = new ArrayList<>();

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.setTitleBar(getActivity(), toolbar);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPopuView1Data();
        activity = (MainActivity) getActivity();
        trans = activity.trans;
    }

    private void initPopuView1Data() {
        for (int i = 0; i < 15; i++) {
            MainFragmenPopupBean bean = new MainFragmenPopupBean();
            bean.setName("测试数据" + i);
            bean.setPic("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1520266903890&di=be30eca72ae46e746fcf4cb7426e474c&" +
                    "imgtype=0&src=http%3A%2F%2Fwww.iapps.im%2Fpublic%2Fuploadfiles%2Ficons%2Fb1de8ce2f3733d2125fea9eb17ec9798.jpg");
            popupList.add(bean);
        }
    }

    @Override
    public int setLayout() {
        return R.layout.mainfragment2;
    }

    @Override
    public void initView() {
        super.initView();
        mainfragment2title.setText("BTCX市场");


        BasePagerAdapter adapter = new BasePagerAdapter(getActivity().getSupportFragmentManager());

        viewPager.setAdapter(adapter);// 设置adapter
        indicator.setViewPager(viewPager);// 绑定indicator

        setTabPagerIndicator();
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

    @OnClick(R.id.mainfragment2title)
    public void onViewClicked() {
        trans.setVisibility(View.VISIBLE);
        showPopuWindow();
    }


    public void showPopuWindow() {
        popView = LayoutInflater.from(getActivity()).inflate(R.layout.mainfragment2popuplayout, null);
        window = new PopupWindow(popView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
//必须设置BackgroundDrawable后setOutsideTouchable(true)才会有效。这里在XML中定义背景，所以这里设置为null;
        window.setBackgroundDrawable(new BitmapDrawable(getResources(),
                (Bitmap) null));
        window.setOutsideTouchable(false); //点击外部关闭。
        // 设置背景颜色变暗

        window.setAnimationStyle(android.R.style.Animation_Dialog);    //设置一个动画。
        window.showAtLocation(toolbar, Gravity.TOP, 0, DisplayUtil.dip2px(getActivity(), 80));
        initPopuView1();
        window.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                trans.setVisibility(View.GONE);
            }
        });
    }

    public void initPopuView1() {
        RecyclerView mainfragment2popupview = popView.findViewById(R.id.main_fragment2_popupview);
        mainfragment2popupview.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        MainFragmen2PopupWindowAdapter adapter = new MainFragmen2PopupWindowAdapter(getActivity(), popupList);
        mainfragment2popupview.setAdapter(adapter);
        adapter.setOnItemClickLister(new MainFragmen2PopupWindowAdapter.OnItemClickLister() {
            @Override
            public void setOnClick(int i) {
                showToast("  " + i);
            }
        });
    }

    /**
     * 通过一些set方法，设置控件的属性
     */
    private void setTabPagerIndicator() {
        indicator.setIndicatorMode(TabPageIndicator.IndicatorMode.MODE_NOWEIGHT_EXPAND_SAME);// 设置模式，一定要先设置模式
//        indicator.setDividerColor(Color.parseColor("#00bbcf"));// 设置分割线的颜色
        indicator.setDividerPadding(10);//设置
        indicator.setIndicatorColor(Color.parseColor("#007aff"));// 设置底部导航线的颜色
        indicator.setTextColorSelected(Color.parseColor("#007aff"));// 设置tab标题选中的颜色
        indicator.setTextColor(Color.parseColor("#797979"));// 设置tab标题未被选中的颜色
        indicator.setTextSize(DisplayUtil.sp2px(getActivity(),14));// 设置字体大小
        indicator.setIndicatorHeight(DisplayUtil.sp2px(getActivity(),2));
    }



    class BasePagerAdapter extends FragmentStatePagerAdapter {
        String[] titles={"买入","卖出","当前委托","历史委托"};

        public BasePagerAdapter(FragmentManager fm) {
            super(fm);

        }

        @Override
        public Fragment getItem(int position) {
            return FragmentFactory.createMainFragmenItem(position);
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
