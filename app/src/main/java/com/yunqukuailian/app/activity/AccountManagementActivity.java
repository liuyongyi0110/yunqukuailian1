package com.yunqukuailian.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.yunqukuailian.app.R;
import com.yunqukuailian.app.base.BaseActivity;
import com.yunqukuailian.app.utils.JumpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AccountManagementActivity extends BaseActivity {
    @BindView(R.id.mainfragment4title)
    TextView mainfragment4title;
    @BindView(R.id.add_account)
    ImageView addAccount;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

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
    protected void initView() {
        super.initView();
        addAccount.setVisibility(View.VISIBLE);

    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_account_management;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.add_account})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.add_account:
                JumpUtils.JumpActivityForResult(this,this,LoginActivity.class,JumpUtils.REQUESTCODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == JumpUtils.REQUESTCODE && resultCode == JumpUtils.RESULTCODE){

        }
    }
}
