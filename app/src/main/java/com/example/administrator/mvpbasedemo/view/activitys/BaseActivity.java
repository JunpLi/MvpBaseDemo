package com.example.administrator.mvpbasedemo.view.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.administrator.mvpbasedemo.presenter.BasePresenter;
import com.example.administrator.mvpbasedemo.view.interfaces.BaseViewListener;
import com.example.administrator.mvpbasedemo.view.view.LekeProgressDialog;

/**
 * Created by ljp on 2018/9/6
 * <p>
 * activity 基类
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    protected T mPresenter;
    private LekeProgressDialog mLekeProgressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mLekeProgressDialog = new LekeProgressDialog(this);
        Log.i("TAG","TTT--------------------："+"BaseActivity");
        mPresenter.attach((BaseViewListener) this);// 这里的this代表继承BaseActivity的上下问，eg:LoginActivity上下问
    }


    public void showDialog() {
        if (mLekeProgressDialog == null) {
            mLekeProgressDialog = new LekeProgressDialog(this);
        }
        mLekeProgressDialog.show();
    }

    public void dissMissDialog() {
        if (mLekeProgressDialog != null) {
            mLekeProgressDialog.dismiss();
        }
        mLekeProgressDialog = null;
    }

    protected abstract T createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.deAttach();
        dissMissDialog();
    }
}
