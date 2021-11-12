package com.zhl.mine.sta.syncronized;

import org.springframework.util.Assert;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @description: 测试Syncronized的使用
 * https://mp.weixin.qq.com/s/7DTk5CV5FSOsa5fSN_V26w
 * 使用Syncronized加锁时
 * @author: zhanghailang
 * @date: 2021/8/24 10:27
 */
public class SyncronizedExample {

    public static void main(String[] args) {

        /**
         *  代码块使用this 不同对象使用的是不同的锁
         *  只有同一个对象会使用同一把锁
         *
         *  This修饰的是当前对象
         */
        for (int i = 0; i < 5; i++) {
            new Thread(() ->{
                SyncronizedExample example = new SyncronizedExample();
                try {
                    example.thisMethod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        SyncronizedExample example2 = new SyncronizedExample();

        for (int i = 0; i < 5; i++) {
            new Thread(() ->{
                try {
                    example2.thisMethod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        String testAssert = null;
        Assert.notNull(testAssert,"testAssert 不可以为 null！");

    }


    public void thisMethod() throws InterruptedException {
        /**
         * 修饰普通方法、静态方法、代码块
         * 1.修饰普通方法
         *   该修饰方法被称为同步方法，其作用范围是整个方法，作用对象是调用这个方法的对象
         * 2.修饰静态方法
         *   其作用范围是整个方法，作用对象是调用这个类的所有对象
         */
        synchronized (this){
            System.out.println(String.format("当前执行线程：%s，执行时间: %s",Thread.currentThread().getName(),new Date()));
            TimeUnit.SECONDS.sleep(1);
        }
    }
}