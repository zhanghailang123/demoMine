package com.zhl.mine.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: Guava令牌桶限流算法的测试实际使用
 * @author: zhanghailang
 * @date: 2021/8/9 14:04
 */
@RestController
public class RateLimitTestController {
    @GetMapping("/get")
    public void get(){
        System.out.println("test成功");
    }

    public static void main(String[] args) {
        char c = "https".charAt(0) ;
        System.out.println(c);
    }
}