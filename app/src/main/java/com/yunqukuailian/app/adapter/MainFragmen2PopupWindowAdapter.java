package com.yunqukuailian.app.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.yunqukuailian.app.R;
import com.yunqukuailian.app.model.MainFragmenPopupBean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/5/005.
 */

public class MainFragmen2PopupWindowAdapter extends RecyclerView.Adapter<MainFragmen2PopupWindowAdapter.MyViewHolder> {
    private List<MainFragmenPopupBean> popupList;
    private Context context;
    private OnItemClickLister onItemClickLister;

    public void setOnItemClickLister(OnItemClickLister onItemClickLister){
        this.onItemClickLister = onItemClickLister;
    }

    public MainFragmen2PopupWindowAdapter(Context context,List<MainFragmenPopupBean> popupList) {
        this.popupList = popupList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.mainfragment2popupitem,parent,false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.popupmainitemtext.setText(popupList.get(position).getName());
        Glide.with(context)
                .load(popupList.get(position).getPic())
                .error(R.drawable.loaderror)
                .into(holder.popupmainitemimage);
        holder.mainfragmenitem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickLister.setOnClick(position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return popupList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView popupmainitemtext;
        ImageView popupmainitemimage;
        LinearLayout mainfragmenitem2;
        public MyViewHolder(View itemView) {
            super(itemView);
            popupmainitemtext= itemView.findViewById(R.id.popupmainitemtext);
            popupmainitemimage = itemView.findViewById(R.id.popupmainitemimage);
            mainfragmenitem2 = itemView.findViewById(R.id.mainfragmenitem2);
        }
    }

    public interface OnItemClickLister {
        void setOnClick(int i);
    }
}
