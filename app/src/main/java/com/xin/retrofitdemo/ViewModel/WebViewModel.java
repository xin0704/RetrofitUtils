package com.xin.retrofitdemo.ViewModel;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * Created by admin on 2019/4/26.
 */

public class WebViewModel extends BaseViewModel {

    public ObservableField<String> url = new ObservableField<>();

    public WebViewModel(@NonNull Application application) {
        super(application);
    }
}
