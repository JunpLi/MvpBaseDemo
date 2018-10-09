package com.example.administrator.mvpbasedemo.model.interfaces;


/**
 * Created by ljp on 2016/8/27.
 * 登录activty自己的请求接口
 */
public interface LoginModelListener {

    void initLoginHttpRequest(String request, OnResultListener listener);

}
