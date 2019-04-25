package com.xin.net.net.Retrofit;

import com.xin.net.Cache.Header.CacheHeaders;
import com.xin.net.Entity.Result;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by admin on 2019/4/24.
 */

public interface ApiService {


    @Headers(CacheHeaders.NORMAL)
    @POST("{url}")
    Observable<Result<Object>> loadData(@Path("url") String url,
                                        @Body RequestBody body);

    @Headers(CacheHeaders.NORMAL)
    @FormUrlEncoded
    @POST("{url}")
    Observable<Result<Object>> loadData(@Path("url") String url,
                                        @FieldMap Map<String, String> map);

    @Headers(CacheHeaders.NORMAL)
    @GET("{url}")
    Observable<Result<Object>> getData(@Path("url") String url,
                                       @QueryMap Map<String, String> map);

}
