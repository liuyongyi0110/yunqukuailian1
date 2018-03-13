package com.yunqukuailian.app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.yunqukuailian.app.R;
import com.yunqukuailian.app.activity.AccountManagementActivity;
import com.yunqukuailian.app.activity.IdentityAuthenticationActivity;
import com.yunqukuailian.app.activity.LoginActivity;
import com.yunqukuailian.app.activity.SecuritycCenterActivity;
import com.yunqukuailian.app.base.BaseFragment;
import com.yunqukuailian.app.utils.JumpUtils;
import com.yunqukuailian.app.utils.SharedPrefsUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/3/1/001.
 */

public class MainFragment4 extends BaseFragment {

    @BindView(R.id.mainfragment4title)
    TextView mainfragment4title;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    Unbinder unbinder;
    @BindView(R.id.securitylinearlayout)
    LinearLayout securitylinearlayout;
    @BindView(R.id.minelinearlayout)
    LinearLayout minelinearlayout;
    @BindView(R.id.identitylinearlayout)
    LinearLayout identitylinearlayout;
    @BindView(R.id.invitationlinearlayout)
    LinearLayout invitationlinearlayout;
    @BindView(R.id.customer_servicelinearlayout)
    LinearLayout customerServicelinearlayout;
    @BindView(R.id.aboutlinearlayout)
    LinearLayout aboutlinearlayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.setTitleBar(getActivity(), toolbar);
    }

    @Override
    public int setLayout() {
        return R.layout.mainfragment4;
    }

    @Override
    public void initView() {
        super.initView();
        mainfragment4title.setText("我的信息");
//        if(SharedPrefsUtil.isLogin(getActivity())){
            minelinearlayout.setVisibility(View.VISIBLE);
            identitylinearlayout.setVisibility(View.VISIBLE);
            invitationlinearlayout.setVisibility(View.VISIBLE);
//        }else {
//            minelinearlayout.setVisibility(View.GONE);
//            identitylinearlayout.setVisibility(View.GONE);
//            invitationlinearlayout.setVisibility(View.GONE);
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

    @OnClick({R.id.securitylinearlayout, R.id.minelinearlayout, R.id.identitylinearlayout, R.id.invitationlinearlayout, R.id.customer_servicelinearlayout, R.id.aboutlinearlayout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.securitylinearlayout:
                showToast("个人中心");
                if(SharedPrefsUtil.isLogin(getActivity())){
                    JumpUtils.JumpActivity(getActivity(), AccountManagementActivity.class);
                }else{
                    JumpUtils.JumpActivity(getActivity(), LoginActivity.class);
                }
                break;
            case R.id.minelinearlayout:
                JumpUtils.JumpActivity(getActivity(), SecuritycCenterActivity.class);
                break;
            case R.id.identitylinearlayout:
                JumpUtils.JumpActivity(getActivity(), IdentityAuthenticationActivity.class);
                break;
            case R.id.invitationlinearlayout:
                showToast("邀请享返佣");
                break;
            case R.id.customer_servicelinearlayout:
                showToast("客服中心");
                break;
            case R.id.aboutlinearlayout:
                showToast("关于我们");
                break;
        }
    }
}
