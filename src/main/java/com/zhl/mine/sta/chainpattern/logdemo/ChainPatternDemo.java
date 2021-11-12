package com.zhl.mine.sta.chainpattern.logdemo;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2021/8/6 18:15
 */
public class ChainPatternDemo {

    private static AbstractLogger getChainOfLoggers(){
        ErrorLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        FileLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        ConsoleLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO,"This is an infomation");

        loggerChain.logMessage(AbstractLogger.DEBUG,"This is a debug level infomation");

        loggerChain.logMessage(AbstractLogger.ERROR,"This is an error infomation");
    }
}


