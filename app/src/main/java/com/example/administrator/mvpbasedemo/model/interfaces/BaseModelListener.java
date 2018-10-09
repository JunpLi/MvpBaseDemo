package com.example.administrator.mvpbasedemo.model.interfaces;

/**
 * Created by Real_Man on 2016/8/27
 * <p>
 * 负责model和present交流的父类接口
 */
public interface BaseModelListener {

    void initHttpData(String paramStr, OnResultListener onResultListener);//TODO 请求网络数据
}
