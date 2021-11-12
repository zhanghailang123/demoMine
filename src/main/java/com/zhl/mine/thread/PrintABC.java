package com.zhl.mine.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:启动三个线程分别打印ABC 问题 循环10次
 * @author: zhanghailang
 * @date: 2021/11/11 19:21
 */
public class PrintABC {

    private static int temp = 0;

    public static void main(String[] args) {
        reenLock();
    }



    //冷静 集中 专注 努力
    public static void reenLock() {
        //缺少一个控制线程本身运行的状态
        ReentrantLock lockA = new ReentrantLock();
//        ReentrantLock lockB = new ReentrantLock();
//        ReentrantLock lockC = new ReentrantLock();

        Condition conditionA = lockA.newCondition();
//        Condition conditionB = lockB.newCondition();
//        Condition conditionC = lockC.newCondition();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    lockA.lock();
                    while (temp != 0) {
                        conditionA.await();
                    }
                    System.out.println("A");
                    temp = 1;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    conditionA.signalAll();
                    lockA.unlock();
                }

            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    lockA.lock();
                    while (temp != 1) {
                        conditionA.await();
                    }
                    System.out.println("B");
                    temp = 2;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    conditionA.signalAll();
                    lockA.unlock();
                }

            }
        }).start();


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    lockA.lock();
                    while (temp != 2 ) {
                        conditionA.await();
                    }
                    System.out.println("C ");
                    //循环出去的条件
                    temp = 0;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    conditionA.signalAll();
                    lockA.unlock();
                }

            }
        }).start();
    }



    public void synLock(){
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