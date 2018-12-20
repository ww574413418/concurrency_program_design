package com.zc.concurrency_program_design.concurrency_program_design.future_design;

import java.util.concurrent.TimeUnit;

/**
 * @author Grubby
 * @date 2018/12/20
 */
public class FutureClient {

    public static void main(String[] args) {

        FutureService service = new FutureService();

        service.startTask2(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "FINISH";
        },System.out::println);

        System.out.println("=================");
        System.out.println("do something work");
        System.out.println("=================");

        //System.out.println(future.sendResult());
    }
}
