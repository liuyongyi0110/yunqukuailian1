package com.yunqukuailian.app.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.yunqukuailian.app.R;
import com.yunqukuailian.app.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RealNameAuthenticationActivity extends BaseActivity {
    @BindView(R.id.mainfragment4title)
    TextView mainfragment4title;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.autext1)
    TextView autext1;
    @BindView(R.id.identity_information)
    RelativeLayout identityInformation;
    @BindView(R.id.authentication_subbit)
    TextView authenticationSubbit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.setTitleBar(this, toolbar);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_real_name_authentication;
    }




    @OnClick({ R.id.autext1,R.id.authentication_subbit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.autext1:
                break;
            case R.id.authentication_subbit:

                break;
        }
    }

}
