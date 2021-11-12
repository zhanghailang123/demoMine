package com.zhl.mine.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @description:如果一个线程池中的线程异常了，那么线程池会怎么处理这个线程
 * 线程池里面的任务分为
 * IO密集型和计算密集型
 * 我认为线程池讲解比较好的文章
 * https://cloud.tencent.com/developer/article/1585842
 * @author: zhanghailang
 * @date: 2021/11/9 17:39
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            Thread.currentThread().setName("ZHL---1");
            System.out.println(String.format("这是一个线程:%s",Thread.currentThread().getName()));
        });

        Future<?> future = executorService.submit(() -> {
//            Thread.currentThread().setName("ZHL---1");
            System.out.println(String.format("这是一个线程:%s",Thread.currentThread().getName()));
            throw new RuntimeException("测试线程抛出异常");
        });

        System.out.println("主线程运行完了");
    }
}