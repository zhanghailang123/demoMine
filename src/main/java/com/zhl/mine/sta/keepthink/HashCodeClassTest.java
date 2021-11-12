package com.zhl.mine.sta.keepthink;

import java.util.HashSet;

/**
 * @description: 用Obejct做HashMap的key时需要做什么
 *      用自定义的类作为key，必须重写equals()和hashCode()方法
 *      自定义的类中的equals()和hashCode()都继承自Object类
 * @author: zhanghailang
 * @date: 2021/8/9 11:02
 */
public class HashCodeClassTest {
    //先理解一下HashCode() 和 Equals()方法

    public static void main(String[] args) {
        HashSet test = new HashSet<>();
        test.add(new A());
        test.add(new A());
//        System.out.println(test);

        test.add(new B());
        test.add(new B());
//        System.out.println(test);

        test.add(new C());
        test.add(new C());
        System.out.println(test);
    }

    static class A {
        //类A的 equals 方法总是返回true，但没有重写其HashCode()方法
        @Override
        public boolean equals(Object obj) {
            return true;
        }
    }

    static class B {
        //类B的 hashCode() 方法总是返回 1，但没有重写其equals()方法
        @Override
        public int hashCode() {
            return 1;
        }
    }

    static class C {
        @Override
        public int hashCode() {
            return 2;
        }

        @Override
        public boolean equals(Object obj) {
            return true;
        }
    }
}