package com.xin.net.net.Retrofit;

import android.content.Context;

import com.xin.net.Cache.Cache.CacheInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xin on 2019/4/24.
 */

public class RetrofitFactory {

    private static RetrofitFactory factory;

    private Retrofit retrofit;

    public static RetrofitFactory obtain() {
        if (factory == null) {
            synchronized (RetrofitFactory.class) {
                if (factory == null) {
                    factory = new RetrofitFactory();
                }
            }
        }
        return factory;
    }

    public <T> T createService(Context context, String baseUrl, Class<T> clz) {

        OkHttpClient client = new OkHttpClient.Builder()
                //添加缓存拦截器
                .addInterceptor(new CacheInterceptor(context))
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(clz);
    }
}
