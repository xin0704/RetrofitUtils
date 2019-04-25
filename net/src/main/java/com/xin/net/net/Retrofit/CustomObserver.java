package com.xin.net.net.Retrofit;

import android.text.TextUtils;

import com.xin.net.Entity.Result;
import com.xin.net.Util.Config.Config;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by admin on 2019/4/24.
 */

public abstract class CustomObserver<T> implements Observer<Result<T>> {

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(Result<T> tResult) {

        if (tResult != null){
           if (Config.SUCCESS_CODE == tResult.getError_code()){
               onSuccess(tResult.getResult());
           }else {
               onError(TextUtils.isEmpty(tResult.getReason()) ? "请求数据失败" : tResult.getReason());
           }
        }

    }

    @Override
    public void onError(Throwable e) {

        onError(e.toString());

    }

    @Override
    public void onComplete() {

    }

    public abstract void onSuccess(T data);

    public abstract void onError(String err_msg);
}
