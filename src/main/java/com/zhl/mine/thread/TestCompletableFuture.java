package com.zhl.mine.thread;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2021/10/29 15:13
 */
public class TestCompletableFuture extends WebMvcConfigurationSupport {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        System.out.println(CompletableFuture.completedFuture("test").get());

//        Thread.currentThread().join();
        Thread thread = new Thread(() ->{
            try {
                Thread.sleep(3000);
//                Thread.currentThread().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread.currentThread().setName("ZHL-1");
            System.out.println(String.format("新线程要结束了,1111%s",Thread.currentThread().getName()));
        });
        thread.setDaemon(true);
        thread.start();

        new Thread(() -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread.currentThread().setName("ZYYYY-1");
            System.out.println(String.format("第二个新线程，2222%s",Thread.currentThread().getName()));
        }).start();
        //设置守护线程



        thread.join();
        //join()方法底层依靠wait方法实现
//        Thread.currentThread().join();
//        Thread.currentThread().notifyAll();
        System.out.println("主线程结束了吗");

//        CompletableFuture<Object> future = new CompletableFuture<>();
//        future.thenRun(() -> {
//            System.out.println("Test thenRun");
//        });
//        System.out.println("1111");

        //Supplier的本质是在Java语言中引入了惰性计算的机制，为了在Java中实现等价的惰性计算
//        System.out.println(CompletableFuture.supplyAsync(() ->{
//            System.out.println("supplier 函数式接口测试");
//            System.out.println(Thread.currentThread().getName());
//            return 5555;
//        }).get());

        //怎么才能写出优秀的代码呢 逻辑清晰 有条理

//        List<Integer> list = Arrays.asList(1,2,4);
//        list.stream().findAny()
//        CountDownLatch
//        AtomicLong
    }
}