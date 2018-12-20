package com.zc.concurrency_program_design.concurrency_program_design.countdown_design;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Grubby
 * @date 2018/12/20
 */
public class JDKCountDown {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(10);
        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " is working");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            });
        }

        latch.await();
        System.out.println("=================");
        System.out.println("FINISH");
        System.out.println("=================");
        executorService.shutdown();
    }

}
