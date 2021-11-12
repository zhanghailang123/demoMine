package com.zhl.mine.thread;

/**
 * @description:启动三个线程分别打印ABC 问题 循环10次
 * @author: zhanghailang
 * @date: 2021/11/11 19:21
 */
public class PrintABC {


    public static void main(String[] args) {

        //此处完全不对 得用同一把锁
        Object lockA = new Object();

        Object lockB = new Object();

        Object lockC = new Object();


        Thread threadA = new Thread(() -> {
            synchronized (lockA) {
                for (int i = 0; i < 10; i++) {
                    System.out.println("A");
                    try {
                        lockA.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lockB.notify();
                }

            }

        });

        Thread threadB = new Thread(() -> {
            synchronized (lockB) {
                for (int i = 0; i < 10; i++) {
                    System.out.println("B");
                    try {
                        lockB.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lockC.notify();
                }
            }
        });

        Thread threadC = new Thread(() -> {
            synchronized (lockC) {
                for (int i = 0; i < 10; i++) {
                    System.out.println("C ");
                    try {
                        lockC.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lockA.notify();
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }
}