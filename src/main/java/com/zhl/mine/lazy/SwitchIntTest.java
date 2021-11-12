package com.zhl.mine.lazy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2021/11/8 10:17
 */
public class SwitchIntTest {

    public static void main(String[] args) {
        int a = 1;
        switch (a) {
            case 2 :
                System.out.println("print 2");
            case 1 :
                System.out.println("print 1");
            default:
                System.out.println("first default println");
            case 3 :
                System.out.println("print 3");
        }

        List<String> test = new ArrayList<>();
        test.add("z");
        test.add("h");
        test.add("l");
        test.removeIf("z" :: equals);
        test.stream().forEach(System.out :: println);
        AtomicInteger atomicInteger = new AtomicInteger();
    }
}