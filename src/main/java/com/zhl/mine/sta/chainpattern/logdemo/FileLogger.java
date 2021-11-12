package com.zhl.mine.sta.chainpattern.logdemo;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2021/8/6 18:13
 */
public class FileLogger extends AbstractLogger{

    public FileLogger(int level) {
        this.level = level;
    }


    @Override
    protected void write(String message) {
        System.out.println("File:: Logger:" + message);
    }
}