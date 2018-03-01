package com.yunqukuailian.app.http;

import com.yunqukuailian.app.model.BaseBean;

import java.util.Map;

import retrofit2.http.PUT;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Administrator on 2018/3/1/001.
 */

interface CostApiBase {
    @PUT("")
    Observable<BaseBean> constat(@QueryMap Map<String,String> map);
}
