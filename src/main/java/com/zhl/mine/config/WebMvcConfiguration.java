package com.zhl.mine.config;

import com.google.common.util.concurrent.RateLimiter;
import com.zhl.mine.handler.RateLimiterIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2021/8/9 14:35
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    //How to Improve myself
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new RateLimiterIntercepter(RateLimiter.create(1,1, TimeUnit.SECONDS))).addPathPatterns("/get");
//        WebMvcConfigurer.super.addInterceptors(registry);
    }
}