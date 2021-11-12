package com.zhl.mine.sta.keepthink;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

/**
 * @description: 限流算法值令牌桶算法
 * 1.计数器算法  分为固定窗口算法 和 滑动窗口算法
 * 2.漏桶算法
 * 3.令牌桶算法
 * @author: zhanghailang
 * @date: 2021/8/9 13:38
 */
public class LimitRate {
    public static void main(String[] args) {
        //每秒产生的令牌数
        //容量和突发量，令牌桶算法允许将一段时间内没有消费的令牌暂存到令牌中，用来突发消费
        RateLimiter limiter = RateLimiter.create(2);
        //阻塞的方式获取令牌
        System.out.println(limiter.acquire());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());


        System.out.println("开始平滑限流的测试");
        //渐进模式（SmoothWarmingUp）: 令牌生成速度缓慢提慢提升直到维持在一个稳定的值


        RateLimiter limiter1 = RateLimiter.create(2,10001, TimeUnit.MILLISECONDS);
        System.out.println(limiter1.acquire());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(limiter1.acquire());
        System.out.println(limiter1.acquire());
        System.out.println(limiter1.acquire());
        System.out.println(limiter1.acquire());

        System.out.println(limiter1.acquire());
        System.out.println(limiter1.acquire());


    }
}