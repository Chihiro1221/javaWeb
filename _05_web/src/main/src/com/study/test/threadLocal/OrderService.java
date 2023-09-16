package com.study.test.threadLocal;

public class OrderService {
    public static void createOrder() {
        String name = Thread.currentThread().getName();
        System.out.println("OrderService中线程" + name + "存储的值是" + ThreadLocalTest.data.get());
    }
}
