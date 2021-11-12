package com.zhl.mine.sta.chainpattern.logdemo;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2021/8/6 18:11
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console:: Logger:" + message);
    }
}