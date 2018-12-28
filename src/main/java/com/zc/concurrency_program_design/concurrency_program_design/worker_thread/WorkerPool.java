package com.zc.concurrency_program_design.concurrency_program_design.worker_thread;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Grubby
 * @date
 */
public class WorkerPool extends Thread{

    private final MyQueue myQueue;

    private final Random random = new Random(System.currentTimeMillis());

    public WorkerPool(String threadName, MyQueue myQueue) {
        super(threadName);
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        while (true){
            try {
                myQueue.get().execute();
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1_000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
