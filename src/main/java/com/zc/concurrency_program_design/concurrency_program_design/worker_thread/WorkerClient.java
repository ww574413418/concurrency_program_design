package com.zc.concurrency_program_design.concurrency_program_design.worker_thread;

/**
 * @author Grubby
 * @date 2018/12/27
 */
public class WorkerClient {

    public static void main(String[] args) {
        final MyQueue queue = new MyQueue(5);
        queue.startWork();

        new TransportThread("alex",queue).start();
        new TransportThread("jack",queue).start();
        new TransportThread("tom",queue).start();
    }
}
