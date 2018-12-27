package com.zc.concurrency_program_design.concurrency_program_design.invarible_object;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author Grubby
 * @date 2018/12/24
 */
public class CounterClient2 {


    public static void main(String[] args) {

        IntegarAcumulator2 integerAcumulator2 = new IntegarAcumulator2();

        IntStream.range(0,2).forEach(item -> {
            new Thread(() -> {
                int inc = 1;
                while (true){
                    int oldValue = integerAcumulator2.getValue();
                    int result = integerAcumulator2.add(inc).getValue();
                    System.out.println(Thread.currentThread().getName() + " -> "  + result);
                    if (inc + oldValue != result){
                        System.out.println("ERROR" + oldValue + " + " + inc + " = " + result);
                    }
                    inc ++ ;
                    slowly();
                }
            },"Thread - " + item).start();
        });
    }

    private static void slowly() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
