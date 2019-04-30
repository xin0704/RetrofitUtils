package com.xin.retrofitdemo.Base;

import android.content.Context;

/**
 * Created by admin on 2019/4/28.
 */

public class Util {

    private static Util util;

    public static Util getInstance(){
        if (util == null){
            synchronized(Util.class){
                if (util == null){
                    util = new Util();
                }
            }
        }
        return util;
    }

    public void loadData(Context context){
        //此方法中使用context
    }

}
