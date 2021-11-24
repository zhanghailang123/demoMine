package com.zhl.mine.lock;

/**
 * @description:可以说是更轻量级的Synchronized
 * 已经看过很多次了 今天没啥事 再看一次吧
 * 能保证可见性 但是保证不了原子性
 * 那可见性还有什么用呢？
 * Java线程内存模型确保所有线程看到这个变量的值是一致的
 * @author: zhanghailang
 * @date: 2021/11/12 15:04
 */
public class VolatileTest {
    private static volatile int i = 0;

    private static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        test2();
//        testVola1()
        Integer integer = new Integer(10);
    }

    public static void test2() {
        new Thread(() -> {
            while (flag){
                //
            }
            System.out.println("跳出循环了");
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = false;
            System.out.println("标志位已经变为true了");
        }).start();

        while (flag){
            //
        }
        System.out.println("跳出循环了");
    }







    // 冷静集中专注努力 Java中所使用的并发机制都是基于JVM的实现和CPU的指令 Know Who You Are
    // 现在勇敢一些 老了就不会后悔了 千万别让自己遗憾后悔了
    //HTTPS = HTTP + SSL/TLS ji
    public static void testVola1() {
        new Thread(() -> {
            for (int j = 0; j < 30000; j++) {
                //这本质并不是一个原子操作
                i++;
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }).start();

        new Thread(() -> {
            for (int j = 0; j < 30000; j++) {
                i++;
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }).start();

        new Thread(() -> {
            for (int j = 0; j < 30000; j++) {
                i++;
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }).start();

        new Thread(() -> {
            for (int j = 0; j < 10000; j++) {
                i++;
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }).start();
    }
}