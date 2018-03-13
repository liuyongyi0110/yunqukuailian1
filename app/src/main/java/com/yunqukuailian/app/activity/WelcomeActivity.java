package com.yunqukuailian.app.activity;

import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;
import android.widget.ImageView;

import com.yunqukuailian.app.MainActivity;
import com.yunqukuailian.app.R;
import com.yunqukuailian.app.base.BaseActivity;
import com.yunqukuailian.app.utils.JumpUtils;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/3/3/003.
 */

public class WelcomeActivity extends BaseActivity  {
    @BindView(R.id.wecomeimage)
    ImageView wecomeimage;

    // 要申请的权限
    private Timer timer;
    private TimerTask task;
    private Handler handler = new Handler();
    private String url;
    private int closetime = 4;//设置显示时间
    private int closes = closetime;

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



}
