package com.example.administrator.mvpbasedemo.model;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.example.administrator.mvpbasedemo.model.interfaces.LoginModelListener;
import com.example.administrator.mvpbasedemo.model.interfaces.OnResultListener;


/**
 * Created by ljp on 2018/8/27.
 * 登录model
 */
public class LoginActivityModelImp extends BaseModeImp implements LoginModelListener {


    public LoginActivityModelImp(Context context) {
        super(context);
    }

    @Override
    public void initLoginHttpRequest(String request, OnResultListener listener) {
        Log.i("TAG","我是登录界面");
    }
}
