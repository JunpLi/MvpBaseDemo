package com.example.administrator.mvpbasedemo.view.interfaces;


/**
 * Created by ljp on 2016/8/27.
 */
public interface LoginActivityViewListener extends BaseViewListener {


    /**
     * 返回view数据
     */
    String getTextViewData();

    /**
     * 开始网络请求
     */
    void startHttpRequest();

    /**
     * 网络请求成功
     */
    void doSucess(String result);

}
