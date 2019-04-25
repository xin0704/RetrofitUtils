package com.xin.net.net.Base;

import android.content.Context;

import java.util.Map;

/**
 * Created by admin on 2019/3/20.
 */

public class ProxyFactory implements IHttp {

    private IHttp iHttp;

    private static ProxyFactory proxyFactory;

    public static ProxyFactory obtain() {
        if (proxyFactory == null) {
            synchronized (ProxyFactory.class) {
                if (proxyFactory == null) {
                    proxyFactory = new ProxyFactory();
                }
            }
        }
        return proxyFactory;
    }

    public void init(IHttp iHttp) {
        this.iHttp = iHttp;
    }


    @Override
    public void postJson(Context context, String baseUrl, String url, String jsonStr, IHttpResultCallBack callBack) {
        iHttp.postJson(context,baseUrl,url, jsonStr, callBack);
    }

    @Override
    public void postForm(Context context, String baseUrl, String url, Map<String, String> map, IHttpResultCallBack callBack) {
        iHttp.postForm(context,baseUrl,url, map, callBack);
    }

    @Override
    public void get(Context context,String baseUrl,String url, Map<String,String> map, IHttpResultCallBack callBack) {
        iHttp.get(context,baseUrl,url, map, callBack);
    }
}
