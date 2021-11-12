package com.zhl.mine.thread;

import lombok.Data;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @description:关于函数式编程的一些测试
 * @author: zhanghailang
 * @date: 2021/10/25 17:14
 */
public class LamdaTest {
    public static void main(String[] args) {
        //JDK 1.8之前的做法 Code And Code And Think
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("Test Zzz");

        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "1111";
            }
        };
        supplier.get();
        System.out.println(supplier.get());

        BiConsumer<String,String> biConsumer = new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                System.out.println(s + s2);
            }
        };

        biConsumer.accept("aa","bb");
        List<Integer> integers = Arrays.asList(1,2,3,4);
        Integer ta = integers.stream().reduce(0,Integer :: sum);
        Optional ta1 = integers.stream().reduce(Integer :: sum);
        System.out.println("求和：" + ta);
        System.out.println(ta1.get());
        integers.stream().map(String :: valueOf);
        List<String> test = integers.stream().map(item -> sum()).collect(Collectors.toList());
        test.forEach(consumer);

//        List<BigDecimal> test111 = Arrays.asList(BigDecimal.valueOf(0.01));
//        BigDecimal taskMoney = test111.stream().filter(item -> item != null && item.doubleValue() > 0).reduce(BigDecimal.ZERO,BigDecimal::add);
//        System.out.println(taskMoney);
//        System.out.println(BigDecimal.ZERO.add(BigDecimal.valueOf(0.01)));


        String testOptional = "testOptional";
        System.out.println(Optional.ofNullable(testOptional));

        String testRe = Optional.ofNullable(testOptional)
                .orElse("1111");

        Optional.ofNullable(testOptional)
                .flatMap(aa -> Optional.ofNullable(testOptional))
                .map(aa -> sum())
                .orElse("2222");
        System.out.println(testRe);

        user user = new user();
        user.add(1);
        System.out.println(user.add(1));
    }

    private static String sum(){
        return "Test Map To Sum";
    }

    @Data
    public static class user{
        private String username;
        private Integer sex;
        private Integer age;
        private void test(){
            BiConsumer aa = (sex,age) -> add(sex);
            aa.accept(1,1);
        }
        private <T> Integer add(T test1){
            return 5;
        }
    }

    private <T> T testLamda(BiConsumer<T,Integer> biConsumer,T aa){
        biConsumer.accept(aa,1);
        return null;
    }
}