package com.example.administrator.mvpbasedemo.view.interfaces;


/**
 * Created by ljp on 2016/8/27.
 */
public interface StudentActivityViewListener extends BaseViewListener {


    /**
     * 开始网络请求
     */
    void startStudentHttpRequest();
    /**
     * 网络请求成功
     */
    void doSucess(String result);

}
