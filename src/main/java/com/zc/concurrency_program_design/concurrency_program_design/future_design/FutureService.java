package com.zc.concurrency_program_design.concurrency_program_design.future_design;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * @author Grubby
 * @date 2018/12/20
 */
public class FutureService<T>{







    public Future<T> startTask1(Task<T> task){

        FutureResult<T> futureResult = new FutureResult<>();
        new Thread(() -> {
            try {
                System.out.println("Start the task");
                T result = task.doTask();
                TimeUnit.SECONDS.sleep(1);
                futureResult.receiveTaskResult(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        return futureResult;
    }


    public void startTask2(Task<T> task,Consumer<T> consumer) {

        new Thread(() -> {
            System.out.println("==== starting work ====");
            T result = task.doTask();
            consumer.accept(result);
        }).start();

    }
}
