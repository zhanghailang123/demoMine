package com.zhl.mine.sta.chainpattern;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2021/8/6 11:03
 */
public abstract class AbstractDataHandeler<T> {
    protected abstract T doRequest(String query) throws Exception;
}