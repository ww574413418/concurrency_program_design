package com.zc.concurrency_program_design.concurrency_program_design.future_design;

import java.util.concurrent.FutureTask;

/**
 * 获得任务线程的执行结果
 * @author Grubby
 * @date 2018/12/10
 */
public class FutureResult<T> implements Future{

    private T result;

    private boolean isOk = false;

    /**
     * 判断任务是否完成
     */
    @Override
    public T sendResult(){
        synchronized (this){
            try {
                // 判断任务是否完成
                while (!isOk){
                    this.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return result;
        }
    }

    /**
     * 获取任务的执行结果
     */
    public void receiveTaskResult(T result){
        synchronized (this){
            this.result = result;
            this.isOk = true;
            notifyAll();
        }
    }

}
