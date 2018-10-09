package com.example.administrator.mvpbasedemo.model.interfaces;


/**
 * Created by ljp on 2016/8/27.
 * 学生activity特有接口
 */
public interface StudentModelListener{
    void initStudentHttpRequest(String request, OnResultListener listener);
}
