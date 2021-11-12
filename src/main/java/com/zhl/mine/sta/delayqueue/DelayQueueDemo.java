package com.zhl.mine.sta.delayqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * @description: Keep Think
 * 努力 集中 专注 努力
 * 努力的方向
 * 坚持
 * 勤奋
 * 提升自己的Code能力
 * @author: zhanghailang
 * @date: 2021/8/9 15:57
 */
public class DelayQueueDemo {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("00000001");
        list.add("00000002");
        list.add("00000003");
        list.add("00000004");
        list.add("00000005");

        DelayQueue<OrderDelay> queue = new DelayQueue<>();

        long start = System.currentTimeMillis();
        for (int  i = 0; i < 5; i ++){
            queue.put(new OrderDelay(list.get(i), TimeUnit.NANOSECONDS.convert(3,TimeUnit.SECONDS)));
            try {
                queue.take().print();
                System.out.println("After " + (System.currentTimeMillis() - start) + " MilliSeconds");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}