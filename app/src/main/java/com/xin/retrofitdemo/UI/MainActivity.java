package com.xin.retrofitdemo.UI;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.Observable;
import android.os.Bundle;

import com.xin.retrofitdemo.BR;
import com.xin.retrofitdemo.Base.XinBaseActivity;
import com.xin.retrofitdemo.ViewModel.MainViewModel;
import com.xin.retrofitdemo.R;
import com.xin.retrofitdemo.databinding.ActivityMainBinding;

public class MainActivity extends XinBaseActivity<ActivityMainBinding, MainViewModel> {

    @Override
    public int setContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public int setVariableId() {
        return BR.mainViewModel;
    }

    @Override
    public MainViewModel initViewModel() {
        return ViewModelProviders.of(this).get(MainViewModel.class);
    }

    @Override
    public void initData() {
        super.initData();
        //加载数据
        viewModel.loadData(this);
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();

        //监听下拉刷新完成
        viewModel.uiChangeObservable.finishRefresh.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                //设置下拉刷新结束
                binding.refreshLayout.finishRefresh();
            }
        });
        //监听上拉加载完成
        viewModel.uiChangeObservable.finishLoadMore.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                //设置上拉加载结束
                binding.refreshLayout.finishLoadMore();
            }
        });

    }

}
