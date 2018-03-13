package com.yunqukuailian.app.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.yunqukuailian.app.R;
import com.yunqukuailian.app.base.BaseActivity;
import com.yunqukuailian.app.utils.JumpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.mainfragment4title)
    TextView mainfragment4title;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.logintext)
    TextView logintext;
    @BindView(R.id.loginphone)
    EditText loginphone;
    @BindView(R.id.loginpwd)
    EditText loginpwd;
    @BindView(R.id.loginrelativelayout)
    RelativeLayout loginrelativelayout;
    @BindView(R.id.login_forgetpwd)
    TextView loginForgetpwd;
    @BindView(R.id.login_login)
    TextView loginLogin;
    @BindView(R.id.login_registered)
    TextView loginRegistered;

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.setTitleBar(this,toolbar);
        toolbar.setNavigationIcon(R.drawable.back_icon);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void initView() {
        super.initView();

        mainfragment4title.setText("账号登陆");
    }

    @OnClick({R.id.loginrelativelayout, R.id.login_forgetpwd, R.id.login_login, R.id.login_registered})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.loginrelativelayout:
                break;
            case R.id.login_forgetpwd:
                JumpUtils.JumpActivity(this,ForgetPasswordActivity.class);
                break;
            case R.id.login_login:
                showToast("登陆");
                break;
            case R.id.login_registered:
                JumpUtils.JumpActivity(this,RegisteredActivity.class);
                break;
        }
    }
}
