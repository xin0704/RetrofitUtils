package com.xin.retrofitdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.xin.net.Util.Log.Logger;
import com.xin.net.net.Base.IHttpResultCallBack;
import com.xin.net.net.Base.ProxyFactory;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends RxAppCompatActivity implements View.OnClickListener{

    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTv = findViewById(R.id.tv);

    }

    @Override
    public void onClick(View v) {

        Map<String,String> map = new HashMap<>();
        map.put("key","f6e3e8a5f764e04f8388acbfb85db437");
        map.put("type","top");

        ProxyFactory.obtain()
                .postForm(this, Constants.BASE_URL, Constants.URL, map, new IHttpResultCallBack() {
                    @Override
                    public void onSuccess(String data) {

                        News news = new Gson().fromJson(data,News.class);

                        mTv.setText(news.getData().get(0).getTitle());

                        Logger.d("=====",news.getData().get(0).getTitle());
                    }

                    @Override
                    public void onError(String msg) {
                        Logger.d("=====",msg);
                    }
                });

    }
}
