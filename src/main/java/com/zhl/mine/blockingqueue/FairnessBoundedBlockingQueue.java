package com.zhl.mine.blockingqueue;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: 卫式方法
 * 1.任何方法都需要满足一定条件才可以执行
 * 2.执行方法前需要首先校验不等式，然后执行变更
 * 3.在执行完成后，校验是否满足后验不等式
 * @author: zhanghailang
 * @date: 2021/11/8 13:56
 */
public class FairnessBoundedBlockingQueue implements Queue {

//    protected int size;

    protected final int capacity;

    protected Node head;

    protected Node tail;

    protected final Object offerLock = new Object();
    protected int canOfferCount;
    protected int waitOfferCount;

    protected final Object pollLock = new Object();
    protected int canPollCount;
    protected int waitPollCount;

    public FairnessBoundedBlockingQueue(int capacity) {
        this.canOfferCount = capacity;
        this.canPollCount = 0;
        this.capacity = capacity;
        this.head = new Node(null);
        this.tail = head;
        this.waitOfferCount = 0;
        this.waitPollCount = 0;
    }

    public boolean offer(Object o) throws InterruptedException {
        synchronized (offerLock){
            while (canOfferCount <= 0){
                waitOfferCount++;
                offerLock.wait();
                waitOfferCount--;
            }
            Node node = new Node(o);
            tail.next = node;
            tail = node;
            --canOfferCount;
        }
        synchronized (pollLock){
            ++canPollCount;
//            pollLock.notifyAll();
            if (waitPollCount > 0) {
                pollLock.notify();
            }
        }

        return true;
    }

    public Object poll() throws InterruptedException {
        Object result = null;
        synchronized (pollLock) {
            while (canPollCount <= 0){
                waitPollCount++;
                pollLock.wait();
                waitPollCount--;
            }
            result = head.next.value;
            head.next.value = null;
            head = head.next;
            --canPollCount;
        }
        synchronized (offerLock) {
            canOfferCount ++;
//            offerLock.notifyAll();
            if (waitOfferCount > 0) {
                offerLock.notify();
            }
        }
        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        //被讨厌的勇气
        //ArrayBlockingQueue 一般用于生产数据固定的场景
        //LinkedBlockingQueue 一般用于生产数据不固定的场景 数据量较大的场景
        LinkedBlockingQueue<Object> queue1 = new LinkedBlockingQueue<>(1);
        FairnessBoundedBlockingQueue queue = new FairnessBoundedBlockingQueue(5);
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    queue.offer(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                while (true){
                    System.out.println(queue.poll());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
        queue1.offer(1);
        queue1.offer(1);
        queue1.offer(1);
//        AtomicInteger
    }


    /**
     * 为了构建链表使用的节点而已
     */
    class Node {
        Object value;
        Node next;

        public Node(Object value) {
            this.value = value;
            next = null;
        }
    }
}