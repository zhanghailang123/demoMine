package com.zhl.mine.lazy;

import java.util.Collections;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @description:Supplier是Java为了实现惰性计算的一种方式
 * @author: zhanghailang
 * @date: 2021/11/2 11:29
 */
public class Lazy<T> implements Supplier<T> {

    private final Supplier<? extends T> supplier;

    private T value;

    public Lazy(Supplier<? extends T> supplier) {
        this.supplier = supplier;
    }

    public static <T> Lazy<T> of(Supplier<? extends T> supplier){
        return new Lazy<>(supplier);
    }

    @Override
    public T get() {
        if (value == null){
            T newValue = supplier.get();
            if (newValue == null){
                throw new IllegalStateException("Lazy value can be not null");
            }
            value = newValue;
        }
        return value;
    }

    public static void main(String[] args) {
        Lazy<String> lazy = new Lazy<String>(() -> Lazy.getString("zzz"));
        System.out.println(lazy.get());
        //表示接收一个参数并生成一个结果的函数
        //Function<? super T,? extends S> function
    }

    public static String getString(String s){
        return s + "1111";
    }

    public <S> Lazy<S> map(Function<? super T,? extends S> function){
        return Lazy.of(() -> function.apply(get()));
    }

    public <S> Lazy<S> flatMap(Function<? super T, Lazy<? extends S>> function){
        return Lazy.of(() -> function.apply(get()).get());
    }
}