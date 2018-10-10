package com.example.administrator.mvpbasedemo.view.activitys;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.mvpbasedemo.R;
import com.example.administrator.mvpbasedemo.presenter.LoginActivtiyPresent;
import com.example.administrator.mvpbasedemo.view.interfaces.LoginActivityViewListener;


/**
 * Created by ljp on 2018/9/6
 * <p>
 */
public class LoginActivity extends BaseActivity<LoginActivityViewListener,LoginActivtiyPresent> implements LoginActivityViewListener {

    private TextView mTv;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTv = findViewById(R.id.mTv);
        mButton = findViewById(R.id.btn);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTv.setText("");
                mPresenter.initLoginHttpData();
            }
        });
    }

    @Override
    protected LoginActivtiyPresent createPresenter() {
        return new LoginActivtiyPresent();
    }

    @Override
    protected LoginActivityViewListener getIView() {
        return this;
    }


    @Override
    public String getTextViewData() {
        return mTv.getText().toString();
    }

    @Override
    public void startHttpRequest() {
        showDialog();
    }

    @Override
    public void doSucess(String result) {
        mTv.setText(result);
        dissMissDialog();
        startActivity(new Intent(this,StudentActivity.class));
    }
}
