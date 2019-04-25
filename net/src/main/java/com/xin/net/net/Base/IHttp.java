package com.xin.net.net.Base;

import android.app.Activity;
import android.content.Context;

import java.util.Map;

/**
 * Created by admin on 2019/3/20.
 */

public interface IHttp {

    /**
     *
     * 提交JSON post
     *
     * @param url 请求地址
     * @param jsonStr 参数
     * @param callBack 请求回调
     */
    void postJson(Context context, String baseUrl, String url, String jsonStr, IHttpResultCallBack callBack);

    /**
     *
     * 提交表单 post
     *
     * @param url 请求地址
     * @param map 参数
     * @param callBack 请求回调
     */
    void postForm(Context context, String baseUrl, String url, Map<String,String> map, IHttpResultCallBack callBack);

    /**
     *
     * @param url 请求地址
     * @param map 参数
     * @param callBack 请求回调
     */
    void get(Context context,String baseUrl,String url, Map<String,String> map, IHttpResultCallBack callBack);

}
