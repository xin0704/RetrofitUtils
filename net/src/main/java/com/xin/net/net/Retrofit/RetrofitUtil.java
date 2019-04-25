package com.xin.net.net.Retrofit;

import android.content.Context;

import com.google.gson.Gson;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.xin.net.Entity.Result;
import com.xin.net.net.Base.IHttp;
import com.xin.net.net.Base.IHttpResultCallBack;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by admin on 2019/4/24.
 */

public class RetrofitUtil implements IHttp {

    private final MediaType JSON = MediaType.parse("application/json,utf-8");


    @Override
    public void postJson(Context context, String baseUrl, String url, String jsonStr, final IHttpResultCallBack callBack) {

        RxAppCompatActivity activity = (RxAppCompatActivity) context;

        RequestBody body = RequestBody.create(JSON, jsonStr);

        RetrofitFactory.obtain()
                .createService(context, baseUrl, ApiService.class)
                .loadData(url, body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.<Result<Object>>bindToLifecycle())
                .subscribe(new CustomObserver<Object>() {
                    @Override
                    public void onSuccess(Object data) {
                        if (callBack != null){
                            callBack.onSuccess(new Gson().toJson(data));
                        }
                    }

                    @Override
                    public void onError(String err_msg) {

                        if (callBack != null){
                            callBack.onError(err_msg);
                        }
                    }
                });

    }

    @Override
    public void postForm(Context context, String baseUrl, String url, Map<String, String> map, final IHttpResultCallBack callBack) {

        RxAppCompatActivity activity = (RxAppCompatActivity) context;

        RetrofitFactory.obtain()
                .createService(context, baseUrl, ApiService.class)
                .loadData(url, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.<Result<Object>>bindToLifecycle())
                .subscribe(new CustomObserver<Object>() {
                    @Override
                    public void onSuccess(Object data) {
                        if (callBack != null){
                            callBack.onSuccess(new Gson().toJson(data));
                        }
                    }

                    @Override
                    public void onError(String err_msg) {
                        if (callBack != null){
                            callBack.onError(err_msg);
                        }
                    }
                });

    }

    @Override
    public void get(Context context, String baseUrl, String url, Map<String, String> map, final IHttpResultCallBack callBack) {

        RxAppCompatActivity activity = (RxAppCompatActivity) context;

        RetrofitFactory.obtain()
                .createService(context, baseUrl, ApiService.class)
                .getData(url, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.<Result<Object>>bindToLifecycle())
                .subscribe(new CustomObserver<Object>() {
                    @Override
                    public void onSuccess(Object data) {
                        if (callBack != null){
                            callBack.onSuccess(new Gson().toJson(data));
                        }
                    }

                    @Override
                    public void onError(String err_msg) {
                        if (callBack != null){
                            callBack.onError(err_msg);
                        }
                    }
                });

    }
}
