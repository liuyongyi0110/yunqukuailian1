package com.yunqukuailian.app.http;


import com.yunqukuailian.app.model.ChartData;

import java.util.List;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by hedong on 2016/4/19.
 */
public interface LocalApi {

    //获取类别
    @GET("kline")
    Observable<ChartData> getHealthClassify(@QueryMap Map<String, String> parm);


}
