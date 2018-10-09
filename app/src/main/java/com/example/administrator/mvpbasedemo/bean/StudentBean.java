package com.example.administrator.mvpbasedemo.bean;

import java.io.Serializable;

/**
 * Created by ljp on 2018/9/12.
 * <p>
 */
public class StudentBean implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
