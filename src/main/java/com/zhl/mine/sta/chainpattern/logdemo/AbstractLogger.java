package com.zhl.mine.sta.chainpattern.logdemo;

/**
 * @description: 责任链抽象实例二：日志不同级别的打印
 * @author: zhanghailang
 * @date: 2021/8/6 17:55
 */
public abstract class AbstractLogger {

    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;
    /**
     * 责任链中的下一个元素
     */
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger){
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level,String message){
        if (this.level <= level){
            write(message);
        }
        if (nextLogger != null){
            nextLogger.logMessage(level,message);
        }
    }

    abstract protected void write(String message);
}