package com.zhl.mine.thread;

import cn.hutool.core.thread.NamedThreadFactory;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import org.apache.tomcat.util.buf.StringUtils;

import java.math.BigDecimal;
import java.util.concurrent.*;

/**
 * @description: ThreadLocal学习
 * @author: zhanghailang
 * @date: 2021/9/9 10:12
 */
public class ZhlThreadLocal {

    /**
     * ThreadLocal的用途 为每个线程都保存有个副本变量
     * 为每个线程都保存有个副本变量
     * 为每个线程都保存一个副本变量
     * My Goal
     * Go to Get it Just Keep this
     * My Goal
     * My Goal
     * My Goal
     * Is To Do What
     * Did You Go To It
     */
    private static final ThreadLocal<String> threadLocalName = ThreadLocal.withInitial(() -> {
        return "zhl";
    });

    public static void main(String[] args) {
//        for (int i = 0; i < 5; i++) {
//            new Thread(() -> {
//                System.out.println("threadName : " + threadLocalName.get());
//            }).start();
//        }

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 5, 50, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5));
        Future future = executor.submit(() ->{
            Thread.interrupted();
            System.out.println("中断前的状态" + Thread.interrupted());
            Thread.currentThread().interrupt();
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("中断后的状态1" + Thread.interrupted());
            System.out.println("中断后的状态2" + Thread.interrupted());
            System.out.println("这是test");
            System.out.println(Thread.currentThread().getName());
        });
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
//        NamedThreadFactory;
//        ResizeableCapacityLinkedBlockingQueue

        BigDecimal test = BigDecimal.valueOf(-1.1);
        System.out.println(test.intValue() > 0);
        //如何中断一个线程
        Thread.interrupted();
        System.out.println(Thread.currentThread().isInterrupted());
        System.out.println(Thread.currentThread().getName());
        String test111 = "0.00";
        System.out.println(NumberUtil.isNumber(test111) + "测试Double");
        BigDecimal test222 = BigDecimal.valueOf(Double.parseDouble(test111));
        System.out.println(test222.doubleValue() <= 0d);
        //认真复盘下三期哪里做的不够好 函数拆分的细一点 高频表的查询！
        //以敬畏之心对待自己写的每一行代码
//        CompletableFuture.runAsync();
//        CompletableFuture.supplyAsync();

    }
}