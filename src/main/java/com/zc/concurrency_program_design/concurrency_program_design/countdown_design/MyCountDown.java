package com.zc.concurrency_program_design.concurrency_program_design.countdown_design;

/**
 * 自定义 countdown实现
 * @author Grubby
 * @date 2018/12/20\
 */
public class MyCountDown {

    private final static int DEFAULT_SIZE = 10;

    private final int limit;

    private volatile int counter = 0;

    public MyCountDown() {
        this(DEFAULT_SIZE);
    }

    public MyCountDown(int limit) {
        this.limit = limit;
    }

    public void countDown(){
        synchronized (this){
            this.counter++;
            this.notifyAll();
        }
    }

    public void await(){
        synchronized (this){
            try {
                while (counter != limit){
                    this.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
