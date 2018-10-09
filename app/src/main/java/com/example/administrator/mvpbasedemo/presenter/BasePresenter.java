package com.example.administrator.mvpbasedemo.presenter;

import android.util.Log;

import com.example.administrator.mvpbasedemo.model.interfaces.BaseModelListener;
import com.example.administrator.mvpbasedemo.view.interfaces.BaseViewListener;

import java.lang.ref.WeakReference;

/**
 * Created by ljp on 2018/9/6.
 * <p>
 * present 基类
 */
public abstract class BasePresenter<T extends BaseViewListener, M extends BaseModelListener> {

    private WeakReference<T> weakReference;
    protected M mModel;

    /**
     * @param t 对的activity上下午对象，具体activtiy（view）实现了不同的接口，进行回调对应接口方法时候用到（接口子类对象类对象调用接口方法），
     *          activty退出了，某个接口进网络操作，存在对当前上下午引用，存在内存泄漏，使用WeakReference解决。
     */
    public void attach(T t) {
        Log.i("TAG","TTT--------------------："+"BasePresenter===attach");
        weakReference = new WeakReference<>(t);
        mModel = getModel();
    }


    /**
     * deAttach方法主要是当view向presenter请求数据时，由于网络请求时间过长，而view直接销毁了，而presenter没有即使返回数据，则deAttach就会把对应的view取消关联
     */
    public void deAttach() {
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
    }

    /**
     * isViewAttached方法判断view与presente是否关联
     */
    public boolean isViewAttached() {
        return weakReference != null && weakReference.get() != null;
    }

    /**
     * @return getView是返回一个绑定好的view对象
     */
    public T getView() {
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /**
     * getModel方法则是让具体的presenter子类去创建具体的model对象
     */
    protected abstract M getModel();
}
