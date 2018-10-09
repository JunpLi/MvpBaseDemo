package com.example.administrator.mvpbasedemo.model.interfaces;

/**
 * Created by ljp on 2016/8/27.
 * 网络请求回调方法
 */
public interface OnResultListener {

    void onSucuss(String result);//请求成功
    void onFail();//请求失败

}
