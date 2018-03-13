package com.yunqukuailian.app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yunqukuailian.app.R;
import com.yunqukuailian.app.model.MainFragment3Bean;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by Administrator on 2018/3/10/010.
 */

public class MainFragment3Adapter extends RecyclerView.Adapter <MainFragment3Adapter.ViewHold>{
    private List<MainFragment3Bean> list;
    private WeakReference<Context> context;

    public MainFragment3Adapter(List<MainFragment3Bean> list, WeakReference<Context> context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHold(LayoutInflater.from(context.get()).inflate(R.layout.mainfragment3item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHold holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHold extends RecyclerView.ViewHolder{

        public ViewHold(View itemView) {
            super(itemView);
        }
    }
}
