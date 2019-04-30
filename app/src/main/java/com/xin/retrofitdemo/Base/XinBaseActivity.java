package com.xin.retrofitdemo.Base;

import android.databinding.ViewDataBinding;
import android.os.Bundle;

import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * Created by admin on 2019/4/26.
 */

public abstract class XinBaseActivity<V extends ViewDataBinding,VM extends BaseViewModel> extends BaseActivity<V,VM>{

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return setContentView(savedInstanceState);
    }

    @Override
    public int initVariableId() {
        return setVariableId();
    }


    /**
     * 初始化根布局
     *
     * @return 布局layout的id
     */
    public abstract int setContentView(Bundle savedInstanceState);

    /**
     * 初始化ViewModel的id
     *
     * @return BR的id
     */
    public abstract int setVariableId();


}
