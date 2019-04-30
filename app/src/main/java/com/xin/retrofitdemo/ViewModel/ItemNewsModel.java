package com.xin.retrofitdemo.ViewModel;

import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.xin.retrofitdemo.Entity.News;
import com.xin.retrofitdemo.UI.WebActivity;

import me.goldze.mvvmhabit.base.ItemViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

/**
 * Created by admin on 2019/4/26.
 */

public class ItemNewsModel extends ItemViewModel<MainViewModel> {

    public ObservableField<News.Data> news = new ObservableField<>();

    public ItemNewsModel(News.Data data, @NonNull MainViewModel viewModel) {
        super(viewModel);
        news.set(data);
    }

    public BindingCommand itemClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {

            Bundle bundle = new Bundle();
            bundle.putString("url", news.get().getUrl());

            viewModel.startActivity(WebActivity.class, bundle);
        }
    });

}
