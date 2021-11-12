package com.zhl.mine.lazy;

/**
 * @description: 泛型测试
 * @author: zhanghailang
 * @date: 2021/11/5 10:53
 */
public class Point <T>{

    private T param1;

    private T param2;

    public T get(){
        return this.param2;
    }

    public void set(T arg){
        this.param1 = arg;
    }

    public static void main(String[] args) {
        Point<String> stringPoint = new Point<>();
        stringPoint.set("1111");
        String s = stringPoint.get();
        System.out.println(stringPoint.get());
    }
}