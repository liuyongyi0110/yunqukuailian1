package com.yunqukuailian.app.http;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/3/1/001.
 */

public class ApiService {
    public static final String ServerPath = "服务器地址"; //服务器接口地址

    private static class Instance{
        private static Retrofit retrofit = createRetrofit();
    }

    public static Retrofit getInstance(){
        return Instance.retrofit;
    }

    private static Retrofit createRetrofit(){
        if(Instance.retrofit != null) return Instance.retrofit;

        Retrofit retrofit = new Retrofit.Builder()
                .client(new OkHttpClient()) //OKHttp支持
                .baseUrl(ServerPath)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) //RxJava支持
                .addConverterFactory(GsonConverterFactory.create())    //Gson支持
                .build();

        return retrofit;
    }


}
