package com.yunqukuailian.app.activity;

import android.Manifest;
import android.app.AlertDialog;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yunqukuailian.app.MainActivity;
import com.yunqukuailian.app.R;
import com.yunqukuailian.app.base.BaseActivity;
import com.yunqukuailian.app.utils.JumpUtils;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/3/3/003.
 */

public class WelcomeActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.wecomeimage)
    ImageView wecomeimage;
    @BindView(R.id.version)
    TextView version;
    @BindView(R.id.timesss)
    TextView timesss;
    @BindView(R.id.close)
    RelativeLayout close;
    // 要申请的权限
    private Timer timer;
    private TimerTask task;
    private Handler handler = new Handler();
    private String url;
    private int closetime = 4;//设置显示时间
    private int closes = closetime;


    private Handler myHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            timesss.setText(String.valueOf(closes) + "s");
        }
    };

    @Override
    protected int setLayoutId() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return R.layout.activity_welcome;
    }

    @Override
    protected void initView() {
        super.initView();

        timer = new Timer();
        task = new TimerTask() {
            public void run() {
                JumpUtils.JumpActivity(WelcomeActivity.this, MainActivity.class);
                finish();
            }
        };
        checkPer();


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadmessage();
            }
        }, 1000);

    }

    private void loadmessage() {
        timer.schedule(task, 1000 * 2); //呈现2秒跳转到MainActivity(主界面)中
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.close:
                JumpUtils.JumpActivity(WelcomeActivity.this, MainActivity.class);
                finish();
                break;

        }
    }



    @OnClick(R.id.close)
    public void onViewClicked() {
        JumpUtils.JumpActivity(WelcomeActivity.this, MainActivity.class);
        finish();
    }
}
