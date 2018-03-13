package com.yunqukuailian.app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yunqukuailian.app.R;
import com.yunqukuailian.app.activity.RegisteredActivity;
import com.yunqukuailian.app.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/3/13/013.
 */

public class RegisteredFragmentStep1 extends BaseFragment {
    @BindView(R.id.registered_text)
    TextView registeredText;
    @BindView(R.id.registered_country)
    TextView registeredCountry;
    @BindView(R.id.registered_phone)
    EditText registeredPhone;
    @BindView(R.id.registered_code)
    EditText registeredCode;
    @BindView(R.id.registered_invite_code)
    EditText registeredInviteCode;
    @BindView(R.id.registered_text2)
    TextView registeredText2;
    @BindView(R.id.registered_relative)
    RelativeLayout registeredRelative;
    Unbinder unbinder;
    @BindView(R.id.registered_nextstep)
    TextView registeredNextstep;

    private RegisteredActivity activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (RegisteredActivity) getActivity();
    }

    @Override
    public int setLayout() {
        return R.layout.registeredstep1;
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

    @OnClick({R.id.registered_country, R.id.registered_text2,R.id.registered_nextstep})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.registered_country:
                break;
            case R.id.registered_text2:
                break;
            case R.id.registered_nextstep:
                activity.setNextStep();
                break;
        }
    }


}
