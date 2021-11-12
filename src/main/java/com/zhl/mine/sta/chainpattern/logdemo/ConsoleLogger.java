package com.zhl.mine.sta.chainpattern.logdemo;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2021/8/6 18:03
 */
public class ConsoleLogger extends AbstractLogger{

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console:: Logger:" + message);
    }
}