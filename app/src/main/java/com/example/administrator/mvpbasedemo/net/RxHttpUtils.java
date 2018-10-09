package com.example.administrator.mvpbasedemo.net;

import android.content.Context;

import com.example.administrator.mvpbasedemo.bean.StudentBean;

import rx.Observable;

/**
 * Created by ljp on 2018/9/12.
 * <p>
 * 网络操作工具类
 */
public class RxHttpUtils {

    private RetrofitApi mRetrofitService;

    public RxHttpUtils(Context context) {
        this.mRetrofitService = RetrofitHelper.getInstance(context).getRetrofitService();
    }

    public Observable<StudentBean> getSearchStudnt(String name, String tag, int start, int count) {
        return mRetrofitService.getSearchStudent(name, tag, start, count);
    }

}
