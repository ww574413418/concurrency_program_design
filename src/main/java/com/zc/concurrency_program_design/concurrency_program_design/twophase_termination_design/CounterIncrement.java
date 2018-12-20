package com.zc.concurrency_program_design.concurrency_program_design.twophase_termination_design;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Grubby
 * @date 2018/12/19
 */
@Slf4j
public class CounterIncrement extends Thread{

    private volatile boolean terminated = false;

    private int counter = 0;

    private Random random = new Random(System.currentTimeMillis());

    @Override
    public void run() {
        try {
            while (!terminated){
                System.out.println(Thread.currentThread().getName() + " " + counter++);
                TimeUnit.MILLISECONDS.sleep(random.nextInt(100));
            }
        } catch (InterruptedException e) {
            log.info("the thread is interrupted ");
        } finally {
            this.clean();
        }
    }

    public void clean(){
        System.out.println("do some clean work for the second thread,current counter :" + counter);
    }

    public void close(){
        this.terminated = true;
        this.interrupt();
    }
}
