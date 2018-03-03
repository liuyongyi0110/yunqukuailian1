package com.yunqukuailian.app.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/3/1/001.
 */

public class ApiService {

    //超时时间60s
    private static final int DEFAULT_TIMEOUT = 60;

    public static final String ServerPath = "http://114.119.10.254:8080/youpinserver/"; //服务器接口地址

    private static class Instance{
        private static Retrofit retrofit = createRetrofit();
    }

    public static Retrofit getInstance(){
        return Instance.retrofit;
    }

    private static Retrofit createRetrofit(){
        if(Instance.retrofit != null) return Instance.retrofit;
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        Retrofit retrofit = new Retrofit.Builder()
                .client(client.build()) //OKHttp支持
                .baseUrl(ServerPath)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) //RxJava支持
                .addConverterFactory(GsonConverterFactory.create())    //Gson支持
                .build();

        return retrofit;
    }


}
