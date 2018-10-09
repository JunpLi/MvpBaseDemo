package com.example.administrator.mvpbasedemo.presenter;

import android.content.Context;

import com.example.administrator.mvpbasedemo.model.LoginActivityModelImp;
import com.example.administrator.mvpbasedemo.model.interfaces.OnResultListener;
import com.example.administrator.mvpbasedemo.view.interfaces.LoginActivityViewListener;

/**
 * Created by ljp on 2018/9/6.
 * <p>
 * 第一个activity对应的present，集体逻辑操作放在这里,LoginActivityViewListener是接口生命的类型，具体实现
 */

public class LoginActivtiyPresent extends BasePresenter<LoginActivityViewListener, LoginActivityModelImp> {

    /**
     * activity也就是对应的view需要的方法
     */
    public void initLoginHttpData() {
        getView().startHttpRequest();
        mModel.initHttpData(getView().getTextViewData(), new OnResultListener() {
            @Override
            public void onSucuss(final String result) {
                getView().doSucess("数据已拿到");
            }

            @Override
            public void onFail() {

            }
        });
    }


    @Override
    protected LoginActivityModelImp getModel() {
        return new LoginActivityModelImp((Context) getView());
    }
}
