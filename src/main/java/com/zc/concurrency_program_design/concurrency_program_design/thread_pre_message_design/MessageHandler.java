package com.zc.concurrency_program_design.concurrency_program_design.thread_pre_message_design;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.*;

/**
 * @author Grubby
 * @date 2018/12/19
 */
public class MessageHandler {

    private final static Random RANDOM = new Random(System.currentTimeMillis());

    private final static Executor EXECUTOR = newFixedThreadPool(5);

    public void request(Message message){
        EXECUTOR.execute(() -> {
            try {
                String value = message.getValue();
                TimeUnit.MILLISECONDS.sleep(RANDOM.nextInt(100));
                System.out.println("The message will be handle by " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 关闭线程池
     */
    public void shutdown(){
        ((ExecutorService)EXECUTOR).shutdown();
    }
}
