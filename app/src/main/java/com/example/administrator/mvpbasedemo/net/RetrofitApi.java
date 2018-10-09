package com.example.administrator.mvpbasedemo.net;

import com.example.administrator.mvpbasedemo.bean.StudentBean;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ljp on 2018/9/12.
 * <p>
 * Retrofit 接口
 */
public interface RetrofitApi {

    String API = "https://api.douban.com/v2/";//api地址

    @GET("book/search")
    Observable<StudentBean> getSearchStudent(@Query("q") String name,
                                          @Query("tag") String tag, @Query("start") int start,
                                          @Query("count") int count);

}
