package com.yunqukuailian.app;

import android.app.FragmentManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.yunqukuailian.app.base.BaseActivity;
import com.yunqukuailian.app.fragment.MainFragment1;
import com.yunqukuailian.app.fragment.MainFragment2;
import com.yunqukuailian.app.fragment.MainFragment3;
import com.yunqukuailian.app.fragment.MainFragment4;
import com.yunqukuailian.app.utils.DisplayUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @BindView(R.id.fragmentmain)
    FrameLayout fragmentmain;
    @BindView(R.id.radio1)
    RadioButton radio1;
    @BindView(R.id.radio2)
    RadioButton radio2;
    @BindView(R.id.radio3)
    RadioButton radio3;
    @BindView(R.id.radio4)
    RadioButton radio4;

    private MainFragment1 mainfragment1;
    private MainFragment2 mainfragment2;
    private MainFragment3 mainfragment3;
    private MainFragment4 mainfragment4;
    private FragmentTransaction transaction;
    private static int selection = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        transaction = getSupportFragmentManager().beginTransaction();  //Activity中
        mainfragment1 = new MainFragment1();
        transaction.add(R.id.fragmentmain, mainfragment1);
        setSelect(selection);
        transaction.show(mainfragment1);
        transaction.commit();
    }



    @OnClick({R.id.radio1, R.id.radio2, R.id.radio3, R.id.radio4})
    public void onViewClicked(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()) {
            case R.id.radio1:
                if (mainfragment1 == null) {
                    mainfragment1 = new MainFragment1();
                    transaction.add(R.id.fragmentmain, mainfragment1);
                    transaction.show(mainfragment1);
                }
                transaction.show(mainfragment1);
                if (mainfragment2 != null) {
                    transaction.hide(mainfragment2);
                }

                if (mainfragment3 != null) {
                    transaction.hide(mainfragment3);
                }

                if (mainfragment4 != null) {
                    transaction.hide(mainfragment4);
                }

                transaction.commit();
                setSelect(0);
                selection = 0;
                break;
            case R.id.radio2:
                if (mainfragment2 == null) {
                    mainfragment2 = new MainFragment2();
                    transaction.add(R.id.fragmentmain, mainfragment2);

                }
                transaction.show(mainfragment2);
                if (mainfragment1 != null) {
                    transaction.hide(mainfragment1);
                }

                if (mainfragment3 != null) {
                    transaction.hide(mainfragment3);
                }

                if (mainfragment4 != null) {
                    transaction.hide(mainfragment2);
                }
                transaction.commit();
                setSelect(1);
                selection = 1;
                break;
            case R.id.radio3:
                if (mainfragment3 == null) {
                    mainfragment3 = new MainFragment3();
                    transaction.add(R.id.fragmentmain, mainfragment3);

                }

                transaction.show(mainfragment3);
                if (mainfragment1 != null) {
                    transaction.hide(mainfragment1);
                }

                if (mainfragment2 != null) {
                    transaction.hide(mainfragment2);
                }

                if (mainfragment4 != null) {
                    transaction.hide(mainfragment4);
                }


                transaction.commit();
                setSelect(2);
                selection = 2;
                break;
            case R.id.radio4:
                if (mainfragment4 == null) {
                    mainfragment4 = new MainFragment4();
                    transaction.add(R.id.fragmentmain, mainfragment4);
                }
                transaction.show(mainfragment4);

                if (mainfragment1 != null) {
                    transaction.hide(mainfragment1);
                }

                if (mainfragment2 != null) {
                    transaction.hide(mainfragment2);
                }

                if (mainfragment3 != null) {
                    transaction.hide(mainfragment3);
                }
                transaction.commit();
                setSelect(3);
                selection = 3;
                break;
        }
    }

    private void setSelect(int i) {
        setTab(i);
    }

    private void setTab(int i) {
            resetTab();
            switch (i) {
                case 0:
                    Drawable drawable1 = getResources().getDrawable(R.drawable.ic_launcher_background);
                    drawable1.setBounds(0, 0, DisplayUtil.dip2px(this, 22), DisplayUtil.dip2px(this, 22));
                    radio1.setCompoundDrawables(null, drawable1, null, null);
                    radio1.setTextColor(Color.parseColor("#007aff"));
                    break;
                case 1:

                    Drawable drawable2 = getResources().getDrawable(R.drawable.ic_launcher_background);
                    drawable2.setBounds(0, 0, DisplayUtil.dip2px(this, 22), DisplayUtil.dip2px(this, 22));
                    radio2.setCompoundDrawables(null, drawable2, null, null);
                    radio2.setTextColor(Color.parseColor("#007aff"));
                    break;
                case 2:
                    Drawable drawable3 = getResources().getDrawable(R.drawable.ic_launcher_background);
                    drawable3.setBounds(0, 0, DisplayUtil.dip2px(this, 22), DisplayUtil.dip2px(this, 22));
                    radio3.setCompoundDrawables(null, drawable3, null, null);
                    radio3.setTextColor(Color.parseColor("#007aff"));
                    break;
                case 3:
                    Drawable drawable4 = getResources().getDrawable(R.drawable.ic_launcher_background);
                    drawable4.setBounds(0, 0, DisplayUtil.dip2px(this, 22), DisplayUtil.dip2px(this, 22));
                    radio4.setCompoundDrawables(null, drawable4, null, null);
                    radio4.setTextColor(Color.parseColor("#007aff"));
                    break;
            }


    }


    protected void resetTab() {
        if(radio1 != null){
            Drawable drawable1 = getResources().getDrawable(R.drawable.ic_launcher_background);
            drawable1.setBounds(0, 0, DisplayUtil.dip2px(this, 22), DisplayUtil.dip2px(this, 22));
            radio1.setCompoundDrawables(null, drawable1, null, null);

            Drawable drawable2 = getResources().getDrawable(R.drawable.ic_launcher_background);
            drawable2.setBounds(0, 0, DisplayUtil.dip2px(this, 22), DisplayUtil.dip2px(this, 22));
            radio2.setCompoundDrawables(null, drawable2, null, null);

            Drawable drawable3 = getResources().getDrawable(R.drawable.ic_launcher_background);
            drawable3.setBounds(0, 0, DisplayUtil.dip2px(this, 22), DisplayUtil.dip2px(this, 22));
            radio3.setCompoundDrawables(null, drawable3, null, null);

            Drawable drawable4 = getResources().getDrawable(R.drawable.ic_launcher_background);
            drawable4.setBounds(0, 0, DisplayUtil.dip2px(this, 22), DisplayUtil.dip2px(this, 22));
            radio4.setCompoundDrawables(null, drawable4, null, null);

            radio1.setTextColor(Color.parseColor("#808080"));
            radio2.setTextColor(Color.parseColor("#808080"));
            radio3.setTextColor(Color.parseColor("#808080"));
            radio4.setTextColor(Color.parseColor("#808080"));
        }

    }

}
