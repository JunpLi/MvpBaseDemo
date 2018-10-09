package com.example.administrator.mvpbasedemo.view.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.mvpbasedemo.R;
import com.example.administrator.mvpbasedemo.presenter.StudentActivtiyPresent;
import com.example.administrator.mvpbasedemo.view.interfaces.StudentActivityViewListener;

public class StudentActivity extends BaseActivity<StudentActivtiyPresent> implements StudentActivityViewListener {

    private TextView mTv;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        mButton = findViewById(R.id.btn_student);
        mTv = findViewById(R.id.tv_student);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.initStudentHttpData("");
            }
        });
    }

    @Override
    protected StudentActivtiyPresent createPresenter() {
        return new StudentActivtiyPresent();
    }

    @Override
    public void startStudentHttpRequest() {
        showDialog();
    }

    @Override
    public void doSucess(String result) {
        mTv.setText("学生界面请求成功");
        dissMissDialog();
    }
}
