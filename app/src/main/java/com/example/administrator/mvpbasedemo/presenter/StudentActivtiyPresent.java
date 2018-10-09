package com.example.administrator.mvpbasedemo.presenter;

import android.content.Context;

import com.example.administrator.mvpbasedemo.model.StudentActivityModelImp;
import com.example.administrator.mvpbasedemo.model.interfaces.OnResultListener;
import com.example.administrator.mvpbasedemo.view.interfaces.StudentActivityViewListener;

/**
 * Created by ljp on 2018/9/6.
 * <p>
 *  第一个activity对应的present，集体逻辑操作放在这里
 */
public class StudentActivtiyPresent extends BasePresenter<StudentActivityViewListener,StudentActivityModelImp> {


    /**
     * activity也就是对应的view需要的方法
     */
    public void initStudentHttpData(String jsonStr){
        getView().startStudentHttpRequest();

        mModel.initHttpData("", new OnResultListener() {
            @Override
            public void onSucuss(final String result) {
                getView().doSucess("数据已拿到");
            }

            @Override
            public void onFail() {

            }
        });

        mModel.initStudentHttpRequest(jsonStr, new OnResultListener() {
            @Override
            public void onSucuss(String aaaa) {

            }

            @Override
            public void onFail() {

            }
        });

    }


    @Override
    protected StudentActivityModelImp getModel() {
        return new StudentActivityModelImp((Context) getView());
    }
}
