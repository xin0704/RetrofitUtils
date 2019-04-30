package com.xin.retrofitdemo.ViewModel;

import android.app.Application;
import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.xin.net.Util.Log.Logger;
import com.xin.net.net.Base.IHttpResultCallBack;
import com.xin.net.net.Base.ProxyFactory;
import com.xin.retrofitdemo.BR;
import com.xin.retrofitdemo.Constants;
import com.xin.retrofitdemo.Entity.News;
import com.xin.retrofitdemo.R;

import java.util.HashMap;
import java.util.Map;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * Created by admin on 2019/4/26.
 */

public class MainViewModel extends BaseViewModel {

    //item数据适配器
    public BindingRecyclerViewAdapter<ItemNewsModel> adapter = new BindingRecyclerViewAdapter();
    //绑定item
    public ItemBinding<ItemNewsModel> itemBinding = ItemBinding.of(BR.itemNewsModel, R.layout.item_news);
    //item数据列表
    public ObservableList<ItemNewsModel> observableList = new ObservableArrayList<>();
    //UI变更监听
    public UiChangeObservable uiChangeObservable = new UiChangeObservable();

    //UI变更观察者
    public class UiChangeObservable {

        //结束下拉刷新
        public ObservableBoolean finishRefresh = new ObservableBoolean(false);
        //结束上拉加载更多
        public ObservableBoolean finishLoadMore = new ObservableBoolean(false);

    }


    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public BindingCommand onRefreshListener = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            Logger.d("=========", "onRefresh");
            uiChangeObservable.finishRefresh.set(!uiChangeObservable.finishRefresh.get());
        }
    });

    public BindingCommand onLoadMoreListener = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            Logger.d("=========", "onLoadMore");
            uiChangeObservable.finishLoadMore.set(!uiChangeObservable.finishLoadMore.get());
        }
    });

    public void loadData(Context context) {

        Map<String, String> map = new HashMap<>();
        map.put("key", "f6e3e8a5f764e04f8388acbfb85db437");
        map.put("type", "top");

        ProxyFactory.obtain()
                .postForm(context, Constants.BASE_URL, Constants.URL, map, new IHttpResultCallBack() {
                    @Override
                    public void onSuccess(String data) {

                        News news = new Gson().fromJson(data, News.class);

                        for (int i = 0; i < news.getData().size(); i++) {
                            observableList.add( new ItemNewsModel(news.getData().get(i),MainViewModel.this));
                        }
                        Logger.d("=====", news.getData().get(0).getTitle());
                    }

                    @Override
                    public void onError(String msg) {
                        Logger.d("=====", msg);
                    }
                });

    }
}
