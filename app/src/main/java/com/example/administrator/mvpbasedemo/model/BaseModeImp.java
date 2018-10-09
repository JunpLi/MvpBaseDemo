package com.example.administrator.mvpbasedemo.model;

import android.content.Context;
import android.os.Handler;

import com.example.administrator.mvpbasedemo.bean.StudentBean;
import com.example.administrator.mvpbasedemo.model.interfaces.BaseModelListener;
import com.example.administrator.mvpbasedemo.model.interfaces.OnResultListener;
import com.example.administrator.mvpbasedemo.net.LekeObserver;
import com.example.administrator.mvpbasedemo.net.RxHttpUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ljp on 2018/9/7.
 * <p>
 *  公用mode用于网络请求，登录和学生都需要这个网络操作，参数不同
 */
public class BaseModeImp implements BaseModelListener {

    protected RxHttpUtils rxHttpUtils;

    public BaseModeImp(Context context) {
        rxHttpUtils = new RxHttpUtils(context);
    }

    @Override
    public void initHttpData(String paramStr, final OnResultListener onResultListener) {

        rxHttpUtils.getSearchStudnt(paramStr,"",0,1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new LekeObserver<StudentBean>() {
                    @Override
                    public void onSucced(StudentBean studentBean) {

                    }

                    @Override
                    public void onFailed(Throwable error) {

                    }
                });


//****************************************************************************************8
        new Handler().postDelayed(new Runnable(){
            public void run() {
                onResultListener.onSucuss("公用数据请求完毕");
            }
        }, 3000);
    }
}
