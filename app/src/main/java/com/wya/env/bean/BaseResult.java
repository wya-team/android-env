package com.wya.env.bean;

/**
 * Created by Administrator on 2018/7/3 0003.
 */

public class BaseResult<T> {
    public int status;
    public String msg;
    public T data;
}
