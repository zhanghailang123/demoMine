package com.zhl.mine.sta.delayqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @description: JDK自带延时队列的使用处理
 * @author: zhanghailang
 * @date: 2021/8/9 15:43
 */
public class OrderDelay implements Delayed {

    private String orderId;

    private long timeout;

    public OrderDelay(String orderId, long timeout) {
        this.orderId = orderId;
        this.timeout = timeout + System.nanoTime();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(timeout - System.nanoTime(),TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if (o == this){
            return 0;
        }
        OrderDelay t = (OrderDelay) o;

        long d = (getDelay(TimeUnit.NANOSECONDS) - t.getDelay(TimeUnit.NANOSECONDS));


        return (d == 0) ? 0 : ((d < 1) ? -1 : 1);
    }

    void print(){
        System.out.println(orderId + "编号的订单即将删除。。。");
    }
}