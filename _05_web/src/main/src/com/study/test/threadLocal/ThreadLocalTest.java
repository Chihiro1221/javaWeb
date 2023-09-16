package com.study.test.threadLocal;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadLocalTest {
    public final static ThreadLocal<Integer> data = new ThreadLocal<>();
    private static Random random = new Random();

    public static class Thread01 implements Runnable {

        @Override
        public void run() {
            int i = random.nextInt(1000);
            String name = Thread.currentThread().getName();
            System.out.println("线程" + name + "存储的值是" + i);
            data.set(i);

            OrderService.createOrder();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("线程" + name + "执行完之后存储的值是" + data.get());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; ++i) {
            new Thread(new Thread01()).start();
        }
    }
}
