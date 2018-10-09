package com.example.administrator.mvpbasedemo.net;


import rx.Observer;

/**
 * 业务规范的观察者
 * Created by ljp on 2018/9/12.
 **/

public abstract class LekeObserver<T> implements Observer<T> {


    public abstract void onSucced(T t);

    public abstract void onFailed(Throwable error);


    @Override
    public void onNext(T t) {
        onSucced(t);
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        onFailed(e);
    }
}
