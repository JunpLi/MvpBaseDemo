package com.example.administrator.mvpbasedemo.model;

import android.content.Context;
import android.util.Log;
import com.example.administrator.mvpbasedemo.model.interfaces.OnResultListener;
import com.example.administrator.mvpbasedemo.model.interfaces.StudentModelListener;


/**
 * Created by ljp on 2016/8/27.
 * 学生model
 */
public class StudentActivityModelImp extends BaseModeImp implements StudentModelListener {


    public StudentActivityModelImp(Context context){
       super(context);
    }

    @Override
    public void initStudentHttpRequest(String request, final OnResultListener listener) {
        Log.i("TAG","我是学生界面");
    }

}
