package com.zc.concurrency_program_design.concurrency_program_design.worker_thread;


import java.util.Arrays;

/**
 * 自定义队列
 * @author Grubby
 * @date 2018/12/27
 */
public class MyQueue {
    /**
     * 队列默认长度
     */
    private final static int MAX_REQUEST = 100;
    /**
     * 队列
     */
    private final Request[] requestQueues;
    /**
     * 队头
     */
    private int head;
    /**
     * 队尾
     */
    private int tail;
    /**
     * 队列的实际大小
     */
    private int count;
    /**
     * 工人
     */
    private final WorkerPool[] workerPool;

    /**
     * @param workers 分配几个工人干活
     */
    public MyQueue(int workers) {
        this.requestQueues = new Request[MAX_REQUEST];
        this.workerPool = new WorkerPool[workers];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
        this.init();
    }

    /**
     * 初始化的时候 创建几个worker线程对象
     */
    private void init() {
        for (int i = 0; i < workerPool.length; i++) {
            workerPool[i] = new WorkerPool("Worker-"+i,this);
        }
    }

    /**
     * 启动在init方法中初始化的worker线程对象
     */
    public void startWork(){
        Arrays.asList(workerPool).stream().forEach(WorkerPool::start);
    }

    /**
     * 将数据存入队列
     * @param request
     */
    public synchronized void put(Request request){
        // 队列已经满了
        try {
            while (count >= requestQueues.length){
                this.wait();
            }
            // 将输入放入队尾中
            this.requestQueues[tail] = request;
            // 取余运算
            this.tail = (tail + 1) % requestQueues.length;
            this.count++;
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从队列中取出数据
     * @return
     */
    public synchronized Request get(){
        Request request = null;
        try {
            while (count <= 0){
                this.wait();
            }
            request = requestQueues[head];
            this.head = (this.head +1) % requestQueues.length;
            this.count--;
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return request;
    }
}
