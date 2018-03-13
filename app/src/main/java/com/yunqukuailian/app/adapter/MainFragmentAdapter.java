package com.yunqukuailian.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.yunqukuailian.app.R;
import com.yunqukuailian.app.model.MainFragment1Bean;
import com.yunqukuailian.app.utils.DataRequest;
import com.yunqukuailian.app.view.simplekview.BaseKChartView;
import com.yunqukuailian.app.view.simplekview.KChartAdapter;
import com.yunqukuailian.app.view.simplekview.SimpleKChartView;
import com.yunqukuailian.app.view.simplekview.KLineEntity;
import com.yunqukuailian.app.view.simplekview.formatter.DateFormatter;

import java.util.List;

/**
 * Created by android on 2018/3/7.
 */

public class MainFragmentAdapter extends BaseExpandableListAdapter {
    private List<MainFragment1Bean> list;
    private Context context;
    private KChartAdapter mAdapter;
    private Activity activity;
    public MainFragmentAdapter(Context context,List<MainFragment1Bean> list,Activity activity) {
        this.list = list;
        this.context = context;
        this.activity = activity;
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return list.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return list.get(groupPosition).getList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.mainfragment1itemgroup,parent,false);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.mainfragmen1itemchild,parent,false);
        SimpleKChartView kChartView = convertView.findViewById(R.id.mainfragment1chartview);
        initView(kChartView);
        initData(kChartView);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


    private void initView(SimpleKChartView mKChartView) {
        mAdapter = new KChartAdapter();
        mKChartView.setAdapter(mAdapter);
        mKChartView.setDateTimeFormatter(new DateFormatter());
        mKChartView.setGridRows(6);
        mKChartView.setGridColumns(6);
        mKChartView.setOnSelectedChangedListener(new BaseKChartView.OnSelectedChangedListener(){
            @Override
            public void onSelectedChanged(BaseKChartView view, Object point, int index) {
                KLineEntity data = (KLineEntity) point;
                Log.i("onSelectedChanged", "index:" + index + " closePrice:" + data.getClosePrice());
            }
        });
    }

    private void initData(final SimpleKChartView mKChartView) {
        mKChartView.showLoading();
        new Thread(new Runnable() {
            @Override
            public void run() {
                final List<KLineEntity> data = DataRequest.getALL(context);
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter.addFooterData(data);
                        mKChartView.startAnimation();
                        mKChartView.refreshEnd();
                    }
                });
            }
        }).start();
    }
}
