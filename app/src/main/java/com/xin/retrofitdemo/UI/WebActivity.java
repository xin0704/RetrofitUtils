package com.xin.retrofitdemo.UI;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import com.xin.retrofitdemo.BR;
import com.xin.retrofitdemo.Base.XinBaseActivity;
import com.xin.retrofitdemo.R;
import com.xin.retrofitdemo.ViewModel.WebViewModel;
import com.xin.retrofitdemo.databinding.ActivityWebBinding;

public class WebActivity extends XinBaseActivity<ActivityWebBinding, WebViewModel>{

    private String url;

    @Override
    public void initParam() {
        super.initParam();
        url = getIntent().getStringExtra("url");
    }

    @Override
    public int setContentView(Bundle savedInstanceState) {
        return R.layout.activity_web;
    }

    @Override
    public int setVariableId() {
        return BR.webViewModel;
    }

    @Override
    public WebViewModel initViewModel() {
        return ViewModelProviders.of(this).get(WebViewModel.class);
    }

    @Override
    public void initData() {
        super.initData();
        viewModel.url.set(url);
    }
}
