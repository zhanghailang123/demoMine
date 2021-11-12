package com.zhl.mine.thread;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/**
 * @description: 测试使用下注解@Async
 * @author: zhanghailang
 * @date: 2021/9/30 14:58
 */
@Service
public class TestAsync {


    /**
     * 使用了此注解的方法 返回值必须为void 或者 future
     *
     * 1.默认线程池的具体配置是什么
     *   applicationTaskExecutor 默认线程池
     * 2.源码是怎么做到只支持void 和 future
     * 3.value属性是干什么用的
     *
     *
     * @param num
     * @return
     */

    @Async("zhlThreadPool")
    public Future<String> testAsync(int num){
        System.out.println(Thread.currentThread().getName() + " : 这是一个@Async异步线程");
        return new AsyncResult<>("aaaaa" + num);
    }

    @Bean("zhlThreadPool")
    public Executor zhlThreadPool(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(8);
        taskExecutor.setMaxPoolSize(12);
        taskExecutor.setQueueCapacity(100);
        taskExecutor.setKeepAliveSeconds(60);
        taskExecutor.setThreadNamePrefix("ZHLThread-");
        taskExecutor.initialize();
        return taskExecutor;
    }
}