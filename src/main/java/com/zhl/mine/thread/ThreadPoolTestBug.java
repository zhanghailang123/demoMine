package com.zhl.mine.thread;

import java.util.concurrent.*;

/**
 * @description:https://mp.weixin.qq.com/s/4yjqFrJWBxmma1j-DxDIrA
 * @author: zhanghailang
 * @date: 2021/11/10 17:20
 */
public class ThreadPoolTestBug {

    public static void main(String[] args) {
        final ThreadPoolTestBug threadPoolTestBug = new ThreadPoolTestBug();
        for (int i = 0; i < 8; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
//                    while (true) {
                        Future<String> future = null;
                        try {
                            future = threadPoolTestBug.submit();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        try {
                            String s = future.get();
                            System.out.println(s + "测试输出");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                    }
//                }
            }).start();
        }

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    System.gc();
//                }
//            }
//        }).start();
    }

    public Future<String> submit() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        FutureTask<String> task = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName());
                return System.currentTimeMillis() + "1111";
            }
        });
//        task.run();
//        System.out.println(task.get());
//        System.out.println((Future<String>) executor.submit(task).get());
        return (Future<String>) executor.submit(task);
        //Test JVM test future<String> executor.submit(task);
    }
}