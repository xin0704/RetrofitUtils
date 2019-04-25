package com.xin.net.Util.Log;

import com.xin.net.Util.Config.Config;


public class Logger
{
    public static void i(String tag, Object object)
    {
        if (Config.DEBUG) android.util.Log.i(tag, "" + object);
    }

    public static void e(String tag, Object object)
    {
        if (Config.DEBUG) android.util.Log.e(tag, "" + object);
    }

    public static void v(String tag, Object object)
    {
        if (Config.DEBUG) android.util.Log.v(tag, "" + object);
    }

    public static void w(String tag, Object object)
    {
        if (Config.DEBUG) android.util.Log.w(tag, "" + object);
    }

    public static void d(String tag, Object object)
    {
        if (Config.DEBUG) android.util.Log.d(tag, "" + object);
    }
}
