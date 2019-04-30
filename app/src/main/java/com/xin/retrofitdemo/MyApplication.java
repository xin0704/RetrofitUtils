package com.xin.retrofitdemo;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.xin.net.Util.Config.Config;
import com.xin.net.net.Base.ProxyFactory;
import com.xin.net.net.Retrofit.RetrofitUtil;

/**
 * Created by admin on 2019/4/24.
 */

public class MyApplication extends Application {

    private static MyApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        //开启debug模式 可打印log
        Config.DEBUG = true;
        //设置请求服务器成功的响应码 （此响应码是客户端和服务器自己约定的 不是HTTP响应码）
        Config.SUCCESS_CODE = 0;
        //初始化Retrofit网络请求工具
        ProxyFactory.obtain().init(new RetrofitUtil());

        if (LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
        LeakCanary.install(this);
    }

    public static MyApplication getApplication(){
        return application;
    }
}
