package com.zc.concurrency_program_design.concurrency_program_design.worker_thread;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 将 worker 生产的东西放入 队里中
 * @author Grubby
 * @date 2018/12/27
 */
public class TransportThread extends Thread{

    private final MyQueue myQueue;

    private final  static Random random = new Random(System.currentTimeMillis());

    public TransportThread(String threadName,MyQueue myQueue) {
        super(threadName);
        this.myQueue = myQueue;
    }


    @Override
    public void run() {
        try {
            // 将request 放入 队列中
            for (int i = 0; true; i++) {
                Request request = new Request(getName(),i);
                this.myQueue.put(request);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
