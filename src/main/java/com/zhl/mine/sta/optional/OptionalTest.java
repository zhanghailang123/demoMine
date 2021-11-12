package com.zhl.mine.sta.optional;


import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @description: Optional的使用
 * @author: zhanghailang
 * @date: 2021/8/10 10:15
 */
public class OptionalTest {


    public static void main(String[] args) {
//        String name = "zhl";
//        Optional<String> opt = Optional.ofNullable(name);
//        System.out.println(opt.get());
//        Map<String, String> map = new HashMap<String,String>();
//        map.put("Zhl","ZZ");
//        Optional<String> optMap = Optional.ofNullable(map.get("Zhl1"));
//        System.out.println(optMap);
//
//        String sex = null;
//        System.out.println(Optional.ofNullable(sex).orElse("zzz"));
//
//        Assert.notNull(sex,"sex 不可以为null");

        int a = 2;

        System.out.println(test(a)) ;
    }
    public static int test(int state){
        switch (state){
            case 1:
                return 1;
            case 2 :
            case 3 :
                return 3;
            default:
                return 5;
        }
    }
}