package com.zc.concurrency_program_design.concurrency_program_design.countdown_design;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Grubby
 * @date 2018/12/20
 */
public class MyCountDownClient {

    public static void main(String[] args) {
        MyCountDown myCountDown = new MyCountDown();

        ExecutorService service  = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            service.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " is working");
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myCountDown.countDown();
            });
        }

        myCountDown.await();
        System.out.println("=============");
        System.out.println("FINISH");
        System.out.println("=============");
        // 关闭线程池
        service.shutdown();
    }

}
