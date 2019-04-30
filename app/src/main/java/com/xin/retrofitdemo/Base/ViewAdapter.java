package com.xin.retrofitdemo.Base;

import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import me.goldze.mvvmhabit.binding.command.BindingCommand;

/**
 * Created by admin on 2019/4/26.
 */

public class ViewAdapter {

    @BindingAdapter(value = {"onRefreshListener", "onLoadMoreListener"}, requireAll = false)
    public static void bindRefreshAndLoadMore(SmartRefreshLayout layout, final BindingCommand refreshCommand, final BindingCommand loadMoreCommand) {

        layout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                if (refreshCommand != null){
                    refreshCommand.execute();
                }
            }
        });

        layout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                if (loadMoreCommand != null){
                    loadMoreCommand.execute();
                }
            }
        });

    }

    @BindingAdapter(value = {"onClickListener", "onLongClickListener"}, requireAll = false)
    public static void bindLinearLayout(LinearLayout layout, final BindingCommand clickCommand, final BindingCommand longClickCommand) {

      layout.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              if (clickCommand != null){
                  clickCommand.execute();
              }
          }
      });

      layout.setOnLongClickListener(new View.OnLongClickListener() {
          @Override
          public boolean onLongClick(View v) {
              if (longClickCommand != null){
                  longClickCommand.execute();
              }
              return true;
          }
      });
    }

    @BindingAdapter({"web_url"})
    public static void bindWebView(WebView webView, final String url) {
        if (!TextUtils.isEmpty(url)) {
            webView.loadUrl(url);
        }
    }

}
